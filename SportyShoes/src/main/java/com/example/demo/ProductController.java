package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@Autowired
	ProductDAO dao;
	Logger log=Logger.getAnonymousLogger();
	@RequestMapping("insert")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		String pid=request.getParameter("productId");
		String pname=request.getParameter("product Name");
		log.info("received id and name from front end");
		ModelAndView mv=new ModelAndView();
		log.info("Model And View object created");
		Product p=new Product();
		log.info("pojo object created");
		p.setProductId(pid);
		log.info("setting product id value");
		p.setProductName(pname);
		log.info("setting name of product");
		Product pd=dao.insertProduct(p);
		log.info("insert method invoked successfully");
		if(pd!=null) {
		log.info("insertion successful");
		mv.setViewName("status");
		}
		return mv;
		
	}
	
	@RequestMapping("retrieve")
	public ModelAndView getAllProducts(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		log.info("Model And View object created");
		List<Product> list=dao.getAll();
		log.info("getAll method invoked");
		mv.setViewName("display");
		log.info("redirect to jsp page");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping("update")
	public @ResponseBody ModelAndView updateProducts(HttpServletRequest request,HttpServletResponse response) {
		int sn=Integer.parseInt(request.getParameter("sno"));
		String pid=request.getParameter("productId");
		String pname=request.getParameter("productName");
		ModelAndView mv=new ModelAndView();
		log.info("Model And View object created");
		Product p=new Product();
		log.info("pojo object created");
		p.setSNo(sn);
		p.setProductId(pid);
		log.info("setting product id value");
		p.setProductName(pname);
		log.info("setting name of product");
		Product pd=dao.updateProduct(p);
		log.info("update method invoked successfully");
		if(pd!=null) {
			log.info("update successfully");
			
			mv.setViewName("status");
			
		}
		
		return mv;
		
		
	}
	
}
