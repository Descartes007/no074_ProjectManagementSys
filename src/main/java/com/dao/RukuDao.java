package com.dao;

import com.entity.RukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RukuVO;
import com.entity.view.RukuView;


/**
 * 入库
 * 
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
public interface RukuDao extends BaseMapper<RukuEntity> {
	
	List<RukuVO> selectListVO(@Param("ew") Wrapper<RukuEntity> wrapper);
	
	RukuVO selectVO(@Param("ew") Wrapper<RukuEntity> wrapper);
	
	List<RukuView> selectListView(@Param("ew") Wrapper<RukuEntity> wrapper);

	List<RukuView> selectListView(Pagination page,@Param("ew") Wrapper<RukuEntity> wrapper);

	
	RukuView selectView(@Param("ew") Wrapper<RukuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RukuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RukuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<RukuEntity> wrapper);



}
