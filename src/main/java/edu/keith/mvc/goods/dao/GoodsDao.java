package edu.keith.mvc.goods.dao;

import java.util.List;

import edu.keith.mvc.goods.entity.Goods;

public interface GoodsDao {

	/**
	 * 保存
	 * @param goods
	 * @return
	 */
	public int save(Goods goods);
	/**
	 * 更新
	 * @param goods
	 * @return
	 */
	public int update(Goods goods);
	/**
	 * 获取全部
	 * @return
	 */
	public List<Goods> getAll();
	/**
	 * 根据名字查询（准确查询）
	 * @param name
	 * @return
	 */
	public List<Goods> findByName(String name);
	/**
	 * 根据名字查询（模糊查询）
	 * @param name
	 * @return
	 */
	public List<Goods> searchByName(String name);
	/**
	 * 根据id获取
	 * @param sid
	 * @return
	 */
	public Goods get(String sid);
	/**
	 * 根据id删除
	 * @param sid
	 * @return
	 */
	public int delete(String sid);
}
