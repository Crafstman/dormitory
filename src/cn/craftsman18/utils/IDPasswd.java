package cn.craftsman18.utils;

import java.text.DecimalFormat;
import java.util.Arrays;

/*
 * 对身份证号码进行加密
 * 思路：   年+66（最大支持9933年）
 * 		月*8+3（最大12月份，密文最大值99）
 * 		日*3+6（最大31号，密文最大值99）
 *  	身份掩码和城市互换 	
 */
public class IDPasswd {
	/**
	 * 加密身份信息
	 * 
	 * @param 身份证号码：IDCrad
	 * @return 加密后的信息:enID
	 * @author craftsman
	 * @date 2018年6月30日
	 */
	private static String encrypt(String IDCrad) {
		/*
		 * 转换前： 0-1 ： 省份 0 不改变 2-3 ： 城市 1 不改变 4-5 ： 区县 2 不改变 6-9 ： 年份 3,4 +66 最大值9933
		 * 10-11： 月份 5 *8+3 最大值99 12-13 ： 日 6 *3+6 最大值99 14-15 ： 派出所 7 不改变 16-17 ： 性别掩码
		 * 8 暂时不改变
		 */
		// 先校验,否则直接return null
		if (!checkID(IDCrad)) {
			System.out.println("校验失败！程序结束");
			System.exit(0);
		}
		IDCrad = IDCrad.replaceAll("\\s*", "");
		// 两位字符为单位转换为数组
		String[] id = new String[9];
		for (int i = 0; i < 9; i++) {
			id[i] = IDCrad.substring(i * 2, i * 2 + 2);
		}
		System.out.println("加密原文：" + Arrays.toString(id));

		// 格式化需要校验数据
		Integer year = Integer.valueOf(id[3] + id[4]); // 年份
		int month = Integer.valueOf(id[5]); // 月份
		int day = Integer.valueOf(id[6]); // 日期

		// 身份掩码和城市互换
		String tmp = id[1];
		id[1] = id[8];
		id[8] = tmp;

		// 年份加密
		year += 66;
		id[3] = year.toString().substring(0, 2);
		id[4] = year.toString().substring(2, 4);

		// 月份日期加密
		month = month * 8 + 3;
		day = day * 3 + 6;

		// 格式化并储存
		if (month > 99 || day > 99 || year > 9999 || month <= 0 || day <= 0 || year <= 0) {
			System.out.println("加密出错：终止加密");
			return null;
		} else {
			DecimalFormat f2 = new DecimalFormat("00");
			id[5] = f2.format(month);
			id[6] = f2.format(day);
		}

		System.out.println(year + "-" + month + "-" + day);

		// 格式化最终的数据并返回
		StringBuffer enID1 = new StringBuffer();
		for (String string : id) {
			enID1.append(string);
		}
		String enID = enID1.toString();
		System.out.println("加密密文：" + enID);

		return enID;
	}

	/**
	 * 校验身份证格式是否符合规范
	 * 
	 * @param 身份证号
	 * @return 真假
	 */
	private static boolean checkID(String IDCrad) {
		/*
		 * 转换前 0-1 ： 省份 0 2-3 ： 城市 1 4-5 ： 区县 2 6-9 ： 年份 3,4 10-11 ： 月份 5 12-13 ： 日 6
		 * 14-15： 派出所 7 16-17 ： 性别掩码 8
		 */
		// 先校验长度否正确,否则直接return false
		IDCrad = IDCrad.replaceAll("\\s*", "");
		if (IDCrad.length() != 18) {
			System.out.println(IDCrad + "长度不等于18位");
			return false;
		}

		// 两位字符为单位转换为数组
		String[] id = new String[9];
		for (int i = 0; i < 9; i++) {
			id[i] = IDCrad.substring(i * 2, i * 2 + 2);
		}

		// 格式化需要校验数据
		boolean flag = false; // 判断标志
		int year = Integer.valueOf(id[3] + id[4]); // 年份
		int month = Integer.valueOf(id[5]); // 月份
		int day = Integer.valueOf(id[6]); // 日期

		// 校验月份日期是否正确
		// 是否是2月
		if (month == 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				if (day > 29 || day <= 0)
					System.out.println("erro:" + day + "闰年二月只有29天且最小值为1");
				else if (day > 28)
					System.out.println("erro:" + day + "平年二月只有28天");
				else {
					System.out.println("校验通过：" + year + "-" + month + "-" + day);
					flag = true;
				}
			}
		}
		// 小月
		else if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30 || day <= 0)
				System.out.println("erro:" + day + "小月只有30天且最小值为1");
			else {
				System.out.println("校验通过：" + year + "-" + month + "-" + day);
				flag = true;
			}
		}
		// 大月
		else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			if (day > 31 || day <= 0)
				System.out.println("erro:" + day + "小月只有30天且最小值为1");
			else {
				System.out.println("校验通过：" + year + "-" + month + "-" + day);
				flag = true;
			}
		} else
			System.out.println("未知月份" + month);

		return flag;
	}

	/**
	 * 
	 * @param enID
	 *            查询出来的密文
	 * @param IDCrad
	 *            输入的原文
	 * @return 比较结果相同为true
	 */
	private static String decrypt(String enID) {
		// 两位字符为单位转换为数组
		String[] id = new String[9];
		for (int i = 0; i < 9; i++) {
			id[i] = enID.substring(i * 2, i * 2 + 2);
		}
		System.out.println("校验密文：" + Arrays.toString(id));

		// 格式化需要解密数据
		Integer year = Integer.valueOf(id[3] + id[4]); // 年份
		int month = Integer.valueOf(id[5]); // 月份
		int day = Integer.valueOf(id[6]); // 日期

		// 身份掩码和城市互换
		String tmp = id[1];
		id[1] = id[8];
		id[8] = tmp;

		// 年份解密
		year -= 66;
		id[3] = year.toString().substring(0, 2);
		id[4] = year.toString().substring(2, 4);

		// 月份日期解密
		month = (month - 3) / 8;
		day = (day - 6) / 3;

		// 格式化并储存
		DecimalFormat f2 = new DecimalFormat("00");
		id[5] = f2.format(month);
		id[6] = f2.format(day);

		System.out.println(year + "-" + month + "-" + day);

		// 格式化最终的数据并返回
		StringBuffer decryptID1 = new StringBuffer();
		for (String string : id) {
			decryptID1.append(string);
		}
		String decryptID = decryptID1.toString();

		// 解密后的格式校验
		if (!checkID(decryptID)) {
			System.out.println("解密失败！");
			return null;
		}

		return decryptID;
	}

	/**
	 * 简单的测试，无摘要
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime1 = System.nanoTime();
		
		String IDCrad = "530129 1996 11 29 133x";
		String a = encrypt(IDCrad);
		System.out.println("加密结果：" + a);
		System.out.println("解密结果：" + decrypt(a));
		
		System.out.println("time(ms):" + Long.toString((System.nanoTime() - startTime1) / 1000));
	}
}
