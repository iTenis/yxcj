package com.ahearts.yx.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahearts.yx.domain.AlipayBean;
import com.ahearts.yx.service.impl.PayServiceImpl;
import com.alipay.api.AlipayApiException;

/* 订单接口 */
@RestController()
@RequestMapping("order")
public class OrderController {
	@Resource
	private PayServiceImpl payService;// 调用支付服务
	/* 阿里支付 */

	@PostMapping(value = "alipay")
	public String alipay(String out_trade_no, String subject, String total_amount, String body)
			throws AlipayApiException {
		return payService.aliPay(new AlipayBean().setBody(body).setOut_trade_no(out_trade_no)
				.setTotal_amount(new StringBuffer().append(total_amount)).setSubject(subject));
	}
}
