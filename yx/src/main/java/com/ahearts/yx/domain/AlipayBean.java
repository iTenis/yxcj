package com.ahearts.yx.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/* 支付实体对象 */
@Data
@Accessors(chain = true)
public class AlipayBean {
	
	/* 商户订单号，必填 */
	private String out_trade_no;
	/* 订单名称，必填 */
	private String subject;
	/* 付款金额，必填 */
	private StringBuffer total_amount;
	/* 商品描述，可空 */
	private String body;
	/* 超时时间参数 */
	private String timeout_express = "10m";
	private String product_code = "FAST_INSTANT_TRADE_PAY";
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public AlipayBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		
		return this;
		
	}
	public String getSubject() {
		return subject;
	}
	public AlipayBean setSubject(String subject) {
		this.subject = subject;

		return this;
	}
	public StringBuffer getTotal_amount() {
		return total_amount;
	}
	public AlipayBean setTotal_amount(StringBuffer total_amount) {
		this.total_amount = total_amount;

		return this;
	}
	public String getBody() {
		return body;
	}
	public AlipayBean setBody(String body) {
		this.body = body;

		return this;
	}
	public String getTimeout_express() {
		return timeout_express;
	}
	public AlipayBean setTimeout_express(String timeout_express) {
		this.timeout_express = timeout_express;

		return this;
	}
	public String getProduct_code() {
		return product_code;
	}
	public AlipayBean setProduct_code(String product_code) {
		this.product_code = product_code;

		return this;
	}
	
	
	
	
	
}

