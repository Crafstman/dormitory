package cn.craftsman18.utils;

public class PBKDF2Test{

	public static void main(String[] args) {
		String password = "454";
		try {
			String hash = PasswordHash.createHash(password);
			boolean result = PasswordHash.validatePassword(password, hash);
			System.out.println(hash);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(password);
		
	}
}
