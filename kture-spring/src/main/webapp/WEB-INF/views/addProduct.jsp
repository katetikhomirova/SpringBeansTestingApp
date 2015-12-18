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
				<div class="col-md-4 col-md-offset-4 ">
					<div class="well">
						<p>Add new product</p>
						<form id="addProduct" class="form-horizontal" role="form"
							method="post">

							<div id="signupalert" style="display: none"
								class="alert alert-danger">
								<p>Error:</p>
								<span></span>
							</div>

							<div class="form-group">
								<label for="title" class="col-md-4 control-label">Title</label>
								<div class="col-md-8">
									<input type="text" class="form-control" name="title"
										placeholder="Title">
								</div>
							</div>
							<div class="form-group">
								<label for="price" class="col-md-4 control-label">Price</label>
								<div class="col-md-8">
									<input type="text" class="form-control" name="price"
										placeholder="">
								</div>
							</div>

							<div class="form-group">
								<label for="description" class="col-md-4 control-label">Description</label>
								<div class="col-md-8">
									<textarea class="form-control" name="description" rows="3"></textarea>
								</div>
							</div>

							<div class="form-group">
								<!-- Button -->
								<div class="col-md-offset-4 col-md-8">
									<button id="btn-signup" type="submit"
										class="btn btn-info btn-lg btn-block">Add</button>

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
		src="${pageContext.request.contextPath}/resources/js/addProductValidate.js"></script>
</body>
</html>