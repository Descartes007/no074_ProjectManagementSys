package com.dao;

import com.entity.KaoqinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaoqinxinxiVO;
import com.entity.view.KaoqinxinxiView;


/**
 * 考勤信息
 * 
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
public interface KaoqinxinxiDao extends BaseMapper<KaoqinxinxiEntity> {
	
	List<KaoqinxinxiVO> selectListVO(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);
	
	KaoqinxinxiVO selectVO(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);
	
	List<KaoqinxinxiView> selectListView(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);

	List<KaoqinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);

	
	KaoqinxinxiView selectView(@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KaoqinxinxiEntity> wrapper);



}
