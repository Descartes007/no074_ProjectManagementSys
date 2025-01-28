package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuangongjixiaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuangongjixiaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuangongjixiaoView;


/**
 * 员工绩效
 *
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
public interface YuangongjixiaoService extends IService<YuangongjixiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuangongjixiaoVO> selectListVO(Wrapper<YuangongjixiaoEntity> wrapper);
   	
   	YuangongjixiaoVO selectVO(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
   	
   	List<YuangongjixiaoView> selectListView(Wrapper<YuangongjixiaoEntity> wrapper);
   	
   	YuangongjixiaoView selectView(@Param("ew") Wrapper<YuangongjixiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuangongjixiaoEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YuangongjixiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YuangongjixiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YuangongjixiaoEntity> wrapper);



}

