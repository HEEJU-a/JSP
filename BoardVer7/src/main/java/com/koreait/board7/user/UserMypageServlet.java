package com.koreait.board7.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String uploadPath = request.getRealPath("/res/img/temp");
		
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		int maxFileSize = 10_485_760; // 10*1024*1024(10mb)
		
		System.out.println(uploadPath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp",maxFileSize
				, "UTF-8", new DefaultFileRenamePolicy());// 파일정보들(요청들),어디에 저장할래, 세번째는 첨부파일 최대용량, 중복된 이름일때 파일명을 변경할수있도록 도와줌
		
		//폴더 만들어야 하니까 session얻어오기!
		int loginUserPk = MyUtils.getLoginUserPk(request);//->로그인 안하면 에러터짐
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		
		File folder = new File(targetFolder); //folder가 폴더가 있는지 확인하기! 그래서 if씀
		folder.mkdirs(); //-> 이렇게만 적어줘도 된다 왜냐면 mkdirs에서 알아서 존재하면 실행 안하고 존재하지 않으면 실행함
		
//		if(!folder.exists()) { //폴더가 존재하지 않으면 밑에꺼가 실행됨 만약에 폴더에 있으면 밑에꺼가 실행안되고 그냥 지나침
//			folder.mkdirs();
//		}
		
		
	// 3	
		//파일명 얻어오기! 즉 파일업로드 눌렀을때 마지막(가장 최신꺼) 파일명 얻기!!!!
		String fileNm = multi.getFilesystemName("profileImg");
		System.out.println(fileNm);
		//파일명 까지 얻었으면 이제 내가 원하는 곳으로 이동시킬수있음
		//abcd.efg.jpg".indexof(".");
		int lastDotIdx = fileNm.lastIndexOf("."); // ->lastindexof는 오른쪽에서부터 찾는다
		String ext = fileNm.substring(lastDotIdx); // 확장자 구했음
		
		String newFileNm = UUID.randomUUID().toString() + ext;
		
		
	// 2
		File imgFile = new File(uploadPath + "/temp" + "/" + fileNm);
		//imgFile.renameTo(new File(targetFolder + "/ddd.jpg"));
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm));
		
	}

}
