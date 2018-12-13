<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%   
    String path = request.getContextPath();   
    String basePath = request.getScheme() + "://"   
            + request.getServerName() + ":" + request.getServerPort()   
            + path + "/";   
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'tabel.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--  
    <link rel="stylesheet" type="text/css" href="styles.css">  
    -->
<script type="text/javascript" src="./js/tableSort.js"></script>
<style type="text/css">
table {
	table-layout: fixed;
	empty-cells: show;
	border-collapse: collapse;
	margin: 0 auto;
	border: 1px solid #cad9ea;
	color: #666;
	/* border:1px solid #cad9ea;
	    	padding:0 1em 0; */
}

td {
	text-align: left;
	height: 20px;
}
</style>
</head>

<body>
	<table id="theTable" align="center" border="1">
		<thead>
			<tr>
				<td onclick="sort(theTable,8,'int')">标题1</td>
				<td onclick="sort(theTable,1,'int')">标题2</td>
				<td onclick="sort(theTable,2,'int')">标题3</td>
				<td onclick="sort(theTable,3,'int')">标题4</td>
				<td onclick="sort(theTable,4,'int')">标题5</td>
				<td onclick="sort(theTable,5,'int')">标题6</td>
				<td onclick="sort(theTable,6,'int')">标题7</td>
				<td onclick="sort(theTable,6,'int')">标题7</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>7</td>
			</tr>
			<tr>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>1</td>
				<td>1</td>
			</tr>
			<tr>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>1</td>
				<td>2</td>
			</tr>
			<tr>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>1</td>
				<td>2</td>
				<td>3</td>
			</tr>
			<tr>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
			</tr>
			<tr>
				<td>6</td>
				<td>7</td>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
			</tr>
		</tbody>
	</table>
</body>
</html>