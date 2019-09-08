package com.tedu.service;

import java.util.List;
import com.tedu.pojo.Order;

/** OrderService接口 */
public interface OrderService {
	/**
	 * 1.查询所有订单信息
	 * 
	 * @return List<Order>
	 */
	public List<Order> findAll();

	/**
	 * 2.新增订单信息
	 * 
	 * @param order
	 */
	public void addOrder(Order order);

	/**
	 * 3.根据id删除指定的订单信息
	 * 
	 * @param id
	 */
	public void deleteById(Integer id);

	/**
	 * 4.根据id查询指定的订单信息
	 * 
	 * @param id
	 * @return
	 */
	public Order findById(Integer id);

	/**
	 * 5.根据id更新指定订单信息
	 * 
	 * @param order
	 */
	public void updateById(Order order);

}
