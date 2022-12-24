<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:choose>
	<c:when test="${building == null }">
		<c:url var="buildingCRUDUrl" value="/admin/building-save" />
	</c:when>
	<c:otherwise>
		<c:url var="buildingCRUDUrl" value="/admin/building-update" />
	</c:otherwise>
</c:choose>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try {
			ace.settings.check('main-container', 'fixed')
		} catch (e) {
		}
	</script>

	<div class="main-content">
		<div class="main-content-inner">
			<%@ include file="/common/admin/breadcrumbs.jsp"%>
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
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-rtl" /> <label class="lbl"
									for="ace-settings-rtl"> Right To Left (rtl)</label>
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
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-hover" /> <label class="lbl"
									for="ace-settings-hover"> Submenu on Hover</label>
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
									<b>${building == null ? "Thêm sản phẩm" : "Cập nhật sản phẩm" }</b>
								</h4>
							</div>

							<form:form modelAttribute="buildingModel"
								action="${buildingCRUDUrl }" method="post"
								id="formFieldBuilding" class="widget-body">
								<div class="widget-main">
									<input type="hidden" class="form-control" name="id"
										value="${building.id }">
									<div class="row">
										<div class="col-sm-2">
											<label for="name" class="form-label"><b>Tên sản
													phẩm</b></label>
										</div>
										<div class="col-sm-10">
											<input type="text" class="form-control" id="name" name="name"
												value="${building.name }">
										</div>
										<div class="w-100"></div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="district" class="form-label"><b>Quận
													hiện có</b></label><br> <select name="district" id="district">
												<option value="" disabled selected>--- Chọn quận
													---</option>
												<c:forEach items="${districts}" var="district">
													<option value="${district}"
														${building.district.equals(district.toString()) ? 'selected' : ''}>${district.name }</option>
												</c:forEach>
											</select>
										</div>
										<div class="col-sm-5">
											<label for="ward" class="form-label"><b>Phường</b></label> <input
												type="text" class="form-control" id="ward" name="ward"
												value="${building.ward }">
										</div>
										<div class="col-sm-5">
											<label for="street" class="form-label"><b>Đường</b></label> <input
												type="text" class="form-control" id="street" name="street"
												value="${building.street }">
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="structure" class="form-label"><b>Kết
													cấu</b></label> <input type="text" class="form-control" id="structure"
												name="structure" value="${building.structure }">
										</div>
										<div class="col-sm-2">
											<label for="numberOfBasement" class="form-label"><b>Số
													tầng hầm</b></label> <input type="text" class="form-control"
												id="numberOfBasement" name="numberOfBasement"
												value="${building.numberOfBasement }">
										</div>
										<div class="col-sm-3">
											<label for="floorArea" class="form-label"><b>Diện
													tích sàn</b></label> <input type="text" class="form-control"
												id="floorArea" name="floorArea"
												value="${building.floorArea }">
										</div>
										<div class="col-sm-5">
											<label for="level" class="form-label"><b>Loại toà
													nhà</b></label>
											<div class="form-group">
												<select id="type" class="multiselect" multiple="multiple"
													name="type">
													<c:forEach items="${rentTypes}" var="rentType">
														<option value="${rentType}"
															${building.type.contains(rentType.toString()) ? "selected" : "" }>${rentType.value }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="direction" class="form-label"><b>Hướng</b></label>
											<input type="text" class="form-control" id="direction"
												name="direction" value="${building.direction }">
										</div>
										<div class="col-sm-2">
											<label for="level" class="form-label"><b>Hạng</b></label> <input
												type="text" class="form-control" id="level" name="level"
												value="${building.level }">
										</div>
										<div class="col-sm-3">
											<label for="rentAreas" class="form-label"><b>Diện
													tích thuê</b></label> <input type="text" class="form-control"
												id="rentAreas" name="rentAreas"
												value="${building.rentAreas }">
										</div>
										<div class="col-sm-5">
											<label for="rentAreaDescription" class="form-label"><b>Mô
													tả diện tích</b></label> <input type="text" class="form-control"
												id="rentAreaDescription" name="rentAreaDescription"
												value="${building.rentAreaDescription }">
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-sm-2">
											<label for="rentPrice" class="form-label"><b>Giá
													thuê</b></label> <input type="text" class="form-control" id="rentPrice"
												name="rentPrice" value="${building.rentPrice }">
										</div>
										<div class="col-sm-3">
											<label for="rentPriceDescription" class="form-label"><b>Mô
													tả giá</b></label> <input type="text" class="form-control"
												id="rentPriceDescription" name="rentPriceDescription"
												value="${building.rentPriceDescription }">
										</div>
										<div class="col-sm-2">
											<label for="serviceFee" class="form-label"><b>Phí
													dịch vụ</b></label> <input type="text" class="form-control"
												id="serviceFee" name="serviceFee"
												value="${building.serviceFee }">
										</div>
										<div class="col-sm-3">
											<label for="overtimeFee" class="form-label"><b>Phí
													ngoài giờ</b></label> <input type="text" class="form-control"
												id="overtimeFee" name="overtimeFee"
												value="${building.overtimeFee }">
										</div>
										<div class="col-sm-2">
											<label for="brokerageFee" class="form-label"><b>Phí
													môi giới</b></label> <input type="text" class="form-control"
												id="brokerageFee" name="brokerageFee"
												value="${building.brokerageFee }">
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-sm-6">
											<label for="carFee" class="form-label"><b>Phí ô
													tô</b></label> <input type="text" class="form-control" id="carFee"
												name="carFee" value="${building.carFee }">
										</div>
										<div class="col-sm-6">
											<label for="managerPhone" class="form-label"><b>Phí
													mô tô</b></label> <input type="text" class="form-control"
												id="motorbikeFee" name="motorbikeFee"
												value="${building.motorbikeFee }">
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-sm-3">
											<label for="managerName" class="form-label"><b>Tiền
													điện</b></label> <input type="text" class="form-control"
												id="electricityFee" name="electricityFee"
												value="${building.electricityFee }">
										</div>
										<div class="col-sm-3">
											<label for="deposit" class="form-label"><b>Đặt
													cọc</b></label> <input type="text" class="form-control" id="deposit"
												name="deposit" value="${building.deposit }">
										</div>
										<div class="col-sm-2">
											<label for="payment" class="form-label"><b>Thanh
													toán</b></label> <input type="text" class="form-control" id="payment"
												name="payment" value="${building.payment }">
										</div>
										<div class="col-sm-4">
											<label for="renttime" class="form-label"><b>Thời
													hạn thuê</b></label> <input type="text" class="form-control"
												id="renttime" name="renttime" value="${building.renttime }">
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-sm-4">
											<label for="decorationTime" class="form-label"><b>Thời
													gian trang trí</b></label> <input type="text" class="form-control"
												id="decorationTime" name="decorationTime"
												value="${building.decorationTime }">
										</div>
										<div class="col-sm-4">
											<label for="managerName" class="form-label"><b>Tên
													quản lý</b></label> <input type="text" class="form-control"
												id="managerName" name="managerName"
												value="${building.managerName }">
										</div>
										<div class="col-sm-4">
											<label for="managerPhone" class="form-label"><b>Số
													điện thoại quản lý</b></label> <input type="text" class="form-control"
												id="note" name="managerPhone"
												value="${building.managerPhone }">
										</div>
									</div>

									<br>
									<div class="row">
										<div class="col-sm-12">
											<label for="note" class="form-label"><b>Ghi chú</b></label>
											<textarea rows="6" style="width: 100%;" name="note">${building.note }</textarea>
										</div>
									</div>
									<button class="btn btn-success" type="button" id="buildingCRUD">
										<b>${building == null ? "Thêm" : "Cập nhật" }</b><i
											class="ace-icon fa fa-arrow-right icon-on-right"></i>
									</button>
								</div>
							</form:form>
						</div>
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
											<span class="title">Validation states</span></li>

										<li data-step="2"><span class="step">2</span> <span
											class="title">Alerts</span></li>

										<li data-step="3"><span class="step">3</span> <span
											class="title">Payment Info</span></li>

										<li data-step="4"><span class="step">4</span> <span
											class="title">Other Info</span></li>
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

								<button class="btn btn-success btn-sm btn-next"
									data-last="Finish">
									Next <i class="ace-icon fa fa-arrow-right icon-on-right"></i>
								</button>

								<button class="btn btn-danger btn-sm pull-left"
									data-dismiss="modal">
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

