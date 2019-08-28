package kr.or.ddit.util;

public class CookieUtil {

	/**
	* Method : getCookie
	* 작성자 : PC-17
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : 쿠키 문자열로부터 특정 쿠키의 값을 반환한다
	*/
	public static String getCookie(String cookieString, String cookieId) {
		String[] cookies = cookieString.split("; *");
		for (String cookie : cookies) {
			String[] idNValue = cookie.split("=");
			if (idNValue[0].equals(cookieId)) return idNValue[1];
		}
		return null;
	}

}
