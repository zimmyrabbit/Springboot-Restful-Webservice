<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/es6-promise/4.1.1/es6-promise.auto.js"></script>
<script src="https://html2canvas.hertzen.com/dist/html2canvas.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>

<title>JSP Title</title>
</head>
<body>

    <div id="target">
        <!-- 여기에 원하는 HTML 내용을 추가합니다. -->
        <h1>Hello, World!</h1>
        <p>This is a sample HTML content.</p>
    </div>
    <button id="saveBtn">Save as Image</button>

<div id="test">
<div id="printDiv1" style="height:3508px; width:2480px; background-color: green; border-bottom-color: red;"></div>
<div id="printDiv2" style="height:3508px; width:2480px; background-color: red; border-bottom-color: red;"></div>
<div id="printDiv3" style="height:3508px; width:2480px; background-color: blue; border-bottom-color: red;"></div>
</div>

<script>
$(document).ready(function() {
	$('#saveBtn').click(function() { // pdf저장 button id
		
	    html2canvas($('#test')[0]).then(function(canvas) { //저장 영역 div id
		
	    // 캔버스를 이미지로 변환
	    var imgData = canvas.toDataURL('image/png');
		     
	    var imgWidth = 190; // 이미지 가로 길이(mm) / A4 기준 210mm
	    var pageHeight = imgWidth * 1.414;  // 출력 페이지 세로 길이 계산 A4 기준
	    var imgHeight = canvas.height * imgWidth / canvas.width;
	    var heightLeft = imgHeight;
	    var margin = 10; // 출력 페이지 여백설정
	    var doc = new jsPDF('p', 'mm');
	    var position = 0;
	       
	    // 첫 페이지 출력
	    doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
	    heightLeft -= pageHeight;
	         
	    // 한 페이지 이상일 경우 루프 돌면서 출력
	    while (heightLeft >= 20) {
	        position = heightLeft - imgHeight;
	        doc.addPage();
	        doc.addImage(imgData, 'PNG', margin, position, imgWidth, imgHeight);
	        heightLeft -= pageHeight;
	    }
	 
	    // 파일 저장
	    doc.save('file-name.pdf');

		  
	});

	});
	
	
})



</script>
</body>
</html>