<a href="#" id="btn-scroll-up"
	class="btn-scroll-up btn btn-sm btn-inverse"> <i
	class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
</div>
<!-- /.main-container -->

<script src="assets/js/jquery.2.1.1.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->
<!-- inline scripts related to this page -->
<script type="text/javascript">
	jQuery(function($) {
		var demo1 = $('select[name="duallistbox_demo1[]"]')
				.bootstrapDualListbox(
						{
							infoTextFiltered : '<span class="label label-purple label-lg">Filtered</span>'
						});
		var container1 = demo1.bootstrapDualListbox('getContainer');
		container1.find('.btn').addClass('btn-white btn-info btn-bold');

		/**var setRatingColors = function() {
			$(this).find('.star-on-png,.star-half-png').addClass('orange2').removeClass('grey');
			$(this).find('.star-off-png').removeClass('orange2').addClass('grey');
		}*/
		$('.rating').raty({
			'cancel' : true,
			'half' : true,
			'starType' : 'i'
		/**,
		
		'click': function() {
			setRatingColors.call(this);
		},
		'mouseover': function() {
			setRatingColors.call(this);
		},
		'mouseout': function() {
			setRatingColors.call(this);
		}*/
		})//.find('i:not(.star-raty)').addClass('grey');

		//////////////////
		//select2
		$('.select2').css('width', '200px').select2({
			allowClear : true
		})
		$('#select2-multiple-style .btn').on('click', function(e) {
			var target = $(this).find('input[type=radio]');
			var which = parseInt(target.val());
			if (which == 2)
				$('.select2').addClass('tag-input-style');
			else
				$('.select2').removeClass('tag-input-style');
		});

		//////////////////
		$('.multiselect')
				.multiselect(
						{
							enableFiltering : true,
							buttonClass : 'btn btn-white btn-primary',
							templates : {
								button : '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
								ul : '<ul class="multiselect-container dropdown-menu"></ul>',
								filter : '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
								filterClearBtn : '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
								li : '<li><a href="javascript:void(0);"><label></label></a></li>',
								divider : '<li class="multiselect-item divider"></li>',
								liGroup : '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
							}
						});

		///////////////////

		//typeahead.js
		//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
		var substringMatcher = function(strs) {
			return function findMatches(q, cb) {
				var matches, substringRegex;

				// an array that will be populated with substring matches
				matches = [];

				// regex used to determine if a string contains the substring `q`
				substrRegex = new RegExp(q, 'i');

				// iterate through the pool of strings and for any string that
				// contains the substring `q`, add it to the `matches` array
				$.each(strs, function(i, str) {
					if (substrRegex.test(str)) {
						// the typeahead jQuery plugin expects suggestions to a
						// JavaScript object, refer to typeahead docs for more info
						matches.push({
							value : str
						});
					}
				});

				cb(matches);
			}
		}

		$('input.typeahead').typeahead({
			hint : true,
			highlight : true,
			minLength : 1
		}, {
			name : 'states',
			displayKey : 'value',
			source : substringMatcher(ace.vars['US_STATES'])
		});

		///////////////

		//in ajax mode, remove remaining elements before leaving page
		$(document).one(
				'ajaxloadstart.page',
				function(e) {
					$('[class*=select2]').remove();
					$('select[name="duallistbox_demo1[]"]')
							.bootstrapDualListbox('destroy');
					$('.rating').raty('destroy');
					$('.multiselect').multiselect('destroy');
				});

	});

	$('#buildingCRUD').click(function(e) {
		e.preventDefault();
		$("#formFieldBuilding").submit();
	});
</script>