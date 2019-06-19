/**
 * 
 */
$(function() {
//	getPageNext();
	timecountdown();
	navclick();
});

function timecountdown(){
	var date2 = new Date('2019/06/23 18:00');
	var date1 = new Date();
	var s1 = date1.getTime(),s2 = date2.getTime();
	var total = (s2 - s1)/1000;
	var day = parseInt(total / (24*60*60));//计算整数天数
	var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
	var hour = parseInt(afterDay/(60*60));//计算整数小时数
	var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
	var min = parseInt(afterHour/60);//计算整数分
	var afterMin = total - day*24*60*60 - hour*60*60 - min*60;//取得算出分后剩余的秒数
	$("#tdays").html(parseInt(day));
	$("#thours").html(parseInt(hour));
	$("#tmins").html(parseInt(min));
	$("#tsecs").html(parseInt(afterMin));
	var t1 = window.setInterval(timecountdown,1000);
}

function navclick(){
	var reurl = window.location.href;
//	console.log(reurl.split("/")[3]);
	if(reurl.split("/")[3] == 'product') {
		$('#nav_cate li:eq(2)').addClass('active')
	}
	switch (reurl.split("/")[3]) {
		case 'services':
		$('#nav_cate li:eq(1)').addClass('active').siblings().removeClass("active");
		break;
		case 'product':
			$('#nav_cate li:eq(2)').addClass('active').siblings().removeClass("active");
			break;
		default:
			break;
	}
	
	
}


function addCarts(id) {
	var sendData ={id:id};
	var html_str="";
	$.ajax({
		url:'/api/carts/add',
		type:'post',
		dataType:'json',
		contentType:"application/json",
		async:true,//异步请求
		cache:false,
		data:JSON.stringify(sendData),//使用变量sendData
		//执行成功的回调函数
		success:function(data) {
			alert(1);
			console.log(data);
//			var currentpage = data.currentpage;
//			var totalnum =  data.totalnum;
//			var pagesize = data.pagesize;
//			html_str = html_str + '<li><a href="#"><i class="fa fa-angle-left"></i></a></li>';
//			html_str = html_str + '<li class="active">'+data.currentpage+'</li>';
//			html_str = html_str + '<li><a href="#"><i class="fa fa-angle-right"></i></a></li>';
//			$("#pagination_index").html(html_str);
		},
		//执行失败或错误的回调函数
		error:function(data) {
			alert(2);
			console.log(data);
		}
	});
}
//function getPageNext(){
//	//定义变量sendData
//	var sendData ={id:"1",currentpage:"2",pagesize:"5"};
//	var html_str="";
//	$.ajax({
//		url:'/api/comments/getbyid',
//		type:'post',
//		dataType:'json',
//		contentType:"application/json",
//		async:true,//异步请求
//		cache:false,
//		data:JSON.stringify(sendData),//使用变量sendData
//		//执行成功的回调函数
//		success:function(data) {
//			console.log(data);
//			var currentpage = data.currentpage;
//			var totalnum =  data.totalnum;
//			var pagesize = data.pagesize;
//			html_str = html_str + '<li><a href="#"><i class="fa fa-angle-left"></i></a></li>';
//			html_str = html_str + '<li class="active">'+data.currentpage+'</li>';
//			html_str = html_str + '<li><a href="#"><i class="fa fa-angle-right"></i></a></li>';
//			$("#pagination_index").html(html_str);
//		},
//		//执行失败或错误的回调函数
//		error:function(data) {
//			console.log(data);
//		}
//	});
//}