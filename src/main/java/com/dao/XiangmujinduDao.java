package com.dao;

import com.entity.XiangmujinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmujinduVO;
import com.entity.view.XiangmujinduView;


/**
 * 项目进度
 * 
 * @author 
 * @email 
 * @date 2024-10-04 23:58:04
 */
public interface XiangmujinduDao extends BaseMapper<XiangmujinduEntity> {
	
	List<XiangmujinduVO> selectListVO(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
	
	XiangmujinduVO selectVO(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
	
	List<XiangmujinduView> selectListView(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);

	List<XiangmujinduView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmujinduEntity> wrapper);

	
	XiangmujinduView selectView(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
	

}
