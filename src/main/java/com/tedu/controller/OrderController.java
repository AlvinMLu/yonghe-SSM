package com.tedu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tedu.pojo.Door;
import com.tedu.pojo.Order;
import com.tedu.service.DoorService;
import com.tedu.service.OrderService;

/* @Controller作用1： 将当前对象的创建交给spring管理
 * 作用2：作为控制层代码的标识
 */
@Controller
public class OrderController {
	@Autowired // 自动注入(由spring创建对象并为属性赋值)
	private OrderService orderService;
	@Autowired // 自动注入(由spring创建当前对象)
	private DoorService doorService;

	/** 1.查询所有订单信息 */
	@RequestMapping("/orderList")
	public String orderList(Model model) {
		// 1.调用OrderService层的findAll方法查询所有订单
		List<Order> list = orderService.findAll();
		// 2.将所有订单的list集合存入Model中(存入request域中)
		model.addAttribute("list", list);
		// 3.查询所有门店
		List<Door> doorlist = doorService.findAll();
		// 4.将所有订单的list集合存入Model中(存入request域中)
		model.addAttribute("doorList", doorlist);
		// 5.转向订单列表页面
		return "order_list";
	}

	/** 2.1.添加订单信息 -- 查询所有门店并跳转到添加订单页面 */
	@RequestMapping("/findAllDoorToOrderAdd")
	public String toDoorAdd(Model model) {
		// 1.调用doorService的findAll方法, 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 2.将所有门店List存入model中
		model.addAttribute("doorList", doorList);
		return "order_add";
	}

	/** 2.2添加订单信息 -- 新增订单信息 */
	@RequestMapping("/orderAdd")
	public String orderAdd(Order order) {
		// 1.调用service层的addOrder方法，新增订单信息
		orderService.addOrder(order);
		// 2.重定向到订单列表页面, 显示所有订单信息
		return "redirect:/orderList";
	}

	/** 3.根据id删除订单信息 */
	@RequestMapping("/orderDelete")
	public String orderDelete(Integer id) {
		// 1.调用service层的deleteById方法，删除指定id的订单信息
		orderService.deleteById(id);
		// 2.重定向到订单列表页面, 显示所有订单信息
		return "redirect:/orderList";
	}

	/** 4.根据id查询订单信息 */
	@RequestMapping("/orderInfo")
	public String orderInfo(Integer id, Model model) {
		// 1.调用doorService的findAll方法, 查询所有门店信息
		List<Door> doorList = doorService.findAll();
		// 2.将所有门店List存入model中
		model.addAttribute("doorList", doorList);
		// 3.调用service层的findyId方法，根据id查询订单信息
		Order order = orderService.findById(id);
		// 4.将订单信息保存到Model中
		model.addAttribute("order", order);
		// 5.将订单信息带到order_update.jsp进行回显
		return "order_update";
	}

	/** 5.根据id更新订单信息 */
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Order order) {
		// 1.调用service层的updateById方法，根据id跟新订单信息
		orderService.updateById(order);
		// 2.重定向到订单列表页面, 显示所有订单信息
		return "redirect:/orderList";
	}

}
