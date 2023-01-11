<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
		<c:url var="staffList" value="/api/staffs-list" />
		<c:url var="customerStaffList" value="/api/customer-staffs?customerId=" />
		<c:url var="customerSearchURL" value="/admin/customer-search" />

		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try {
					ace.settings.check('main-container', 'fixed')
				} catch (e) {
				}
			</script>

			<div class="main-content">
				<div class="main-content-inner">
					<%@ include file="/common/admin/breadcrumbs.jsp" %>
						<div class="page-content">
							<div class="ace-settings-container" id="ace-settings-container">
								<div class="ace-settings-box clearfix" id="ace-settings-box">
									<div class="pull-left width-50">
										<div class="ace-settings-item">
											<div class="pull-left">
												<select id="skin-colorpicker" class="hide">
													<option data-skin="no-skin" value="#438EB9">#438EB9</option>
													<option data-skin="skin-1" value="#222A2D">#222A2D</option>
													<option data-skin="skin-2" value="#C6487E">#C6487E</option>
													<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
												</select>
											</div>
											<span>&nbsp; Choose Skin</span>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2"
												id="ace-settings-navbar" /> <label class="lbl"
												for="ace-settings-navbar"> Fixed Navbar</label>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2"
												id="ace-settings-sidebar" /> <label class="lbl"
												for="ace-settings-sidebar"> Fixed Sidebar</label>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2"
												id="ace-settings-breadcrumbs" /> <label class="lbl"
												for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
											<label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2"
												id="ace-settings-add-container" /> <label class="lbl"
												for="ace-settings-add-container"> Inside <b>.container</b>
											</label>
										</div>
									</div>
									<!-- /.pull-left -->

									<div class="pull-left width-50">
										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
											<label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2"
												id="ace-settings-compact" /> <label class="lbl"
												for="ace-settings-compact"> Compact Sidebar</label>
										</div>

										<div class="ace-settings-item">
											<input type="checkbox" class="ace ace-checkbox-2"
												id="ace-settings-highlight" /> <label class="lbl"
												for="ace-settings-highlight"> Alt. Active Item</label>
										</div>
									</div>
									<!-- /.pull-left -->
								</div>
								<!-- /.ace-settings-box -->
							</div>
							<!-- /.ace-settings-container -->

							<div class="row">
								<div class="col-xs-12">
									<!-- PAGE CONTENT BEGINS -->

									<div class="widget-box">
										<div class="widget-header widget-header-blue widget-header-flat">
											<h4 class="widget-title lighter">
												<b>Tìm kiếm</b>
											</h4>
										</div>

										<form:form modelAttribute="searchModel" action="${customerSearchURL }"
											method="get" id="formSearchBuilding" class="widget-body">
											<div class="widget-main">
												<div class="row">
													<div class="col-sm-6">
														<label for="fullName" class="form-label"><b>Tên khách
																hàng</b></label>
														<form:input type="text" class="form-control" id="fullName"
															name="fullName" path="fullName" />
													</div>
													<div class="col-sm-6">
														<label for="phone" class="form-label"><b>Di động</b></label>
														<form:input type="text" class="form-control" id="phone"
															path="phone" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class="col-sm-6">
														<label for="email" class="form-label"><b>Email</b></label>
														<form:input type="text" class="form-control" id="email"
															path="email" />
													</div>

													<div class="col-sm-6">
														<label for="staffId" class="form-label"><b>Chọn
																nhân viên phụ trách</b></label><br>
														<form:select path="staffId" id="staffId">

															<option value="" disabled selected="selected">--- Chọn nhân viên phụ trách ---
															</option>

															<c:forEach items="${staffs}" var="staff">
																<form:option value="${staff.id }">${staff.fullName }
																</form:option>
															</c:forEach>
														</form:select>
													</div>
												</div>
											</div>
											<br>
											<button class="btn btn-success" type="button" id="btnSearchBuilding">
												<b>Tìm kiếm</b><i class="ace-icon fa fa-arrow-right icon-on-right"></i>
											</button>
										</form:form>
									</div>
								</div>
							</div>

							<%@ include file="/common/admin/customer-table.jsp" %>
								<!-- /.widget-main -->
						</div>
						<!-- /.widget-body -->
				</div>

				<div id="modal-wizard" class="modal">
					<div class="modal-dialog">
						<div class="modal-content">
							<div id="modal-wizard-container">
								<div class="modal-header">
									<ul class="steps">
										<li data-step="1" class="active"><span class="step">1</span>
											<span class="title">Validation states</span>
										</li>

										<li data-step="2"><span class="step">2</span> <span class="title">Alerts</span>
										</li>

										<li data-step="3"><span class="step">3</span> <span class="title">Payment
												Info</span></li>

										<li data-step="4"><span class="step">4</span> <span class="title">Other
												Info</span></li>
									</ul>
								</div>

								<div class="modal-body step-content">
									<div class="step-pane active" data-step="1">
										<div class="center">
											<h4 class="blue">Step 1</h4>
										</div>
									</div>

									<div class="step-pane" data-step="2">
										<div class="center">
											<h4 class="blue">Step 2</h4>
										</div>
									</div>

									<div class="step-pane" data-step="3">
										<div class="center">
											<h4 class="blue">Step 3</h4>
										</div>
									</div>

									<div class="step-pane" data-step="4">
										<div class="center">
											<h4 class="blue">Step 4</h4>
										</div>
									</div>
								</div>
							</div>

							<div class="modal-footer wizard-actions">
								<button class="btn btn-sm btn-prev">
									<i class="ace-icon fa fa-arrow-left"></i> Prev
								</button>

								<button class="btn btn-success btn-sm btn-next" data-last="Finish">
									Next <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
								</button>

								<button class="btn btn-danger btn-sm pull-left" data-dismiss="modal">
									<i class="ace-icon fa fa-times"></i> Cancel
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		</div>
		<!-- /.page-content -->
		</div>
		</div>
		<!-- /.main-content -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script src="assets/js/jquery.2.1.1.min.js"></script>
<![endif]-->
		<!-- inline scripts related to this page -->
		<script type="text/javascript">

			$('#btnSearchBuilding').click(function (e) {
				e.preventDefault();
				$("#formSearchBuilding").submit();
			});

			$('#btnDeleteCustomer').click(function (e) {
				e.preventDefault();
				$("#formIdsCustomer").submit();
			});

			let staffList = document.querySelector("#staffList");
			let customerId = document.querySelector("#customerId");
			let customerStaffs;
			$('.btnStaffList').click(function (e) {
				e.preventDefault();

				customerId.value = this.value;

				$.ajax({
					url: '${customerStaffList}' + this.value,
					type: 'GET',
					contentType: 'application/json',
					dataType: 'json',
					success: function (result) {
						customerStaffs = result;
					},
					error: function (error) {
						console.log(error);
					}
				})

				$.ajax({
					url: '${staffList}',
					type: 'GET',
					contentType: 'application/json',
					dataType: 'json',
					success: function (result) {
						let row = "";
						result.forEach(item => {
							row += '<tr><td class="text-center">' + item.fullName + '</td>';
							row += '<td class="text-center"><label class="pos-rel"><input type="checkbox" name="staffIds" value="' + item.id + '" class="ace"';

							if (customerStaffs.find((staff) => staff.id === item.id)) {
								row += "checked";
							};

							row += '/> <span class="lbl"></span></label ></td></tr>';
						});

						staffList.innerHTML = row;
					},
					error: function (error) {
						console.log(error);
					}
				})

			});

		</script>