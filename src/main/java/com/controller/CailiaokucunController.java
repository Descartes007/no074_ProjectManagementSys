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

import com.entity.CailiaokucunEntity;
import com.entity.view.CailiaokucunView;

import com.service.CailiaokucunService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 材料库存
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
@RestController
@RequestMapping("/cailiaokucun")
public class CailiaokucunController {
    @Autowired
    private CailiaokucunService cailiaokucunService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CailiaokucunEntity cailiaokucun,
		HttpServletRequest request){
        EntityWrapper<CailiaokucunEntity> ew = new EntityWrapper<CailiaokucunEntity>();



		PageUtils page = cailiaokucunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cailiaokucun), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CailiaokucunEntity cailiaokucun, 
		HttpServletRequest request){
        EntityWrapper<CailiaokucunEntity> ew = new EntityWrapper<CailiaokucunEntity>();

		PageUtils page = cailiaokucunService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cailiaokucun), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CailiaokucunEntity cailiaokucun){
       	EntityWrapper<CailiaokucunEntity> ew = new EntityWrapper<CailiaokucunEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cailiaokucun, "cailiaokucun")); 
        return R.ok().put("data", cailiaokucunService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CailiaokucunEntity cailiaokucun){
        EntityWrapper< CailiaokucunEntity> ew = new EntityWrapper< CailiaokucunEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cailiaokucun, "cailiaokucun")); 
		CailiaokucunView cailiaokucunView =  cailiaokucunService.selectView(ew);
		return R.ok("查询材料库存成功").put("data", cailiaokucunView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CailiaokucunEntity cailiaokucun = cailiaokucunService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(cailiaokucun,deSens);
        return R.ok().put("data", cailiaokucun);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CailiaokucunEntity cailiaokucun = cailiaokucunService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(cailiaokucun,deSens);
        return R.ok().put("data", cailiaokucun);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CailiaokucunEntity cailiaokucun, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(cailiaokucun);
        cailiaokucunService.insert(cailiaokucun);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CailiaokucunEntity cailiaokucun, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(cailiaokucun);
        cailiaokucunService.insert(cailiaokucun);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CailiaokucunEntity cailiaokucun, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cailiaokucun);
        cailiaokucunService.updateById(cailiaokucun);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cailiaokucunService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CailiaokucunEntity> wrapper = new EntityWrapper<CailiaokucunEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = cailiaokucunService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	











}
