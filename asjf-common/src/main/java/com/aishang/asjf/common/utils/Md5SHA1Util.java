package com.aishang.asjf.common.utils;

import java.security.MessageDigest;

/**
 * @ClassName: Md5SHA1Util
 * @Description: MD5与SHA1都是Hash算法，MD5输出是128位的，SHA1输出是160位的，MD5比SHA1快，SHA1比MD5强度高。
 * @author mx
 * @date 2017年12月25日19:21:18
 *
 */
public class Md5SHA1Util {
	private static final String ALGORITHM_MD5 = "MD5";
	private static final String ALGORITHM_SH1 = "SHA-1";
	private static final String CHAR_ENCODE_DEFAULT = "UTF-8";
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static String md5( String origin ) {
		return encode( origin, CHAR_ENCODE_DEFAULT, ALGORITHM_MD5 );
	}

	public static String sh1( String origin ) {
		return encode( origin, CHAR_ENCODE_DEFAULT, ALGORITHM_SH1 );
	}

	public static String md5( String origin, String charset ) {
		return encode( origin, charset, ALGORITHM_MD5 );
	}

	public static String sh1( String origin, String charset ) {
		return encode( origin, charset, ALGORITHM_SH1 );
	}

	private static String encode( String origin, String charsetname, String algorithm ) {
		String resultString = null;
		try {
			resultString = new String( origin );
			MessageDigest md = MessageDigest.getInstance( algorithm );
			if ( charsetname == null || "".equals( charsetname ) )
				resultString = byteArrayToHexString( md.digest( resultString.getBytes() ) );
			else
				resultString = byteArrayToHexString( md.digest( resultString.getBytes( charsetname ) ) );
		} catch ( Exception exception ) {
		}
		return resultString;
	}

	private static String byteArrayToHexString( byte b[] ) {
		StringBuffer resultSb = new StringBuffer();
		for ( int i = 0; i < b.length; i++ )
			resultSb.append( byteToHexString( b[ i ] ) );

		return resultSb.toString();
	}

	private static String byteToHexString( byte b ) {
		return hexDigits[ ( b >> 4 ) & 0x0f ] + hexDigits[ b & 0x0f ];
	}
}
