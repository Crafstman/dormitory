<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
<title>登录页面</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<script src="./js/jquery.min.js" type="text/javascript"></script>
	<script src="./js/jquery.form.js" type="text/javascript"></script>
	<script src="./js/json.parse.js" type="text/javascript"></script>
	<script src="./js/core.js" type="text/javascript"></script> 
	<script src="./js/sha1.js" type="text/javascript"></script> 
	<script src="./js/hmac.js" type="text/javascript"></script> 
	<script src="./js/pbkdf2.js" type="text/javascript"></script>
<style>
input.username, .pw {
	border: 1px solid blue;
	border-radius: 5px; margin：10px;
	width: 350px;
	height: 30px;
	font: 14px normal Arial;
	color: #333333;
}

input.login_btn, .add_btn {
	border: 1px solid blue;
	border-radius: 5px; margin：10px;
	width: 350px;
	height: 53px;
	font: 16px bold Verdana;
	background-color: #0697D5;
}

div.div_user, .div_pw, .btn {
	margin-top: 5px;
	padding: 5px;
}

body {
	text-align: center;
	background-color: burlywood;
}

#loginTips {
	margin: 20px 0;
	text-align: center;
	font-size: 18px;
}
</style>
</head>

<body>
	<div class="form">

		<form name="loginForm" id="login_form" method="post" action="${pageContext.request.contextPath}/login.action">
			<h2>通往知识天堂的时光隧道</h2>
			<div class="div_user">
				<span></span><input name="username" class="username" type="text"
					placeholder="&emsp;用户名" />
			</div>
			<div class="div_pw">
				<span></span><input class="pw" name="userpass" type="password"
					placeholder="&emsp;密码" />
			</div>
			<div class="div_box">
				<label><input type="checkbox" class="" />&nbsp;&nbsp;下次自动登录&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
				<a href="./forget.jsp">忘记密码？</a>
			</div>
			<div class="btn">
				<input class="login_btn" id="loginBtn" type="button" value="登录" />
			</div>
			<div class="btn">
				<a href="./register.html"><input class="add_btn" id="addBtn"
					type="button" value="注册"></a>
			</div>
			<div style="line-height: 30px; text-indent: 5px; color: #000"
				id="loginTips">&nbsp;</div>
		</form>
	</div>


	<!--下面的是js -->
	<script type="text/javascript">
	//页面加载完后者执行的代码
	$(document).ready(function(){
		//点击登陆按钮执行的
		$("#loginBtn").click(function(){
			//获取用户名及密码
			var username = $(".username").val();
			var userpass = $(".pw").val();
				//去除空格
				username = $.trim(username);
				userpass = $.trim(userpass);
				
			var salt = CryptoJS.enc.Utf8.parse("柴米酱醋盐");	//盐值
			var iter = 3000;//hash次数
			var mi=CryptoJS.PBKDF2(userpass, salt,
						{ keySize: parseInt(8),
						iterations: parseInt(iter) }
						);
			//alert(mi);
			//对输入格式进行限定
			if(username.length <3){
				$("#loginTips").html("请输入正确的用户名!").fadeIn();
				$("#loginBtn").val('登录').removeAttr('disabled');
				return false;
			}
			if(userpass == ''){
				$("#loginTips").html("请输入正确的密码!").fadeIn();
				$("#loginBtn").val('登录').removeAttr('disabled');
				return false;
			}

			$("#login_form").ajaxSubmit({
				url: "./login.action",
				type: "post",
				cache:false,
				data: {"name":username,"passwd":mi},
				success:function(result){
					var flag = eval(result);
					//alert(typeof result);
					//alert(typeof flag);
					if(flag){
						window.location.href="./index.html";
					}else{
						//$("#loginBtn").val('登录').attr("disabled","disabled");
						$("#loginTips").html("用户名或密码错误!").fadeIn();
						//setTimeout(location.reload(),8000000)
						
					}
				}
			})
			return false;
		})		
	})
	
	//回车登录
	$(function(){
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	$("#loginBtn").click();
		     }
		}
	}); 
</script>
</body>
</html>