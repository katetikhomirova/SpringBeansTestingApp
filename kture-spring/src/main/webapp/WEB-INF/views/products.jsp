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
				<div class="col-md-8 col-md-offset-2 ">
					<div class="well">
						<a class="btn btn-success btn-lg "
							href="${pageContext.request.contextPath}/addProduct">Add
							product</a>
						<table class="table .table-hover">
							<thead>
								<tr>
									<th>Title</th>
									<th>Description</th>
									<th>Price</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="product">

									<tr>
										<td>${product.getTitle()}</td>
										<td>${product.getDescription()}</td>
										<td>${product.getPrice()}</td>
										<td><c:if
												test="${userAccount.getUserId() != product.getUserId()}">
												<form
													action="${pageContext.request.contextPath}/buyProduct/${product.getId()}"
													method="post">
													<button id="btn-signup" type="submit"
														class="btn btn-info btn-md btn-block"
														onclick="return confirm('Are you sure?')">Buy</button>
												</form>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

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