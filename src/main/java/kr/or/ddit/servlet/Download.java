package kr.or.ddit.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Download.class);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = request.getParameter("file");
		
		File downloadFile = new File(FileuploadUtil.getRoot() + filePath);
		FileInputStream fis = new FileInputStream(downloadFile);
		
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] b = new byte[512];
		int len = 0;
		
		while ((len=fis.read(b, 0, 512)) != -1) {
			sos.write(b, 0, len);
		}
		
		sos.flush();
		sos.close();
		fis.close();
	}
}
