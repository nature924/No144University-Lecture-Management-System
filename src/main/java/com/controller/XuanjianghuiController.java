
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 宣讲会
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanjianghui")
public class XuanjianghuiController {
    private static final Logger logger = LoggerFactory.getLogger(XuanjianghuiController.class);

    private static final String TABLE_NAME = "xuanjianghui";

    @Autowired
    private XuanjianghuiService xuanjianghuiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DangqianqingkuangService dangqianqingkuangService;//就业情况
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GongsiService gongsiService;//企业
    @Autowired
    private NewsService newsService;//公告信息
    @Autowired
    private XuanjianghuiCollectionService xuanjianghuiCollectionService;//宣讲会收藏
    @Autowired
    private XuanjianghuiYuyueService xuanjianghuiYuyueService;//宣讲会报名
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("企业".equals(role))
            params.put("gongsiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xuanjianghuiService.queryPage(params);

        //字典表数据转换
        List<XuanjianghuiView> list =(List<XuanjianghuiView>)page.getList();
        for(XuanjianghuiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanjianghuiEntity xuanjianghui = xuanjianghuiService.selectById(id);
        if(xuanjianghui !=null){
            //entity转view
            XuanjianghuiView view = new XuanjianghuiView();
            BeanUtils.copyProperties( xuanjianghui , view );//把实体数据重构到view中
            //级联表 企业
            //级联表
            GongsiEntity gongsi = gongsiService.selectById(xuanjianghui.getGongsiId());
            if(gongsi != null){
            BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "gongsiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGongsiId(gongsi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XuanjianghuiEntity xuanjianghui, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanjianghui:{}",this.getClass().getName(),xuanjianghui.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("企业".equals(role))
            xuanjianghui.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XuanjianghuiEntity> queryWrapper = new EntityWrapper<XuanjianghuiEntity>()
            .eq("gongsi_id", xuanjianghui.getGongsiId())
            .eq("xuanjianghui_name", xuanjianghui.getXuanjianghuiName())
            .eq("xuanjianghui_daiyu", xuanjianghui.getXuanjianghuiDaiyu())
            .eq("xuanjianghui_types", xuanjianghui.getXuanjianghuiTypes())
            .eq("zhuanye_types", xuanjianghui.getZhuanyeTypes())
            .eq("xuanjianghui_gangwei", xuanjianghui.getXuanjianghuiGangwei())
            .eq("xuanjianghui_renshu_number", xuanjianghui.getXuanjianghuiRenshuNumber())
            .eq("xianxia_types", xuanjianghui.getXianxiaTypes())
            .in("xuanjianghui_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanjianghuiEntity xuanjianghuiEntity = xuanjianghuiService.selectOne(queryWrapper);
        if(xuanjianghuiEntity==null){
            xuanjianghui.setXuanjianghuiYesnoTypes(1);
            xuanjianghui.setCreateTime(new Date());
            xuanjianghuiService.insert(xuanjianghui);
            return R.ok();
        }else {
            if(xuanjianghuiEntity.getXuanjianghuiYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(xuanjianghuiEntity.getXuanjianghuiYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanjianghuiEntity xuanjianghui, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuanjianghui:{}",this.getClass().getName(),xuanjianghui.toString());
        XuanjianghuiEntity oldXuanjianghuiEntity = xuanjianghuiService.selectById(xuanjianghui.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("企业".equals(role))
//            xuanjianghui.setGongsiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(xuanjianghui.getXuanjianghuiPhoto()) || "null".equals(xuanjianghui.getXuanjianghuiPhoto())){
                xuanjianghui.setXuanjianghuiPhoto(null);
        }

            xuanjianghuiService.updateById(xuanjianghui);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody XuanjianghuiEntity xuanjianghuiEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,xuanjianghuiEntity:{}",this.getClass().getName(),xuanjianghuiEntity.toString());

        XuanjianghuiEntity oldXuanjianghui = xuanjianghuiService.selectById(xuanjianghuiEntity.getId());//查询原先数据

//        if(xuanjianghuiEntity.getXuanjianghuiYesnoTypes() == 2){//通过
//            xuanjianghuiEntity.setXuanjianghuiTypes();
//        }else if(xuanjianghuiEntity.getXuanjianghuiYesnoTypes() == 3){//拒绝
//            xuanjianghuiEntity.setXuanjianghuiTypes();
//        }
        xuanjianghuiService.updateById(xuanjianghuiEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuanjianghuiEntity> oldXuanjianghuiList =xuanjianghuiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xuanjianghuiService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XuanjianghuiEntity> xuanjianghuiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XuanjianghuiEntity xuanjianghuiEntity = new XuanjianghuiEntity();
//                            xuanjianghuiEntity.setGongsiId(Integer.valueOf(data.get(0)));   //企业 要改的
//                            xuanjianghuiEntity.setXuanjianghuiName(data.get(0));                    //宣讲会标题 要改的
//                            xuanjianghuiEntity.setXuanjianghuiPhoto("");//详情和图片
//                            xuanjianghuiEntity.setXuanjianghuiDaiyu(data.get(0));                    //企业资质 要改的
//                            xuanjianghuiEntity.setXuanjianghuiTypes(Integer.valueOf(data.get(0)));   //宣讲会类型 要改的
//                            xuanjianghuiEntity.setZhuanyeTypes(Integer.valueOf(data.get(0)));   //专业 要改的
//                            xuanjianghuiEntity.setXuanjianghuiGangwei(data.get(0));                    //招聘岗位 要改的
//                            xuanjianghuiEntity.setXuanjianghuiRenshuNumber(Integer.valueOf(data.get(0)));   //招聘人数 要改的
//                            xuanjianghuiEntity.setXuanjianghuiTime(sdf.parse(data.get(0)));          //宣讲时间 要改的
//                            xuanjianghuiEntity.setXianxiaTypes(Integer.valueOf(data.get(0)));   //线下面试 要改的
//                            xuanjianghuiEntity.setXuanjianghuiContent("");//详情和图片
//                            xuanjianghuiEntity.setXuanjianghuiYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            xuanjianghuiEntity.setXuanjianghuiYesnoText(data.get(0));                    //审核回复 要改的
//                            xuanjianghuiEntity.setCreateTime(date);//时间
                            xuanjianghuiList.add(xuanjianghuiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xuanjianghuiService.insertBatch(xuanjianghuiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<XuanjianghuiView> returnXuanjianghuiViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = xuanjianghuiCollectionService.queryPage(params1);
        List<XuanjianghuiCollectionView> collectionViewsList =(List<XuanjianghuiCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XuanjianghuiCollectionView collectionView:collectionViewsList){
            Integer xuanjianghuiTypes = collectionView.getXuanjianghuiTypes();
            if(typeMap.containsKey(xuanjianghuiTypes)){
                typeMap.put(xuanjianghuiTypes,typeMap.get(xuanjianghuiTypes)+1);
            }else{
                typeMap.put(xuanjianghuiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xuanjianghuiTypes",type);
            PageUtils pageUtils1 = xuanjianghuiService.queryPage(params2);
            List<XuanjianghuiView> xuanjianghuiViewList =(List<XuanjianghuiView>)pageUtils1.getList();
            returnXuanjianghuiViewList.addAll(xuanjianghuiViewList);
            if(returnXuanjianghuiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xuanjianghuiService.queryPage(params);
        if(returnXuanjianghuiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXuanjianghuiViewList.size();//要添加的数量
            List<XuanjianghuiView> xuanjianghuiViewList =(List<XuanjianghuiView>)page.getList();
            for(XuanjianghuiView xuanjianghuiView:xuanjianghuiViewList){
                Boolean addFlag = true;
                for(XuanjianghuiView returnXuanjianghuiView:returnXuanjianghuiViewList){
                    if(returnXuanjianghuiView.getId().intValue() ==xuanjianghuiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXuanjianghuiViewList.add(xuanjianghuiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXuanjianghuiViewList = returnXuanjianghuiViewList.subList(0, limit);
        }

        for(XuanjianghuiView c:returnXuanjianghuiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXuanjianghuiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xuanjianghuiService.queryPage(params);

        //字典表数据转换
        List<XuanjianghuiView> list =(List<XuanjianghuiView>)page.getList();
        for(XuanjianghuiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanjianghuiEntity xuanjianghui = xuanjianghuiService.selectById(id);
            if(xuanjianghui !=null){


                //entity转view
                XuanjianghuiView view = new XuanjianghuiView();
                BeanUtils.copyProperties( xuanjianghui , view );//把实体数据重构到view中

                //级联表
                    GongsiEntity gongsi = gongsiService.selectById(xuanjianghui.getGongsiId());
                if(gongsi != null){
                    BeanUtils.copyProperties( gongsi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongsiId(gongsi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XuanjianghuiEntity xuanjianghui, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanjianghui:{}",this.getClass().getName(),xuanjianghui.toString());
        Wrapper<XuanjianghuiEntity> queryWrapper = new EntityWrapper<XuanjianghuiEntity>()
            .eq("gongsi_id", xuanjianghui.getGongsiId())
            .eq("xuanjianghui_name", xuanjianghui.getXuanjianghuiName())
            .eq("xuanjianghui_daiyu", xuanjianghui.getXuanjianghuiDaiyu())
            .eq("xuanjianghui_types", xuanjianghui.getXuanjianghuiTypes())
            .eq("zhuanye_types", xuanjianghui.getZhuanyeTypes())
            .eq("xuanjianghui_gangwei", xuanjianghui.getXuanjianghuiGangwei())
            .eq("xuanjianghui_renshu_number", xuanjianghui.getXuanjianghuiRenshuNumber())
            .eq("xianxia_types", xuanjianghui.getXianxiaTypes())
            .in("xuanjianghui_yesno_types", new Integer[]{1,2})
            .eq("xuanjianghui_yesno_text", xuanjianghui.getXuanjianghuiYesnoText())
//            .notIn("xuanjianghui_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanjianghuiEntity xuanjianghuiEntity = xuanjianghuiService.selectOne(queryWrapper);
        if(xuanjianghuiEntity==null){
            xuanjianghui.setXuanjianghuiYesnoTypes(1);
            xuanjianghui.setCreateTime(new Date());
        xuanjianghuiService.insert(xuanjianghui);

            return R.ok();
        }else {
            if(xuanjianghuiEntity.getXuanjianghuiYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(xuanjianghuiEntity.getXuanjianghuiYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

