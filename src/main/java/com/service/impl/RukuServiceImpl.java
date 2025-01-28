package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.RukuDao;
import com.entity.RukuEntity;
import com.service.RukuService;
import com.entity.vo.RukuVO;
import com.entity.view.RukuView;

@Service("rukuService")
public class RukuServiceImpl extends ServiceImpl<RukuDao, RukuEntity> implements RukuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RukuEntity> page = this.selectPage(
                new Query<RukuEntity>(params).getPage(),
                new EntityWrapper<RukuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RukuEntity> wrapper) {
		  Page<RukuView> page =new Query<RukuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<RukuVO> selectListVO(Wrapper<RukuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public RukuVO selectVO(Wrapper<RukuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<RukuView> selectListView(Wrapper<RukuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RukuView selectView(Wrapper<RukuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<RukuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<RukuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<RukuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
