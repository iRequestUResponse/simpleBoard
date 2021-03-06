<%--------------------------------------------------------------------------------
	* 화면명 : Smart Editor 2.8 에디터 연동 페이지
	* 파일명 : /page/test/index.jsp
--------------------------------------------------------------------------------%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smart Editor</title>

<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />

<script src="${ cp }/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

document.addEventListener('DOMContentLoaded', function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${ cp }/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
 	});
	
	// 전송버튼 클릭이벤트
	document.querySelector('#savebutton').addEventListener('click', function() {
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) document.querySelector('#frm').submit();
		}
		
	});
});

// 필수값 Check
function validation(){
	var contents = oEditors[0].getContents().trim();
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>
</head>
<body>
<form action="${ cp }/postForm" method="post" id="frm" enctype="multipart/form-data">
	<div>제목 : <input name="title" value="${ title }"></div>
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${ content }</textarea>
	<div>첨부파일</div>
	<div class="files">
	<c:forEach var="f" items="${ attList }">
	<p class="attItem">${ f.ATT_NAME } <button class="attDel" data-attid="${ f.ATT_ID }" type="button">&times;</button> </p>
<%-- 	${ f.ATT_ID } / ${ f.ATT_NAME } / ${ f.ATT_PATH } / ${ f.POST_ID }  <br> --%>
	</c:forEach>
	<c:forEach var="f" begin="1" end="${ 5 - attList.size() }">
	<p class="attItem"> <input type="file" name="attFile"> </p>
	</c:forEach>
	</div>
	<input type="hidden" value="${ param.board_id }" name="board_id">
	<input type="hidden" value="${ param.post_id }" name="post_id">
	<input type="hidden" value="${ param.post_parent }" name="post_parent">
	<input type="hidden" name="delItems" id="delItems">
</form>
<input style="margin-top: 1em;" type="button" id="savebutton" value="서버전송" />
<script type="text/javascript">
var attDelList = document.querySelectorAll('.attDel');
Array.prototype.forEach.call(attDelList, function(e) {
	e.addEventListener('click', function() {
		var fileId = this.dataset.attid;
		var target = this.parentElement;
		target.innerHTML = '<input type="file" name="attFile">';
		var delItems = document.querySelector('#delItems');
		
		var list = JSON.parse('[' + delItems.value + ']');
		list.push(fileId);
		delItems.value = list.join(',');
	});
});
</script>
</body>
</html>