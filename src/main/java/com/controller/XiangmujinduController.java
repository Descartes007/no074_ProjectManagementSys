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

import com.entity.XiangmujinduEntity;
import com.entity.view.XiangmujinduView;

import com.service.XiangmujinduService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 项目进度
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-04 23:58:04
 */
@RestController
@RequestMapping("/xiangmujindu")
public class XiangmujinduController {
    @Autowired
    private XiangmujinduService xiangmujinduService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmujinduEntity xiangmujindu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			xiangmujindu.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XiangmujinduEntity> ew = new EntityWrapper<XiangmujinduEntity>();



		PageUtils page = xiangmujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujindu), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiangmujinduEntity xiangmujindu, 
		HttpServletRequest request){
        EntityWrapper<XiangmujinduEntity> ew = new EntityWrapper<XiangmujinduEntity>();

		PageUtils page = xiangmujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujindu), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmujinduEntity xiangmujindu){
       	EntityWrapper<XiangmujinduEntity> ew = new EntityWrapper<XiangmujinduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmujindu, "xiangmujindu")); 
        return R.ok().put("data", xiangmujinduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmujinduEntity xiangmujindu){
        EntityWrapper< XiangmujinduEntity> ew = new EntityWrapper< XiangmujinduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmujindu, "xiangmujindu")); 
		XiangmujinduView xiangmujinduView =  xiangmujinduService.selectView(ew);
		return R.ok("查询项目进度成功").put("data", xiangmujinduView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmujinduEntity xiangmujindu = xiangmujinduService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xiangmujindu,deSens);
        return R.ok().put("data", xiangmujindu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmujinduEntity xiangmujindu = xiangmujinduService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(xiangmujindu,deSens);
        return R.ok().put("data", xiangmujindu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiangmujindu);
        xiangmujinduService.insert(xiangmujindu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xiangmujindu);
        xiangmujinduService.insert(xiangmujindu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujindu);
        xiangmujinduService.updateById(xiangmujindu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmujinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	











}
