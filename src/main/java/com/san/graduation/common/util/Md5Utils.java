package com.san.graduation.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
	
	public static String getMd5(String msg){
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md5.digest(msg.getBytes());

			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16)
					hexValue.append("0");
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return msg;
		}
	}
	
//	public static void main(String[] args){
//		//e10adc3949ba59abbe56e057f20f883e
//		System.out.println(Md5Utils.getMd5("123456")); 
//	}
}
