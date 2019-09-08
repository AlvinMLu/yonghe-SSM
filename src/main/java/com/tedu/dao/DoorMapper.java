package com.tedu.dao;

import java.util.List;
import com.tedu.pojo.Door;

/**
 * DoorMapper接口 声明增删改查方法,对门店信息进行操作
 */
public interface DoorMapper {
	/**
	 * 1.查询所有门店信息
	 */
	public List<Door> findAll();

	/**
	 * 2.新增门店信息
	 * 
	 * @param door
	 */
	public void addDoor(Door door);

	/**
	 * 3.根据id删除指定门店信息
	 * 
	 * @param id
	 */
	public void deleteById(Integer id);

	/**
	 * 4.根据id查询门店信息
	 * 
	 * @param id
	 */
	public Door findById(Integer id);

	/**
	 * 5.根据id更新门店信息
	 * 
	 * @param door
	 */
	public void updateById(Door door);

}
