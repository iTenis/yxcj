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
//	INSERT INTO `yxtj`.`cates`(`cate_id`, `cate_name`, `cate_desc`) VALUES (1, '精油', '精油系列');
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
	
	@Select("SELECT * FROM user WHERE id = #{id}")
	@Results({
		@Result(column = "create_time",property = "createtime"),
		@Result(column = "brith_time",property = "brithtime")
	})
	Cates findById(int id);
	
	@Update("UPDATE user SET name=#{name} WHERE id = #{id}")
	void update(Cates user);
	
	@Delete("DELETE FROM user WHERE id = #{id}")
	void delete(int id);
}
