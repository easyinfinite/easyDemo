package com.spring.demo.action;

import com.spring.demo.service.IModifyService;
import com.spring.demo.service.IQueryService;
import com.spring.framework.annotation.DemoAutowired;
import com.spring.framework.annotation.DemoController;
import com.spring.framework.annotation.DemoRequestMapping;
import com.spring.framework.annotation.DemoRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公布接口url
 * @author Tom
 *
 */
@DemoController
@DemoRequestMapping("/web")
public class MyAction {

	@DemoAutowired
	IQueryService queryService;
	@DemoAutowired
	IModifyService modifyService;

	@DemoRequestMapping("/query.json")
	public void query(HttpServletRequest request, HttpServletResponse response,
								@DemoRequestParam("name") String name){
		String result = queryService.query(name);
		out(response,result);
	}
	
	@DemoRequestMapping("/add*.json")
	public void add(HttpServletRequest request,HttpServletResponse response,
			   @DemoRequestParam("name") String name,@DemoRequestParam("addr") String addr){
		String result = modifyService.add(name,addr);
		out(response,result);
	}
	
	@DemoRequestMapping("/remove.json")
	public void remove(HttpServletRequest request,HttpServletResponse response,
		   @DemoRequestParam("id") Integer id){
		String result = modifyService.remove(id);
		out(response,result);
	}
	
	@DemoRequestMapping("/edit.json")
	public void edit(HttpServletRequest request,HttpServletResponse response,
			@DemoRequestParam("id") Integer id,
			@DemoRequestParam("name") String name){
		String result = modifyService.edit(id,name);
		out(response,result);
	}
	
	
	
	private void out(HttpServletResponse resp,String str){
		try {
			resp.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
