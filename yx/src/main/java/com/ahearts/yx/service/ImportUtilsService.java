package com.ahearts.yx.service;

import java.io.InputStream;
import java.util.List;


public interface ImportUtilsService {
	public List getBankListByExcel(InputStream in, String fileName) throws Exception;
}
