package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CaigouEntity;
import com.entity.view.CaigouView;

import com.service.CaigouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 采购
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
@RestController
@RequestMapping("/caigou")
public class CaigouController {
    @Autowired
    private CaigouService caigouService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CaigouEntity caigou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			caigou.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<CaigouEntity> ew = new EntityWrapper<CaigouEntity>();



		PageUtils page = caigouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caigou), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CaigouEntity caigou, 
		HttpServletRequest request){
        EntityWrapper<CaigouEntity> ew = new EntityWrapper<CaigouEntity>();

		PageUtils page = caigouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, caigou), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CaigouEntity caigou){
       	EntityWrapper<CaigouEntity> ew = new EntityWrapper<CaigouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( caigou, "caigou")); 
        return R.ok().put("data", caigouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CaigouEntity caigou){
        EntityWrapper< CaigouEntity> ew = new EntityWrapper< CaigouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( caigou, "caigou")); 
		CaigouView caigouView =  caigouService.selectView(ew);
		return R.ok("查询采购成功").put("data", caigouView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CaigouEntity caigou = caigouService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(caigou,deSens);
        return R.ok().put("data", caigou);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CaigouEntity caigou = caigouService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(caigou,deSens);
        return R.ok().put("data", caigou);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CaigouEntity caigou, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caigou);
        caigouService.insert(caigou);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CaigouEntity caigou, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(caigou);
        caigouService.insert(caigou);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CaigouEntity caigou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(caigou);
        caigouService.updateById(caigou);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<CaigouEntity> list = new ArrayList<CaigouEntity>();
        for(Long id : ids) {
            CaigouEntity caigou = caigouService.selectById(id);
            caigou.setSfsh(sfsh);
            caigou.setShhf(shhf);
            list.add(caigou);
        }
        caigouService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        caigouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
