/**
 * 
 */
$(function() {
	initData();
});

// 加载初始化数据
function initData() {
	$.ajax({
		type : 'GET',
		dataType : "json",
		url : "/api/cates/getall",
		/*
		 * data:{ email:$("#email").val(), password:$("#password").val() },
		 */
		success : function(res) {
			if (res.code == "0") {
				var str = '<li class="active"><a href="#">首页</a></li>';
				console.log(res);
				var info = res.data;
				console.log(info);
				$.each(info, function (index, goods) {
					str += '<li><a href="#">' + goods.catename + '</a></li>'
		        })
		        $("#nav_cate").html(str);
			} else {
				alert("加载数据出错，请刷新重试");
			}
		},
		error : function() {
			alert("发生错误"+jqXHR.status);
		}
	});
}