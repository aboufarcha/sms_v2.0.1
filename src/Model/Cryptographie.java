/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author abouf
 */
public class Cryptographie {
    public static String Encrypting(String original){
        try{
         MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(original.getBytes());
	    byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (byte b : digest) {
			sb.append(String.format("%02x", b & 0xff));
		}
            return sb.toString();
        }catch(Exception e){
            return null;
        }
           
    }
}
