package com.dao;

import com.entity.YuangongjixiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuangongjixiaoVO;
import com.entity.view.YuangongjixiaoView;


/**
 * 员工绩效
 * 
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
public interface YuangongjixiaoDao extends BaseMapper<YuangongjixiaoEntity> {
	
	List<YuangongjixiaoVO> selectListVO(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
	
	YuangongjixiaoVO selectVO(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
	
	List<YuangongjixiaoView> selectListView(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);

	List<YuangongjixiaoView> selectListView(Pagination page,@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);

	
	YuangongjixiaoView selectView(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);



}
