<c:if test="${not empty error}">
							<div id="errorAlert" class="alert alert-danger" role="alert">${error}</div>
						</c:if>
<form id="loginForm" class="form-horizontal"
	action="j_spring_security_check" role="form" method="post">

	<div style="margin-bottom: 25px" class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-user"></i></span> <input id="j_username"
			name="j_username" type="text" class="form-control" value=""
			placeholder="login" required="">
	</div>

	<div style="margin-bottom: 25px" class="input-group">
		<span class="input-group-addon"><i
			class="glyphicon glyphicon-lock"></i></span> <input id="j_password"
			name="j_password" type="password" class="form-control"
			placeholder="password" required="">
	</div>

	<div class="input-group">
		<div class="row">
			<div class="col-md-6">
				<div class="checkbox">
					<label> <input id="login-remember" type="checkbox"
						name="remember-me" value="1"> Remember me
					</label>
				</div>
			</div>
			<div class="col-md-6">
				<a href="${pageContext.request.contextPath}/forgotPassword">Forgot
					password?</a>
			</div>
		</div>
	</div>
	<p></p>
	<button class="btn btn-success btn-lg btn-block" type="submit">Login</button>
</form>

