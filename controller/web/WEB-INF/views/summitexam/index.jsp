<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/static/css/bootstrap.css">

<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form id="getsubmit" type="post" action="/examination/getSubmitExamQuestion" >
				<ol>
					 <c:forEach var="list" items="${list}">
						 <div  style="margin: 0 auto;box-shadow: 2px 2px 2px 3px  darkgrey;border-radius: 5%;width: 600px;background: white;">
							 <div style="border: none;top: 100px;font-size: 25px;padding-top: 10px;margin-left: 100px;margin-bottom: 100px;">
								<div>
									<li class="active">
										<label>${list.questtions}</label>
									<div style="font-size: 20px;color: darkgray;">
										<c:choose>
											<c:when test="${list.type==1}">
												<input type="radio" style="display:none;"name="scYardage" id="radios1" value="36" checked="checked"/>
												<input type="radio" name="${list.id }" value="${list.optionA}">A、${list.optionA}&nbsp;&nbsp;<br/>
												<input type="radio" name="${list.id }"  value="${list.optionB}">B、${list.optionB}&nbsp;&nbsp;<br/>
												<input type="radio" name="${list.id }"  value="${list.optionC}">C、${list.optionC}&nbsp;&nbsp;<br/>
												<input type="radio" name="${list.id }"  value="${list.optionD}">D、${list.optionD}&nbsp;&nbsp;<br/>
											</c:when>
											<c:otherwise>
												<input type="radio" style="display:none;"name="scYardage" id="radios1" value="36" checked="checked"/>
												<input type="checkbox" name="${list.id }" value="${list.optionA}">A、${list.optionA}&nbsp;&nbsp;<br/>
												<input type="checkbox" name="${list.id }"  value="${list.optionB}">B、${list.optionB}&nbsp;&nbsp;<br/>
												<input type="checkbox" name="${list.id }"  value="${list.optionC}">C、${list.optionC}&nbsp;&nbsp;<br/>
												<input type="checkbox" name="${list.id }"  value="${list.optionD}">D、${list.optionD}&nbsp;&nbsp;<br/>
											</c:otherwise>
										</c:choose>
									</div>
									</li>
								</div>
							 </div>
						 </div>
		               </c:forEach>
				</ol>
				<input style=" color: white;text-decoration: none;padding:15px 32px;text-align: center;border: 1px solid;position:fixed;background-color: green;font-size: 16px;bottom:55px;right:0px;" id="ok" type="submit" value="交卷"/>
			</form>
		</div>
	</div>
</div>

<div style="text-align: center;border: 1px solid darkgray;width: 200px;height: 50px;position:fixed;bottom:0px;right:0px;background-color: firebrick;color: white">
	离考试结束还剩下：
<label id="time">时间60分钟</label>
</div>


<script type="text/javascript">
		var time=60;
		var int=setInterval("code()",1000);
		function code(){
			time=time-1;
			document.getElementById("time").innerText=time+"分钟";
			if(time==0){
				alert("考试时间到！");
				clearInterval(int);
				document.getElementById("getsubmit").submit();
			}
		}
</script>
</body>
</html>