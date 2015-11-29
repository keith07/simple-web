package edu.keith.mvc.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.keith.mvc.goods.dao.GoodsDao;
import edu.keith.mvc.goods.entity.Goods;
import edu.keith.mvc.goods.service.IGoodsService;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private GoodsDao dao;
	@Override
	public int save(Goods goods) {
		return dao.save(goods);
	}

	@Override
	public List<Goods> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Goods> findByName(String name) {
		return dao.searchByName(name);
	}

	@Override
	public Goods get(int sid) {
		return dao.get(sid);
	}

	@Override
	public boolean isNameExist(String name) {
		return dao.findByName(name).size() > 0;
	}

}
