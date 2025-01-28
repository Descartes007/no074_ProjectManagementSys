package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiangmujinduEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiangmujinduVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiangmujinduView;


/**
 * 项目进度
 *
 * @author 
 * @email 
 * @date 2024-10-04 23:58:04
 */
public interface XiangmujinduService extends IService<XiangmujinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiangmujinduVO> selectListVO(Wrapper<XiangmujinduEntity> wrapper);
   	
   	XiangmujinduVO selectVO(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
   	
   	List<XiangmujinduView> selectListView(Wrapper<XiangmujinduEntity> wrapper);
   	
   	XiangmujinduView selectView(@Param("ew") Wrapper<XiangmujinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiangmujinduEntity> wrapper);

   	

}

