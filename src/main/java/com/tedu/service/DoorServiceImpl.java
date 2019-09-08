package com.tedu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.dao.DoorMapper;
import com.tedu.pojo.Door;

/* @Service作用1： 将当前对象的创建交给spring管理
 * 作用2：作为业务层代码的标识
 */

@Service
public class DoorServiceImpl implements DoorService {
	@Autowired // 自动注入(由spring创建mapper对象并为属性赋值)
	private DoorMapper doorMapper;

	public List<Door> findAll() {
		// 1.调用DoorMapper的findAll方法，查询所有门店信息
		List<Door> list = doorMapper.findAll();
		// 2.将所有门店信息的List集合返回
		return list;

	}

	public void addDoor(Door door) {
		// 调用DoorMapper的addDoor方法，新增门店信息
		doorMapper.addDoor(door);
	}

	public void deleteById(Integer id) {
		// 调用DoorMapper的deleteById方法，根据id删除指定的门店信息
		doorMapper.deleteById(id);
	}

	public Door findById(Integer id) {
		// 调用DoorMapper的findById方法，根据id查询门店信息
		Door door = doorMapper.findById(id);
		return door;
	}

	public void updateById(Door door) {
		// 调用DoorMapper的updateById方法，根据id更新门店信息
		doorMapper.updateById(door);
	}

}
