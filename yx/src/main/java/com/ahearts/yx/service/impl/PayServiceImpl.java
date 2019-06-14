package com.ahearts.yx.service.impl;

import org.springframework.stereotype.Service;

import com.ahearts.yx.domain.AlipayBean;
import com.ahearts.yx.util.AlipayUtil;
import com.alipay.api.AlipayApiException;

/* 支付服务 */
@Service(value = "alipayOrderService")
public class PayServiceImpl  {
	public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
		return AlipayUtil.connect(alipayBean);
	}
}
