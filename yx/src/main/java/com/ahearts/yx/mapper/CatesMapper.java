package com.ahearts.yx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ahearts.yx.domain.Cates;



public interface CatesMapper {
	@Insert("INSERT INTO cates(cate_id,cate_name,cate_desc) VALUES (#{cateid},#{catename},#{catedesc})")
	@Options(useGeneratedKeys = true ,keyProperty = "cateid" ,keyColumn = "cate_id")
	int insert(Cates cates);
	
	@Select("SELECT * FROM cates")
	@Results({
		@Result(column = "cate_id",property = "cateid"),
		@Result(column = "cate_name",property = "catename"),
		@Result(column = "cate_desc",property = "catedesc")
	})
	List<Cates> getAll();
	
	@Select("SELECT * FROM cates WHERE cate_id = #{cateid}")
	@Results({
		@Result(column = "cate_id",property = "cateid"),
		@Result(column = "cate_name",property = "catename"),
		@Result(column = "cate_desc",property = "catedesc")
	})
	Cates findById(int id);
	
	@Update("UPDATE user SET cate_name=#{catename},cate_desc=#{catedesc} WHERE cate_id = #{cateid}")
	void update(Cates cate);
	
	@Delete("DELETE FROM cates WHERE cate_id = #{cateid}")
	void delete(int id);
}
