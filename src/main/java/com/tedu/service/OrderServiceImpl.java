package com.tedu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tedu.dao.OrderMapper;
import com.tedu.pojo.Order;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired // 自动注入(由spring创建mapper对象并为属性赋值)
	private OrderMapper orderMapper;

	public List<Order> findAll() {
		// 1.调用OrderMapper的findAll方法，查询所有订单信息
		List<Order> list = orderMapper.findAll();
		// 2.将所有订单信息的List集合返回
		return list;
	}

	public void addOrder(Order order) {
		// 调用OrderMapper的addOrder方法，新增订单信息
		orderMapper.addOrder(order);

	}

	public void deleteById(Integer id) {
		// 调用OrderMapper的deleteById方法，根据id删除指定的订单信息
		orderMapper.deleteById(id);
	}

	public Order findById(Integer id) {
		// 调用OrderMapper的findById方法，根据id查询订单信息
		Order order = orderMapper.findById(id);
		return order;
	}

	public void updateById(Order order) {
		// 调用OrderMapper的updateById方法，根据id更新订单信息
		orderMapper.updateById(order);
	}

}
