package com.main.common.util;

import java.util.Random;

/**
 * 
 * @author Administrator 任务标志code生成类
 */
public class RandomStrUtil {

	/**
	 * 生成任务标志
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomNumber(int length) {
		String str = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(10);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * java生成随机数字和字母组合
	 * 
	 * @param length
	 *            [生成随机数的长度]
	 * @return
	 */
	public static String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	/**
	 * 生成任务代码
	 * 
	 * @param numLength
	 * @param strNum
	 * @return
	 */
	public static String getTaskCode() {
		String numRandon = getRandomNumber(5);
		String strRandon = getCharAndNumr(27);
		return numRandon + strRandon;
	}

	public static void main(String[] args) {
		System.out.println(getTaskCode());
	}
}
