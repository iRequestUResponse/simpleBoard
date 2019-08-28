package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileuploadUtil {

	/**
	* Method : getFilename
	* 작성자 : PC-17
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : Content-Disposition 헤더 문자열로부터 파일이름 추출
	*/
	public static String getFilename(String contentDisposition) {
		// 메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\"";
		
		for (String str : contentDisposition.split(" *; *")) {
			String[] temp = str.split("=");
			if (temp.length < 2) continue;
			
			String key = temp[0].trim();
			String value = temp[1].trim();
			
			if ("filename".equals(key)) return value.substring(1, value.length() - 1);
		}
		return null;
	}

	public static String getFileExtension(String contentDisposition) {
		// 메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\"";
		
		for (String str : contentDisposition.split(" *; *")) {
			String[] temp = str.split("=");
			if (temp.length < 2) continue;
			
			String key = temp[0].trim();
			String value = temp[1].trim();
			
			if ("filename".equals(key)) {
				if (value.lastIndexOf('.') == -1) return "";
				return value.substring(value.lastIndexOf('.'), value.length() - 1);
			}
		}
		return null;
	}

	/**
	* Method : getPath
	* 작성자 : PC-17
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드할 경로를 조회한다
	*/
	public static String getPath() {
		String basicPath = "e:\\upload\\";
		String path = new SimpleDateFormat("yyyy\\MM\\").format(new Date());
		
		File dir = new File(basicPath + path);
		if (!dir.exists()) dir.mkdirs();
		
		return basicPath + path;
	}

}
