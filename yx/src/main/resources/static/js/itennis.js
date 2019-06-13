/**
 * 
 */
$(function() {
	timecountdown();
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
}
var t1 = window.setInterval(timecountdown,1000);

