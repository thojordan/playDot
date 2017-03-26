<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome new star</title>
<style type="text/css"> 
.borderNone {width:97%; height:100%;border:none;text-align:left;} 
input{
      width:40px;
      border:1px solid red;
        }
</style> 

</head>
<body>
	<form action="FrontServlet">
	<div id="north">
		<table id="t_qxcrand" border="1" cellpadding="2" cellspacing="0">
			    <thead>
			        <tr>
			            <th>Random</th>
			        </tr>
			    </thead>
			    <tr>
			    	<td>exclude1:<input type="text" name="exclude1" value="${exclude1}">
			    		<input type="text" name="exclude2" value="${exclude2}">			    		
			    	</td>
		    	</tr>
		    	<tr>
			    	<td>include:<input type="text" name="include1" value="${include1}">
			    		<input type="text" name="include2" value="${include2}">	
			    		<input type="text" name="include3" value="${include3}">
			    		<input type="text" name="include4" value="${include4}">
			    		<input type="text" name="include5" value="${include5}">
			    		how:<input type="text" name="how" value="${how}">		    		
			    	</td>
			    </tr>
			    <tr>
			    	<td>no:1<input type="text" name="no1" value="${no1}">
			    		2<input type="text" name="no2" value="${no2}">	
			    		3<input type="text" name="no3" value="${no3}">
			    		4<input type="text" name="no4" value="${no4}">
			    		5<input type="text" name="no5" value="${no5}">
			    		6<input type="text" name="no6" value="${no6}">
			    		7<input type="text" name="no7" value="${no7}">			    		    		
			    	</td>
			    </tr>
			    	<td>not equal pos:<input type="text" name="pos1" value="${pos1}">ne
			    		<input type="text" name="pos2" value="${pos2}">	
			    	</td>
			    <tr>
			    <tr><td align="center"><button onclick="submit()"><b>Search</b></button></td>
			    <tr><td><b>Result</b></td>
			    </tr>
			    </tr>
			    <c:forEach items="${qxcrand}" var="qr">
			        <tr>
			            <td>${qr.getJieguo()}</td>
			        </tr>
			    </c:forEach>
			</table>
			<br>
	</div>
	<div id="south">
		<div id="south_left" style="width:30%; float:left">
			<table id="t_qxcno" border="1" cellpadding="2" cellspacing="0">
			    <thead>
			        <tr>
			            <th>NoRes</th>
			        </tr>
			    </thead>
			    <c:forEach items="${qxcno}" var="qn">
			        <tr>
			            <td>${qn.getJieguo()}</td>
			        </tr>
			    </c:forEach>
			</table>
			<br>
			total ${pagenum}   |cur  ${page}
			<c:choose>
			    <c:when test="${page>1}">
			        <a href="FrontServlet?page=${page-1}"><input type="button" value="pre" ></a>
			    </c:when>
			    <c:otherwise>
			        <input type="button" value="pre"  disabled="disabled" />
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${page!=pagenum}">
			        <a href="FrontServlet?page=${page+1}"><input type="button" value="next"></a>
			    </c:when>
			    <c:otherwise>
			        <input type="button" value="next" disabled="disabled" />
			    </c:otherwise>
			</c:choose>
		</div>
		
		<div id="south_right" style="width:70%; float:left">
			<table id="t_qxcis" border="1" cellpadding="2" cellspacing="0">
			    <thead>
			        <tr>
			            <th>Qs</th>
				    	<th>Jieguo</th>
			        </tr>
			    </thead>
			    <c:forEach items="${qxchis}" var="his">
			        <tr>
			            <td>${his.getQs()}</td>
				    <td>${his.getJieguo()}</td>
			        </tr>
			    </c:forEach>
			</table>
			<br>
			total ${hispagenum}   |cur  ${hispage}
			<c:choose>
			    <c:when test="${hispage>1}">
			        <a href="FrontServlet?hispage=${hispage-1}"><input type="button" value="pre" ></a>
			    </c:when>
			    <c:otherwise>
			        <input type="button" value="pre"  disabled="disabled" />
			    </c:otherwise>
			</c:choose>
			<c:choose>
			    <c:when test="${hispage!=hispagenum}">
			        <a href="FrontServlet?hispage=${hispage+1}"><input type="button" value="next"></a>
			    </c:when>
			    <c:otherwise>
			        <input type="button" value="next" disabled="disabled" />
			    </c:otherwise>
			</c:choose>
		</div>
	</div>
	</form>
</body>
</html>