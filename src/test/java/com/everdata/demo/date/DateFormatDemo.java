/**
 * Copyright ©2021-2025 Eversec Corporation, All Rights Reserved
 * http://eversec.com.cn/
 */

package com.everdata.demo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;

/**
 * DateFormatDemo
 *
 * @author liujin
 * @date 2022/1/21 下午5:38
 */

public class DateFormatDemo {

	@Test
	public void test01() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'T'HHmmssX");

		System.out.println(sdf.parse("20211221T234400+08"));



	}
}