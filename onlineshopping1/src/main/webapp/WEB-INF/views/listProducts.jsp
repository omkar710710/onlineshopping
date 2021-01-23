<div class="container">

	<div class="row">

		<!-- would display sidebar -->
		<div class="col-md-3">

			<%@include file="./shared/sidebar.jsp"%>


		</div>


		<!-- would display products -->
		<div class="col-md-9">

			<!-- Added breadcrumb component -->


			<div class="row">


				<div class="col-lg-12">
					<c:if test="${userClickAllProducts==true}">

						<script>
							window.categoryId = '';
						</script>


						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Product</li>



						</ol>

					</c:if>

					<c:if test="${userClickCategoryProducts==true}">
						<script>
							window.categoryId = '${category.id}';
						</script>




						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>



						</ol>

					</c:if>
				</div>





			</div>

			<div class="row">
				<div class="col-xs-12">

<div class="container-fluid">
		<div class="table-responsive">
				<table id="productListTable"
										class="table table-striped table-bordered">
				
										<thead>
				
											<tr>
												<th></th>
												<th>Name</th>
												<th>Brand</th>
												<th>UnitPrice</th>
												<th>Quantity</th>
												<th></th>
												
											</tr>
				
										</thead>
										<tfoot>
				
											<tr>
												
												
												
											</tr>
				
										</tfoot>
				
									</table>
		</div>
</div>

					

				</div>

			</div>

		</div>


	</div>



</div>