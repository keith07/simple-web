package edu.keith.mvc.goods.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.keith.mvc.goods.entity.Goods;
import edu.keith.mvc.goods.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private IGoodsService service;

	@RequestMapping("/list")
	public String toList(Map<String,Object> model,HttpServletRequest request){
		List<Goods> _goods = service.getAll();
		String goodses = JSONArray.fromObject(_goods).toString();
		model.put("goodses", goodses);
		return "/goods/overview";
	}
	@RequestMapping("/add")
	public String toAdd(){
		return "/goods/add";
	}
	@RequestMapping("/{sid}/view")
	public String toView(Map<String,Object> model,@PathVariable int sid){
		Goods _goods = service.get(String.valueOf(sid));
		model.put("goods", JSONObject.fromObject(_goods).toString());
		return "/goods/view";
	}
	@RequestMapping("/save")
	@ResponseBody
	public Map<String,Object> save(Goods goods, Map<String,Object> model,HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		int r = service.save(goods);
		if(r > 0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		return result;
	}
	
	@RequestMapping("/exists")
	@ResponseBody
	public boolean checkName(@RequestBody String name){
		boolean result = service.isNameExist(name);
		return result;
	}
}
