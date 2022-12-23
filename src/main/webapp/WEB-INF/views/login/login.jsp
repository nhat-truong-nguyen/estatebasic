<%@ include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<c:url var="userLogin" value="/login"/>
<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section"># Estate # Admin</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="login-wrap p-0">
					<form:form modelAttribute="userModel" action="${userLogin}" method="post" class="signin-form">
						<div class="form-group">
							<input name="username" type="text" class="form-control" placeholder="Nhập username..."
								required>
						</div>
						<div class="form-group">
							<input name="password" id="password-field" type="password" class="form-control"
								placeholder="Nhập mật khẩu..." required> <span
								toggle="#password-field"
								class="fa fa-fw fa-eye field-icon toggle-password"></span>
						</div>
						<div class="form-group">
							<button type="submit"
								class="form-control btn btn-primary submit px-3">Đăng nhập</button>
						</div>
						<div class="form-group d-md-flex">
							<div class="w-50">
								<label class="checkbox-wrap checkbox-primary">Ghi nhớ tài khoản <input name="remember" type="checkbox" checked> <span
									class="checkmark"></span>
								</label>
							</div>
							<div class="w-50 text-md-right">
								<a href="<c:url value='/forget-password'/> " style="color: #fff">Quên mật khẩu</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</section>