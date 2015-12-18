<%@ include file="includes/header.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/signUpPage.css"
	rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<%@ include file="includes/menu.jsp"%>
		<div class="container">
			<div class="row">
				<div class="col-md-3"><button id="superButton"> Test</button></div>
				<div class="col-md-6">
					<div class="well">
						<%@ include file="includes/forgotPasswordForm.html"%>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
		<div id="push"></div>
	</div>
	<%@ include file="includes/footer.html"%>	
	<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>	
	<script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
	
</body>
</html>