package edu.keith.mvc.goods.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import edu.keith.mvc.goods.dao.GoodsDao;
import edu.keith.mvc.goods.entity.Goods;
import edu.keith.mvc.goods.service.IGoodsService;

@Service
public class GoodsService implements IGoodsService {

	@Autowired
	private GoodsDao dao;
//	@Autowired
//	private RedisGoodsDao rDao;
	Logger log = Logger.getLogger(GoodsService.class);
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
	@Cacheable(value = "default",key="'edu.keith.mvc.goods.entity.Goods#'+#sid")
	public Goods get(String sid) {
//		Goods goods = rDao.get(sid);
//		if(goods == null){
//			log.info("goods with id {"+sid+"} not found in redis");
//			goods = dao.get(sid);
//			rDao.put(goods);
//		}
		
		return dao.get(sid);
	}

	@Override
	public boolean isNameExist(String name) {
		return dao.findByName(name).size() > 0;
	}

}
