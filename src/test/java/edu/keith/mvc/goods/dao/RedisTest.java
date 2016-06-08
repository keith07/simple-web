package edu.keith.mvc.goods.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.keith.mvc.goods.entity.Goods;


/** 
 * 测试
 * @author http://blog.csdn.net/java2000_wl 
 * @version <b>1.0</b> 
 */  
@ContextConfiguration(locations = {"classpath*:testApplicationContext.xml"})
public class RedisTest extends AbstractJUnit4SpringContextTests{
	
	/**
	 * 新增
	 * <br>------------------------------<br>
	 */
	@Test
	public void testAdd() {
		System.out.println("start!");
		RedisGoodsDao dao = (RedisGoodsDao) applicationContext.getBean("redisGoodsDao");;
		Goods goods = new Goods();
		goods.setSid(21);
		goods.setName("name");
		goods.setKeyWord("收到 似懂非懂");
		goods.setSelfDescribe("神鼎飞丹砂");
		boolean result = dao.put(goods);
		Assert.assertTrue(result);
		Goods goods2 = dao.get(21);
		Assert.assertEquals(goods.getName(), goods2.getName());
		Assert.assertEquals(goods.getKeyWord(), goods2.getKeyWord());
		Assert.assertEquals(goods.getSelfDescribe(), goods2.getSelfDescribe());
	}
}
