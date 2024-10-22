package com.dao;

import com.entity.XuanjianghuiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanjianghuiCollectionView;

/**
 * 宣讲会收藏 Dao 接口
 *
 * @author 
 */
public interface XuanjianghuiCollectionDao extends BaseMapper<XuanjianghuiCollectionEntity> {

   List<XuanjianghuiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
