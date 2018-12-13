package cn.craftsman18.utils;

/**
 * 简单掩盖身份信息 
 * 	最大支持2147年12月31日 
 * 	最小支持1080年01月01日
 * 
 * @author craftsman
 * @date 2018年6月30日
 *
 */
public class IDEncrypt {

	/**
	 * 加密身份证码
	 * 
	 * @param IDcard
	 * @return 加密后字符串
	 */
	private static String encrypt(String IDcard) {
		if (!checkID(IDcard)) {
			System.out.println("校验失败！程序结束");
			System.exit(0);
		}
		IDcard = IDcard.replaceAll("\\s*", "");
		// 将区域特征码全部储存为16进制
		String head = IDcard.substring(0, 6);
		int j = Integer.valueOf(head);
		head = Integer.toHexString(j);

		// 出生年月后的字符除后两位储存为8进制字符串
		String body = IDcard.substring(6, 16);
		int i = Integer.valueOf(body);
		body = Integer.toOctalString(i);

		return head + body + IDcard.substring(16, 18);
	}

	private static String decrypt(String enID) {
		// 将区域特征码16进制转换为10进制
		String tmp = enID.substring(0, 5);
		int head = Integer.parseInt(tmp, 16);

		// 出生年月后的字符除后两位8进制转换为10进制
		String tmp2 = enID.substring(5, 16);
		int body = Integer.parseInt(tmp2, 8);

		return "" + head + body + enID.substring(16, 18);
	}

	/**
	 * 校验身份证格式是否符合规范
	 * 
	 * @param 身份证号
	 * @return 真假
	 */
	private static boolean checkID(String IDcard) {
		/*
		 * 转换前 0-1 ： 省份 0 2-3 ： 城市 1 4-5 ： 区县 2 6-9 ： 年份 3,4 10-11 ： 月份 5 12-13 ： 日 6
		 * 14-15： 派出所 7 16-17 ： 性别掩码 8
		 */
		// 先校验长度否正确,否则直接return false
		IDcard = IDcard.replaceAll("\\s*", "");
		if (IDcard.length() != 18) {
			System.out.println(IDcard + "长度不等于18位");
			return false;
		}

		// 两位字符为单位转换为数组
		String[] id = new String[9];
		for (int i = 0; i < 9; i++) {
			id[i] = IDcard.substring(i * 2, i * 2 + 2);
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
	 * 简单的测试，无摘要
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime1 = System.nanoTime();
		
		String IDcard = "530129 1996 11 29 133x";
		String a = encrypt(IDcard);
		System.out.println("加密结果：" + a);
		System.out.println("解密结果：" + decrypt(a));
		
		System.out.println("time(ms):" + Long.toString((System.nanoTime() - startTime1) / 1000));
	}
}
