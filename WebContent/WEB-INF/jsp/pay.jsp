<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1"/>
		<title>消费记录</title>

		<style type="text/css">
body {
	font-size: large;
	background-color: #FAEBD7;
}

.payDiv {
	margin: auto;
	width: 300px;
	padding: 1em;
	font-size: 24px; text-align：left;
	background-color: #FFFFCC;
	border-radius: 0.5em
}

select {
	font-size: 18px;
	text-align: center;
	vertical-align: middle;
	margin-bottom: 10px;
	background-color: antiquewhite;
	border-radius: 5px;
}

input {
	border: 1px solid blue;
	border-radius: 5px; margin：10px;
	width: 300px;
	height: 30px;
	font: 14px normal Arial;
	color: #333333;
	vertical-align: middle;
}

#submit {
	width: 200px;
	height: 48px;
	font-size: larger;
}
</style>

	</head>

	<body>
		<h1 align="center">录入测试</h1>
		<form class="payDiv" >
			<div>
				类&nbsp;&nbsp;型&nbsp;&nbsp;
				<span>
					<select>
						<option>支出</option>
						<option>收入</option>
					</select> 
				</span>
			</div>
			
			<div>
				金&nbsp;&nbsp;额&nbsp;&nbsp;&nbsp;<span><input type="text"> </span>
			</div>
			
			<div>
				详&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;<span><input type="text"> </span>
			</div>
			<div>操作者
				<span>
					<select>
						<option>请选择</option>
						<option>陈泽文</option>
						<option>贾英泽</option>
						<option>鲁茸独枝</option>
						<option>赵永春</option>
						<option>蒲恩伟</option>
					</select> 
				</span>
			</div>
			<input id="submit" type="submit" value="提交"/>
		</form>

	</body>

</html>