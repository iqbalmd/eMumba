package com.emumba.controller;


import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.util.DigestUtils;

public class MD5Digest {

	public static void main(String[] args) throws Exception {

		String input = "admin";
		//Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
         
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
 
        //Converts message digest value in base 16 (hex)
        String md5 = new BigInteger(1, digest.digest()).toString(16);
        
        System.out.println("digested: "+md5);
        
        String input2 = DigestUtils.md5DigestAsHex(input.getBytes());
        System.out.println("digested: "+input2);
		/*MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(original.getBytes());
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(Integer.toHexString((int) (b & 0xff)));
		}

		System.out.println("original:" + original);
		System.out.println("digested:" + digest);
		System.out.println("digested(hex):" + sb.toString());*/
	}
	//5d18f8030c713c35e392271124ac87f07eae6
	//6f880b3b671af1ff9511a995a34bed8
}