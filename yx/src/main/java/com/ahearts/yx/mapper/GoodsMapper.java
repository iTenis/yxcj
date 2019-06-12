package com.ahearts.yx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.ahearts.yx.domain.Goods;

public interface GoodsMapper {
	@Insert("INSERT INTO goods(id, goods_id, goods_name, goods_size, goods_cover, goods_num, goods_price, goods_desc, goods_preview, goods_istop, goods_cate_id,goods_isnew,goods_discunt) VALUES (#{id}, #{goodsid}, #{goodsname}, #{goodssize}, #{goodscover}, #{goodsnum}, #{goodsprice}, #{goodsdesc}, #{goodspreview}, #{goodsistop}, #{goodscateid},#{goodsisnew},#{goodsdiscount})")
	@Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")
	int insert(Goods goods);
	
	@Select("SELECT * FROM goods")
	@Results({
		@Result(column = "goods_id",property = "goodsid"),
		@Result(column = "goods_name",property = "goodsname"),
		@Result(column = "goods_size",property = "goodssize"),
		@Result(column = "goods_cover",property = "goodscover"),
		@Result(column = "goods_num",property = "goodsnum"),
		@Result(column = "goods_price",property = "goodsprice"),
		@Result(column = "goods_desc",property = "goodsdesc"),
		@Result(column = "goods_preview",property = "goodspreview"),
		@Result(column = "goods_istop",property = "goodsistop"),	
		@Result(column = "goods_isnew",property = "goodsisnew"),
		@Result(column = "goods_discount",property = "goodsdiscount"),
		@Result(column = "goods_cate_id",property = "cates",one = @One(select = "com.ahearts.yx.mapper.CatesMapper.findById",fetchType=FetchType.EAGER))
	})
	List<Goods> getAll();

	@Select("SELECT * FROM goods where id=#{id}")
	@Results({
		@Result(column = "goods_id",property = "goodsid"),
		@Result(column = "goods_name",property = "goodsname"),
		@Result(column = "goods_size",property = "goodssize"),
		@Result(column = "goods_cover",property = "goodscover"),
		@Result(column = "goods_num",property = "goodsnum"),
		@Result(column = "goods_price",property = "goodsprice"),
		@Result(column = "goods_desc",property = "goodsdesc"),
		@Result(column = "goods_preview",property = "goodspreview"),
		@Result(column = "goods_istop",property = "goodsistop"),	
		@Result(column = "goods_isnew",property = "goodsisnew"),
		@Result(column = "goods_discount",property = "goodsdiscount"),
		@Result(column = "goods_cate_id",property = "cates",one = @One(select = "com.ahearts.yx.mapper.CatesMapper.findById",fetchType=FetchType.EAGER))
	})
	Goods findById(int id);
	
	
	@Update("UPDATE goods SET goods_id = '#{goodsid}', goods_name = '#{goodsname}', goods_size = '#{goodssize}', goods_cover = '#{goodscover}', goods_num = #{goodsnum}, goods_price = #{goodsprice}, goods_desc = '#{goodsdesc}', goods_preview = '#{goodspreview}', goods_istop = #{goodsistop}, goods_cate_id = #{goodscateid} ,goods_isnew = #{goodsisnew} ,goods_discount = #{goodsdiscount} WHERE id = #{id}")
	void update(Goods goods);
	
	@Delete("DELETE FROM goods WHERE id = #{id}")
	void deleteById(int id);
	
	@Select("SELECT count(1) FROM goods")
	int total();
	
	@Select("SELECT * FROM goods LIMIT #{currentpage},#{pagesize}")
	List<Goods> pageNext(int currentpage , int pagesize);
	
}
