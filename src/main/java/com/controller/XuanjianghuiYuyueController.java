
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
 * 宣讲会报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuanjianghuiYuyue")
public class XuanjianghuiYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(XuanjianghuiYuyueController.class);

    private static final String TABLE_NAME = "xuanjianghuiYuyue";

    @Autowired
    private XuanjianghuiYuyueService xuanjianghuiYuyueService;


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
    private XuanjianghuiService xuanjianghuiService;//宣讲会
    @Autowired
    private XuanjianghuiCollectionService xuanjianghuiCollectionService;//宣讲会收藏
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
        PageUtils page = xuanjianghuiYuyueService.queryPage(params);

        //字典表数据转换
        List<XuanjianghuiYuyueView> list =(List<XuanjianghuiYuyueView>)page.getList();
        for(XuanjianghuiYuyueView c:list){
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
        XuanjianghuiYuyueEntity xuanjianghuiYuyue = xuanjianghuiYuyueService.selectById(id);
        if(xuanjianghuiYuyue !=null){
            //entity转view
            XuanjianghuiYuyueView view = new XuanjianghuiYuyueView();
            BeanUtils.copyProperties( xuanjianghuiYuyue , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xuanjianghuiYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 宣讲会
            //级联表
            XuanjianghuiEntity xuanjianghui = xuanjianghuiService.selectById(xuanjianghuiYuyue.getXuanjianghuiId());
            if(xuanjianghui != null){
            BeanUtils.copyProperties( xuanjianghui , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXuanjianghuiId(xuanjianghui.getId());
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
    public R save(@RequestBody XuanjianghuiYuyueEntity xuanjianghuiYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuanjianghuiYuyue:{}",this.getClass().getName(),xuanjianghuiYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xuanjianghuiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XuanjianghuiYuyueEntity> queryWrapper = new EntityWrapper<XuanjianghuiYuyueEntity>()
            .eq("xuanjianghui_id", xuanjianghuiYuyue.getXuanjianghuiId())
            .eq("yonghu_id", xuanjianghuiYuyue.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanjianghuiYuyueEntity xuanjianghuiYuyueEntity = xuanjianghuiYuyueService.selectOne(queryWrapper);
        if(xuanjianghuiYuyueEntity==null){
            xuanjianghuiYuyue.setInsertTime(new Date());
            xuanjianghuiYuyue.setCreateTime(new Date());
            xuanjianghuiYuyueService.insert(xuanjianghuiYuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanjianghuiYuyueEntity xuanjianghuiYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xuanjianghuiYuyue:{}",this.getClass().getName(),xuanjianghuiYuyue.toString());
        XuanjianghuiYuyueEntity oldXuanjianghuiYuyueEntity = xuanjianghuiYuyueService.selectById(xuanjianghuiYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xuanjianghuiYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            xuanjianghuiYuyueService.updateById(xuanjianghuiYuyue);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XuanjianghuiYuyueEntity> oldXuanjianghuiYuyueList =xuanjianghuiYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xuanjianghuiYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<XuanjianghuiYuyueEntity> xuanjianghuiYuyueList = new ArrayList<>();//上传的东西
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
                            XuanjianghuiYuyueEntity xuanjianghuiYuyueEntity = new XuanjianghuiYuyueEntity();
//                            xuanjianghuiYuyueEntity.setXuanjianghuiYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            xuanjianghuiYuyueEntity.setXuanjianghuiId(Integer.valueOf(data.get(0)));   //宣讲会 要改的
//                            xuanjianghuiYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xuanjianghuiYuyueEntity.setInsertTime(date);//时间
//                            xuanjianghuiYuyueEntity.setCreateTime(date);//时间
                            xuanjianghuiYuyueList.add(xuanjianghuiYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("xuanjianghuiYuyueUuidNumber")){
                                    List<String> xuanjianghuiYuyueUuidNumber = seachFields.get("xuanjianghuiYuyueUuidNumber");
                                    xuanjianghuiYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> xuanjianghuiYuyueUuidNumber = new ArrayList<>();
                                    xuanjianghuiYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("xuanjianghuiYuyueUuidNumber",xuanjianghuiYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<XuanjianghuiYuyueEntity> xuanjianghuiYuyueEntities_xuanjianghuiYuyueUuidNumber = xuanjianghuiYuyueService.selectList(new EntityWrapper<XuanjianghuiYuyueEntity>().in("xuanjianghui_yuyue_uuid_number", seachFields.get("xuanjianghuiYuyueUuidNumber")));
                        if(xuanjianghuiYuyueEntities_xuanjianghuiYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XuanjianghuiYuyueEntity s:xuanjianghuiYuyueEntities_xuanjianghuiYuyueUuidNumber){
                                repeatFields.add(s.getXuanjianghuiYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xuanjianghuiYuyueService.insertBatch(xuanjianghuiYuyueList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xuanjianghuiYuyueService.queryPage(params);

        //字典表数据转换
        List<XuanjianghuiYuyueView> list =(List<XuanjianghuiYuyueView>)page.getList();
        for(XuanjianghuiYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XuanjianghuiYuyueEntity xuanjianghuiYuyue = xuanjianghuiYuyueService.selectById(id);
            if(xuanjianghuiYuyue !=null){


                //entity转view
                XuanjianghuiYuyueView view = new XuanjianghuiYuyueView();
                BeanUtils.copyProperties( xuanjianghuiYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xuanjianghuiYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    XuanjianghuiEntity xuanjianghui = xuanjianghuiService.selectById(xuanjianghuiYuyue.getXuanjianghuiId());
                if(xuanjianghui != null){
                    BeanUtils.copyProperties( xuanjianghui , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXuanjianghuiId(xuanjianghui.getId());
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
    public R add(@RequestBody XuanjianghuiYuyueEntity xuanjianghuiYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xuanjianghuiYuyue:{}",this.getClass().getName(),xuanjianghuiYuyue.toString());
        Wrapper<XuanjianghuiYuyueEntity> queryWrapper = new EntityWrapper<XuanjianghuiYuyueEntity>()
            .eq("xuanjianghui_yuyue_uuid_number", xuanjianghuiYuyue.getXuanjianghuiYuyueUuidNumber())
            .eq("xuanjianghui_id", xuanjianghuiYuyue.getXuanjianghuiId())
            .eq("yonghu_id", xuanjianghuiYuyue.getYonghuId())
//            .notIn("xuanjianghui_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanjianghuiYuyueEntity xuanjianghuiYuyueEntity = xuanjianghuiYuyueService.selectOne(queryWrapper);
        if(xuanjianghuiYuyueEntity==null){
            xuanjianghuiYuyue.setInsertTime(new Date());
            xuanjianghuiYuyue.setCreateTime(new Date());
        xuanjianghuiYuyueService.insert(xuanjianghuiYuyue);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

