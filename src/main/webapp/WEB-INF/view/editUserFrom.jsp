<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<title>编辑用户</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${ctx}/css/common_style.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/dialog.css">
</head>
<body>
	<div id="edidUserPanel">
		<div class="title-panel">编辑用户信息</div>
		<form>
			<div>
				<input type="hidden" name="user.id" value="${user.id }" /> <input
					type="hidden" name="user.createDate" value="${user.createDate }" />
				<input type="hidden" name="user.password" value="${user.password }" />
			</div>
			<div class="input-panel">
				<section> <lable>用户名称</lable> <lable>
				<input type="text" name="user.userName" value="${user.userName }"
					required data-min="2" data-max="12" /></lable> </section>
				<section> <lable>电子邮箱</lable> <lable>
				<input type="email" name="user.email" value="${user.email }"
					required /></lable> </section>
				<section> <lable>性 别</lable> <lable> <select
					name="user.gender" class="input">
					<option value="${user.gender}">${user.gender}</option>
					<option value="男">男</option>
					<option value="女">女</option>
				</select> </lable> </section>
			</div>

			<div class="button-panel">
				<button type="submit" class="button">保存</button>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="${ctx}/plugins/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery.dialog.js"></script>
	<script type="text/javascript" src="${ctx}/js/jquery-html5Validate.js"></script>
	<script>
		$(function() {
			var $edidUserPanel = $("#edidUserPanel");
			$edidUserPanel.find(".button-panel").find(".button").on("click",
					function() {

						$("form").html5Validate(function() {
							//提交表单
							$.ajax({
								url : "upadtaUser",
								type : "post",
								async : "false",
								dataType : "json",
								data : $edidUserPanel.find("form").serialize(),
								success : function(data) {
									alert("修改成功！！")
								}
							});
						}, {
							"label" : true,
							"immediate" : true
						});

					});
		});

		function closefancybox() {
			parent.$.fancybox.close();
		}
	</script>
</body>
</html>