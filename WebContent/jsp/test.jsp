<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>MyWord</title>
		<link rel="stylesheet" type="text/css" href="css/default.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.js"></script>
	</head>
	<body>
		<div class="container">
			<div class="os-phrases" id="os-phrases">
				<h2>这个画面</h2>
				<h2>送给</h2>
				<h2>My Lover</h2>
				<h2>美女</h2>
				<h2>感谢你</h2>
				<h2>出现在</h2>
				<h2>我的世界</h2>
				<h2>我希望</h2>
				<h2>我们可以</h2>
				<h2>开开心心</h2>
				<h2>一起慢慢变老</h2>
			</div>
		</div><!-- /container -->
		<audio controls autoplay>
			<source src="music/my.mp3" />
			cannot play
		</audio>
		<script src="js/jquery.js"></script>
		<script src="js/jquery.lettering.js"></script>
		<script>
			$(document).ready(function() {
				$("#os-phrases > h2").lettering('words').children("span").lettering().children("span").lettering();
			})
		</script>
	</body>
</html>
