package com.ahearts.yx.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ahearts.yx.domain.Carts;

public interface CartsMapper {

	@Insert("INSERT INTO carts(id, cart_userid, cart_goodsid, cart_time, cart_num) VALUES (#{id},#{cartuserid}, #{cartgoodsid}, #{carttime}, #{cartnum})")
	@Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")
	public int add(Carts carts);
	
	@Select("SELECT * FROM carts WHERE cart_userid = #{id}")
	@Results({
		@Result(column ="id",property = "id"),
		@Result(column ="cart_userid",property = "cartuserid"),
		@Result(column ="cart_goodsid",property = "cartgoodsid"),
		@Result(column ="cart_time",property = "carttime"),
		@Result(column ="cart_num",property = "cartnum"),
		@Result(column = "cart_goodsid" ,property = "goods" ,one = @One(select = "com.ahearts.yx.mapper.GoodsMapper.findById"))
	})
	public List<Carts> getByUserId(int id);
	
	@Select("SELECT SUM(tmp.goods_price * tmp.cart_num ) from (select goods_price ,cart_num ,cart_userid from carts,goods WHERE carts.cart_goodsid=goods.id ) as tmp WHERE cart_userid = #{id}")
	public BigDecimal cartSumByUser(int id);
	
	
	@Select("SELECT * FROM (SELECT cart_time, cart_userid,cart_goodsid,SUM(cart_num) as cart_goodsnum FROM carts GROUP BY cart_userid,cart_goodsid ) a WHERE a.cart_userid=#{id}")
	@Results({
		@Result(column ="cart_userid",property = "cartuserid"),
		@Result(column ="cart_goodsid",property = "cartgoodsid"),
		@Result(column ="cart_time",property = "carttime"),
		@Result(column ="cart_goodsnum",property = "cartnum"),
		@Result(column = "cart_goodsid" ,property = "goods" ,one = @One(select = "com.ahearts.yx.mapper.GoodsMapper.findById"))
	})
	public List<Carts> getByCartsAgg(int id);
	
	/**
	 * 删除某用户下的某个商品
	 * @param uid	用户id
	 * @param gid	商品id
	 */
	@Delete("DELETE FROM carts WHERE  cart_userid = #{uid} AND cart_goodsid = #{gid}")
	void delete(int uid,int gid);
}
