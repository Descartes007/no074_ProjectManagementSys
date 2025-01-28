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


import com.dao.YuangongjixiaoDao;
import com.entity.YuangongjixiaoEntity;
import com.service.YuangongjixiaoService;
import com.entity.vo.YuangongjixiaoVO;
import com.entity.view.YuangongjixiaoView;

@Service("yuangongjixiaoService")
public class YuangongjixiaoServiceImpl extends ServiceImpl<YuangongjixiaoDao, YuangongjixiaoEntity> implements YuangongjixiaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuangongjixiaoEntity> page = this.selectPage(
                new Query<YuangongjixiaoEntity>(params).getPage(),
                new EntityWrapper<YuangongjixiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuangongjixiaoEntity> wrapper) {
		  Page<YuangongjixiaoView> page =new Query<YuangongjixiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YuangongjixiaoVO> selectListVO(Wrapper<YuangongjixiaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YuangongjixiaoVO selectVO(Wrapper<YuangongjixiaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YuangongjixiaoView> selectListView(Wrapper<YuangongjixiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuangongjixiaoView selectView(Wrapper<YuangongjixiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YuangongjixiaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YuangongjixiaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YuangongjixiaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
