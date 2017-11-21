<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>用户管理系统</title>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/common_style.css">
	<link rel="stylesheet" type="text/css" href="css/paging.css">
	<link rel="stylesheet" type="text/css" href="css/dialog.css">	
	<link rel="stylesheet" type="text/css" href="fancybox-2.1.7/source/jquery.fancybox.css?v=2.1.5" media="screen" />
	<link rel="stylesheet" type="text/css" href="plugins/fonts/iconfont/iconfont.css">
	
	<!--jquery引入  -->
	<script type="text/javascript" src="plugins/jquery-2.1.3.js"></script>
	<script type="text/javascript" src="js/paging.js"></script>
	<script type="text/javascript" src="js/jquery-html5Validate.js"></script>
	<script type="text/javascript" src="js/jquery.dialog.js"></script>
	<script type="text/javascript" src="fancybox-2.1.7/source/jquery.fancybox.pack.js?v=2.1.5"></script>
	<script type="text/javascript" src="plugins/Chart.min.js"></script>
</head>
<body>
	<div id="topPanel">
		<div class="logo-panel" class="left_float">
			<div class="logo-content-Panel"></div>
			<a href="index.jsp"><h3>用户管理系统</h3></a>
		</div>
		<div class="topnav-panel">
			<ul>
				<li><a href="">联系我们</a></li>
				<li><a href="">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="bottomPanel">
		<div class="nav-panel">
			<ul>
				<li class="userList">用户管理</li>
				<li class="addUser">用户新增</li>
				<li class="userAnalysis">用户分析</li>
			</ul>
			<div class="user-info">
				<div class="user-img"></div>
			</div>
		</div>
		<div class="content-panel">
		</div>
	</div>
	
	<script>
		var $content;
		$(function(){
			var $bottom=$("#bottomPanel");
			var ul=$bottom.find(".nav-panel").find("ul");
			$content=$bottom.find(".content-panel");
			
			//初始化首页
			ul.find(".userList").addClass("navPanelActive");
			$content.load("loadUserListPage");
			
			//加载用户管理页面
			ul.find(".userList").on("click",function(){
				$this=$(this);
				ul.find("li").removeClass("navPanelActive");
				$this.addClass("navPanelActive");
				$content.load("loadUserListPage");
			});
			
			//加载用户新增页面
			ul.find(".addUser").on("click",function(){
				$this=$(this);
				ul.find("li").removeClass("navPanelActive");
				$this.addClass("navPanelActive");
				$content.load("loadUserFormPage");
			});
			
			//加载用户分析增页面
			ul.find(".userAnalysis").on("click",function(){
				$this=$(this);
				ul.find("li").removeClass("navPanelActive");
				$this.addClass("navPanelActive");
				$content.load("loadUserAnalysisPage");
			});
			
			

			//编辑用户
			$(".editUser").fancybox({
				'type': 'iframe',
				'autoSize': false,
				'width': 450,
				'height': 420,
				'afterClose': function(){
					$("#bottomPanel").find(".content-panel").load("loadUserListPage?page.pageNumber="+pageNumber);
				}
			});
			
		});
		
	</script>
</body>
</html>