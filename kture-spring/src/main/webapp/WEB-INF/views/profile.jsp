<%@ include file="includes/header.jsp"%>
<link
	href="${pageContext.request.contextPath}/resources/css/homePage.css"
	rel="stylesheet">
</head>
<body>
	<div id="wrap">
		<%@ include file="includes/menu.jsp"%>
		<div class="container">
			<div class="row content">
				<div class="col-md-6 col-md-offset-3 ">
					<div class="well">
						<p>Username : ${pageContext.request.userPrincipal.name}</p>

						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<p>Congratulations! You are an admin!</p>
						</sec:authorize>
						<p>Your funds: ${funds.getFund()}</p>
						<hr>
						<form id="updateFunds" class="form-horizontal" role="form"
							method="post">
							<div id="signupalert" style="display: none"
								class="alert alert-danger">
								<p>Error:</p>
								<span></span>
							</div>
							<div class="form-group">
								<label for="telephone" class="col-md-4 control-label">Add</label>
								<div class="col-md-8">
									<input type="text" class="form-control" name="funds"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8  ">
									<button class="btn btn-success btn-lg btn-block" type="submit">Add
										funds</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
		<div id="push"></div>
	</div>
	<%@ include file="includes/footer.html"%>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/addFundsValidate.js"></script>
</body>
</html>