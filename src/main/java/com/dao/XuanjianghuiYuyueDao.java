package com.dao;

import com.entity.XuanjianghuiYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanjianghuiYuyueView;

/**
 * 宣讲会报名 Dao 接口
 *
 * @author 
 */
public interface XuanjianghuiYuyueDao extends BaseMapper<XuanjianghuiYuyueEntity> {

   List<XuanjianghuiYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
