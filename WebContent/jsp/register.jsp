<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML>
<html>
<head>
<title>注册页面</title>
	<meta charset="UTF-8">
	<meta name="keywords" content="">
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<script src="../js/jquery.min.js" type="text/javascript"></script>
	<script src="../js/jquery.form.js" type="text/javascript"></script>
	<script src="../js/json.parse.js" type="text/javascript"></script>
	<script src="../js/core.js" type="text/javascript"></script> 
	<script src="../js/sha1.js" type="text/javascript"></script> 
	<script src="../js/hmac.js" type="text/javascript"></script> 
	<script src="../js/pbkdf2.js" type="text/javascript"></script>
<style>
	input.username, .pw, .repw {
		border: 1px solid blue;
		border-radius: 5px; margin：10px;
		width: 350px;
		height: 30px;
		font: 14px normal Arial;
		color: #333333;
	}
	
	input.add_btn {
		border: 1px solid blue;
		border-radius: 5px; margin：10px;
		width: 350px;
		height: 53px;
		font: 16px bold Verdana;
		background-color: #0697D5;
	}
	
	div.div_user, .div_pw, .div_repw {
		margin-top: 5px;
		padding: 5px;
	}
	
	body {
		text-align: center
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
		<form name="addForm" id="add_form" method="post"
			action="${pageContext.request.contextPath}/register.action">
			<h4>用户注册界面展示</h4>
			<div class="div_user">
				<input name="username" class="username" type="text"
					placeholder="&nbsp;&nbsp;用户名" />
			</div>
			<div class="div_pw">
				<input class="pw" name="userpass" type="password"
					placeholder="&nbsp;&nbsp;密码" />
			</div>
			<div class="div_repw">
				<input class="repw" name="repasswd" type="password"
					placeholder="&nbsp;&nbsp;确认密码" />
			</div>
			<div style="line-height: 30px; text-indent: 5px; color: #000"
				id="addTips">&nbsp;</div>
			<div>
				<input class="add_btn" id="addBtn" type="button" value="注册" />
			</div>
		</form>
	</div>



	<!--下面的是js -->
	<script type="text/javascript">
	//页面加载完后者执行的代码
	$(document).ready(function(){
		//点击登陆按钮执行的
		$("#addBtn").click(function(){
			//获取用户名及密码
			var username = $(".username").val();
			var userpass = $(".pw").val();
			var repasswd = $(".repw").val();
				//去除空格
				username = $.trim(username);
				userpass = $.trim(userpass);
				repasswd = $.trim(repasswd);
				
				var salt = CryptoJS.enc.Utf8.parse("柴米酱醋盐");	//盐值
				var iter = 3000;//hash次数
				var mi=CryptoJS.PBKDF2(userpass, salt,
							{ keySize: parseInt(8),
							iterations: parseInt(iter) }
							);
				//alert(mi);
			
			//对输入的密码做初级验证
			if(username.length <3){
				$("#addTips").html("用户名不能少于三个字符!").fadeIn();
				$("#addBtn").val('注册').removeAttr('disabled');
				return false;
			}
			if(userpass == ''){
				$("#addTips").html("密码不能为空！").fadeIn();
				$("#addBtn").val('注册').removeAttr('disabled');
				return false;
			}
			if(userpass!==repasswd){
				$("#addTips").html("两次密码不相同！").fadeIn();
				$("#addBtn").val('注册').removeAttr('disabled');
				return false;
			}

			$("#add_form").ajaxSubmit({
				url: "../register.action",
				type: "post",
				cache:false,
				data: {"name":username,"passwd":mi},
				success:function(result){
					var flag = eval(result);
					//alert(typeof result);
					//alert(typeof flag);
					if(flag){
						$("#addTips").html("注册成功，正在传送至登陆界面").fadeIn();
						window.location.href="../index.html";
					}else{
						//$("#addBtn").val('重试').attr("disabled","disabled");
						$("#addTips").html("用户名已注册，请重试!").fadeIn();
					}
				}
			})
			return false;
		})		
	})
	
	//回车注册
	$(function(){
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	$("#addBtn").click();
		     }
		}
	}); 
</script>
</body>
</html>