package com.dao;

import com.entity.CailiaokucunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CailiaokucunVO;
import com.entity.view.CailiaokucunView;


/**
 * 材料库存
 * 
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
public interface CailiaokucunDao extends BaseMapper<CailiaokucunEntity> {
	
	List<CailiaokucunVO> selectListVO(@Param("ew") Wrapper<CailiaokucunEntity> wrapper);
	
	CailiaokucunVO selectVO(@Param("ew") Wrapper<CailiaokucunEntity> wrapper);
	
	List<CailiaokucunView> selectListView(@Param("ew") Wrapper<CailiaokucunEntity> wrapper);

	List<CailiaokucunView> selectListView(Pagination page,@Param("ew") Wrapper<CailiaokucunEntity> wrapper);

	
	CailiaokucunView selectView(@Param("ew") Wrapper<CailiaokucunEntity> wrapper);
	

}
