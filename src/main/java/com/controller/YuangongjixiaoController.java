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

import com.entity.YuangongjixiaoEntity;
import com.entity.view.YuangongjixiaoView;

import com.service.YuangongjixiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 员工绩效
 * 后端接口
 * @author 
 * @email 
 * @date 2024-10-04 23:58:05
 */
@RestController
@RequestMapping("/yuangongjixiao")
public class YuangongjixiaoController {
    @Autowired
    private YuangongjixiaoService yuangongjixiaoService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuangongjixiaoEntity yuangongjixiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			yuangongjixiao.setGonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();



		PageUtils page = yuangongjixiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuangongjixiaoEntity yuangongjixiao, 
		HttpServletRequest request){
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();

		PageUtils page = yuangongjixiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuangongjixiaoEntity yuangongjixiao){
       	EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuangongjixiao, "yuangongjixiao")); 
        return R.ok().put("data", yuangongjixiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuangongjixiaoEntity yuangongjixiao){
        EntityWrapper< YuangongjixiaoEntity> ew = new EntityWrapper< YuangongjixiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuangongjixiao, "yuangongjixiao")); 
		YuangongjixiaoView yuangongjixiaoView =  yuangongjixiaoService.selectView(ew);
		return R.ok("查询员工绩效成功").put("data", yuangongjixiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuangongjixiaoEntity yuangongjixiao = yuangongjixiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(yuangongjixiao,deSens);
        return R.ok().put("data", yuangongjixiao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuangongjixiaoEntity yuangongjixiao = yuangongjixiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(yuangongjixiao,deSens);
        return R.ok().put("data", yuangongjixiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuangongjixiao);
        yuangongjixiaoService.insert(yuangongjixiao);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yuangongjixiao);
        yuangongjixiaoService.insert(yuangongjixiao);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuangongjixiao);
        yuangongjixiaoService.updateById(yuangongjixiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuangongjixiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_yuangongjixiao_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
        String tableName = request.getSession().getAttribute("tableName").toString();
            if(tableName.equals("yuangong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
                                                        List<Map<String, Object>> result = yuangongjixiaoService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_yuangongjixiao_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
            if(tableName.equals("yuangong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
                                                    for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yuangongjixiaoService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
}
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_yuangongjixiao_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("yuangong")) {
                ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                                                                        List<Map<String, Object>> result = yuangongjixiaoService.selectTimeStatValue(params, ew);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            return R.ok().put("data", result);
        }
    }
    
        /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        java.nio.file.Path path = java.nio.file.Paths.get("value_yuangongjixiao_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            String[] yColumnNames = yColumnNameMul.split(",");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("timeStatType", timeStatType);
            List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
    String tableName = request.getSession().getAttribute("tableName").toString();
                        if(tableName.equals("yuangong")) {
                ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
            }
                                                                                                                                                for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = yuangongjixiaoService.selectTimeStatValue(params, ew);
                for(Map<String, Object> m : result) {
                    for(String k : m.keySet()) {
                        if(m.get(k) instanceof Date) {
                            m.put(k, sdf.format((Date)m.get(k)));
                        }
                    }
                }
                result2.add(result);
            }
            return R.ok().put("data", result2);
        }
    }
    
        /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("group_yuangongjixiao_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
String tableName = request.getSession().getAttribute("tableName").toString();
            if(tableName.equals("yuangong")) {
            ew.eq("gonghao", (String)request.getSession().getAttribute("username"));
        }
                                                        List<Map<String, Object>> result = yuangongjixiaoService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }    
    
    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,YuangongjixiaoEntity yuangongjixiao, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("yuangong")) {
            yuangongjixiao.setGonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<YuangongjixiaoEntity> ew = new EntityWrapper<YuangongjixiaoEntity>();
        int count = yuangongjixiaoService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuangongjixiao), params), params));
        return R.ok().put("data", count);
    }



}
