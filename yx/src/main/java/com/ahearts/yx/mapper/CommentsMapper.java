package com.ahearts.yx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.ahearts.yx.domain.Comments;
import com.ahearts.yx.domain.Goods;

public interface CommentsMapper {

	@Insert("INSERT INTO coments(comment_userid,comment_time,comment_content,comment_level,comment_goodsid,comment_isdelete) VALUES (#{commentuserid},#{commenttime},#{commentcontent},#{commentlevel},#{commentgoodsid},#{commentisdelete})")
	@Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")
	int insert(Comments comments);	
	
	@Select("SELECT * FROM comments WHERE comment_goodsid = #{id} ORDER BY comment_time DESC")
	@Results({
		@Result(column = "comment_userid",property = "commentuserid"),
		@Result(column = "comment_time",property = "commenttime"),
		@Result(column = "comment_content",property = "commentcontent"),
		@Result(column = "comment_level",property = "commentlevel"),
		@Result(column = "comment_goodsid",property = "commentgoodsid"),
		@Result(column = "comment_isdelete",property = "commentisdelete")
	})
	List<Comments> findById(int id);
	
	@Select("SELECT count(1) FROM comments")
	int total();
	
	
	@Select("SELECT * FROM comments WHERE comment_goodsid = #{id} ORDER BY comment_time DESC LIMIT #{currentpage},#{pagesize}")
	@Results({
		@Result(column = "comment_userid",property = "commentuserid"),
		@Result(column = "comment_time",property = "commenttime"),
		@Result(column = "comment_content",property = "commentcontent"),
		@Result(column = "comment_level",property = "commentlevel"),
		@Result(column = "comment_goodsid",property = "commentgoodsid"),
		@Result(column = "comment_isdelete",property = "commentisdelete")
	})
	List<Comments> pageNext(int id,int currentpage , int pagesize);
}
