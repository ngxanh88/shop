package de.ngxa.restaurant.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AppUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUtil.class);

	private AppUtil() {}

	public static String getMD5Hex(String stringToHash) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte[] data = stringToHash.getBytes(); 
		    m.update(data,0,data.length);
		    BigInteger i = new BigInteger(1,m.digest());
		    return String.format("%1$032x", i);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("convert md5 hex: ", e);
		}
	    
		return null;
	}
	
	public static String getSHA512(String stringToHash) {
		String generatedString = null;
	    try {

	        MessageDigest md = MessageDigest.getInstance("SHA-512");
	        byte[] bytes = md.digest(stringToHash.getBytes(StandardCharsets.UTF_8));
	        StringBuilder sb = new StringBuilder();
			for (byte aByte : bytes) {
				sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
			}
	        generatedString = sb.toString();
	    } 
	    catch (Exception e) {
			LOGGER.error("convert SHA 512: ", e);
	    }
		return generatedString;
	}
	
	public static String hashAndEncodeMD5Password(String password) {
		byte[] md5 = DigestUtils.md5(password.trim().getBytes(StandardCharsets.UTF_8));
		final byte[] base64 = Base64.encodeBase64(md5);
		final String hashedAndEncoded = new String(base64, StandardCharsets.US_ASCII);
		return "{md5}" + hashedAndEncoded;
	}
	
	public static String hmacSha256(String key, String data) {
		try {
			final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			final SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
			sha256_HMAC.init(secret_key);

			return Hex.encodeHexString(sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			LOGGER.error("convert hmac sha 256: ", e);
		}
		
		return null;
	}
	
	public static String encodePassword(String password) {
		return DatatypeConverter.printBase64Binary(password.getBytes());
	}
	
	public static String decodePassword(String encodedPassword) {
		return new String(DatatypeConverter.parseBase64Binary(encodedPassword));
	}
	
	public static <T> T cloneObject(T o, Class<T> t) {
		final Gson gson = new GsonBuilder().create();
		final String objectJson = gson.toJson(o);

		return gson.fromJson(objectJson, t);
	}
	
	public static String base64Encode(String s) {
		final byte[] base64 = Base64.encodeBase64(s.getBytes());
		return new String(base64, StandardCharsets.US_ASCII);
	}
}
