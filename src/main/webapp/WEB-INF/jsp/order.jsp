<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
	<div class="page-header">
	  <h1>Job Order Details</h1>
	</div>
	<form class="form-horizontal" action="/order/add" method="post">
		<input type="hidden" id="id" name="id" value="${order.id}" />
		<input type="hidden" id="orderDate" name="orderDate" value="${order.orderDate}" />
		
        <!-- Customer -->        
		<div class="form-group">
			<label class="col-md-2 control-label" for="customer">Customer</label>
			<div class="col-md-8">
				<input type="hidden" id="customerVal" value="${order.customer.id}"/>
				<select name="customer" value="${order.customer}" id="customer" 
					class="form-control">
					<option value="">&lt;Select Customer&gt;</option>
					<c:forEach items="${customers}" var="customer">
						<option value="${customer.id}">${customer.firstName} ${customer.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<a type="button" class="btn btn-info" href="/customer/add" target="_blank"><i class="glyphicon glyphicon-plus"></i> Add New Customer</a>
			</div>
		</div>
		
		<!-- Service -->        
		<div class="form-group">
			<label class="col-md-2 control-label" for="service">Service</label>
			<div class="col-md-8">
				<input type="hidden" id="serviceVal" value="${order.service.id}"/>
				<select name="service" value="${order.customer}" id="service" 
					class="form-control">
					<option value="">&lt;Select Preferred Service&gt;</option>
					<c:forEach items="${services}" var="service">
						<option value="${service.id}">${service.name} ($${service.price})</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
        <!-- Attendant -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="attendant">Attendant</label>
			<div class="col-md-8">
				<input type="hidden" id="attendantVal" value="${order.attendant.id}"/>
				<select name="attendant" value="${order.attendant}" id="attendant" 
					class="form-control">
					<option value="">&lt;Select Attendant&gt;</option>
					<c:forEach items="${attendants}" var="attendant">
						<option value="${attendant.id}">${attendant.firstName} ${attendant.lastName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
				
        <!-- Status -->
		<div class="form-group">
			<label class="col-md-2 control-label" for="orderStatus">Status</label>
			<div class="col-md-8">
				<input type="hidden" id="orderStatusVal" value="${order.orderStatus}"/>
				<select name="orderStatus" value="${order.orderStatus}" id="orderStatus" class="form-control">
					<option value="">&lt;Select Status&gt;</option>
					<c:forEach items="${orderStatuses}" var="orderStatus">
						<option value="${orderStatus}">${orderStatus}</option>
					</c:forEach>
				</select>
				<span class="help-block">Note: New orders will always be in PENDING status.</span>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-md-5"></div>
			<div class="col-md-5">
        		<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-floppy-disk"></i> Save Job Order</button>
        	</div>
       	</div>	
    </form>
</div>
<script>
	$('.navbar-nav li').removeClass('active');
	$('#orderNav').addClass('active');
	$('#customer').val($('#customerVal').val());
	$('#attendant').val($('#attendantVal').val());
	$('#orderStatus').val($('#orderStatusVal').val());
	$('#service').val($('#serviceVal').val());
</script>
<%@include file="common/footer.jspf" %>