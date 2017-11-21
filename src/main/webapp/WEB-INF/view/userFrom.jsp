<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="userFromPanel">
	<div class="title">新增用户信息</div>
	<form>
		<table>
			<tr>
				<td>用户名称：</td>
				<td><input type="text" name="user.userName" class="input_500" required data-min="2" data-max="12" 
				placeholder="请输入用户名称！"/></td>
			</tr>
			<tr>
				<td>登陆密码：</td>
				<td><input type="password" name="user.password" class="input_500" required data-min="6" data-max="24"
				placeholder="请输入登陆密码！"/></td>
			</tr>
			<tr>
				<td>重复密码：</td>
				<td><input type="password" name="repassword" class="input_500" required data-min="6" data-max="24"
				placeholder="请确认登陆密码！"/></td>
			</tr>
			<tr>
				<td>电子邮箱：</td>
				<td><input type="email" name="user.email" required class="input_500" placeholder="请输入电子邮箱！"/></td>
			</tr>
			<tr>
				<td>性　　别：</td>
				<td>
					<input type="radio" name="user.gender" value="男" checked/>男
					<input type="radio" name="user.gender" value="女"/>女
				</td>
			</tr>
		</table>
		<div class="button-group-panel">
			<button type="submit" class="button_80">保存</button>
			<button type="reset" class="button_80">重置</button>
		</div>
	</form>
</div>
<script>
$(function(){
	var $userFromPanel=$("#userFromPanel");
	//新增按钮绑定事件
	$userFromPanel.find(".button-group-panel").find("button[type='submit']").on("click",function(){
		
		//表单验证
		$("form").html5Validate(function(){
			//ajax提交表单
			$.ajax({
				url: "addUser",
				type: "post",
				async: "false",
				dataType: "json",
				data: $userFromPanel.find("form").serialize(),
				success: function(data){
					alert("注册成功！！")
				}
			});
		},{
			validate: function(){
				if($('input[name="user.password"]').val() !== $('input[name="repassword"]').val()){
					$('input[name="repassword"]').testRemind("两次密码必须相同！");
					return false;
				}
				return true;
			},
			"immediate": true
		});
	});
	
});
		
		
		
</script>
