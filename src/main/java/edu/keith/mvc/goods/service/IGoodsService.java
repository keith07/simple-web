package edu.keith.mvc.goods.service;

import java.util.List;

import edu.keith.mvc.goods.entity.Goods;

public interface IGoodsService {

	/**
	 * 保存
	 * @param goods
	 * @return
	 */
	public int save(Goods goods);
	/**
	 * 获取全部
	 * @return
	 */
	public List<Goods> getAll();
	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	public List<Goods> findByName(String name);
	/**
	 * 判断名称是否存在
	 * @param name
	 * @return
	 */
	public boolean isNameExist(String name);
	/**
	 * 获取实体
	 * @param sid
	 * @return
	 */
	public Goods get(int sid);
}
