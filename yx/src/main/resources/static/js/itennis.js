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
function addCarts(goodsid) {
	var cartshtml_head = "";
	var cartshtml_body = "";
	var cartshtml_foot = "";
	var sendData ={};
	sendData.id = goodsid;
	sendData.goodsnum = $("#goods_inputnum").val();
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
			console.log(data);
			if(data.code==200){
				alert("加入购物车成功");
				window.location.reload();
			}else{
				alert(data.msg+"，请刷新重试，谢谢！");
			}
		},
		//执行失败或错误的回调函数
		error:function(data) {
			alert("请登录重试");
		}
	});
}
$("#mobilePhone").blur(function () {
    var str = $(this).val();
    if (str != "" && str != null) {
        var re = /^1\d{10}$/;
        if (!re.test(str)) {
            $(this).val("");
            alert("手机号格式不正确");
            return;
        }
    }
});


$("#register_username").bind("input propertychange",function(event){
    $.ajax({
		url:'/api/users/getbyname?name='+ $("#register_username").val(),
		type:'get',
		dataType:'json',
		contentType:"application/json",
		async:true,//异步请求
		cache:false,
		//执行成功的回调函数
		success:function(data) {
			$("#register_username").css('color',data.data);
		},
		//执行失败或错误的回调函数
		error:function(data) {
			alert("请登录重试");
		}
	});
    
});

$(".updown_num").bind("input propertychange",function(event){
	alert(this.value);
//    $.ajax({
//		url:'/api/users/getbyname?name='+ $("#register_username").val(),
//		type:'get',
//		dataType:'json',
//		contentType:"application/json",
//		async:true,//异步请求
//		cache:false,
//		//执行成功的回调函数
//		success:function(data) {
//			$("#register_username").css('color',data.data);
//		},
//		//执行失败或错误的回调函数
//		error:function(data) {
//			alert("请登录重试");
//		}
//	});
    
});


/**
 * 删除购物车
 * @param uid
 * @param gid
 * @returns
 */
function deleteCarts(uid,gid){
	sendData = {}
	sendData.uid = uid;
	sendData.gid = gid;
	$.ajax({
		url:'/api/carts/delete',
		type:'post',
		dataType:'json',
		data:JSON.stringify(sendData),
		contentType:"application/json",
		async:true,
		cache:false,
		success:function(data){
//			$(this).closest('.order-col').remove()
//			$(this).parent(".order-col").remove();
			window.location.reload(); 
		},
		error:function(data){
			alert("请登录重试");
		}
	})
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