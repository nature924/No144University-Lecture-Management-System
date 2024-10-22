package com.dao;

import com.entity.XuanjianghuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanjianghuiView;

/**
 * 宣讲会 Dao 接口
 *
 * @author 
 */
public interface XuanjianghuiDao extends BaseMapper<XuanjianghuiEntity> {

   List<XuanjianghuiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
