<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
	<div class="page-header">
	  <h1>Service Details</h1>
	</div>
	<form class="form-horizontal" action="/service/add" method="post">
        <!-- first name -->
		<input type="hidden" id="id" name="id" value="${service.id}" />
		<div class="form-group">
			<label class="col-md-2 control-label" for="name">Service Name</label>
			<div class="col-md-8">
				<input type="text" name="name" class="form-control" id="name"
					value="${service.name}" required="required"
					placeholder="Service Name" /> 
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="age">Description</label>
			<div class="col-md-8">
				<input type="text" name="description" class="form-control" id="description"
					value="${service.description}" required="required"
					placeholder="Description" /> 
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-2 control-label" for="types">Price</label>
			<div class="col-md-8">
				<div class="input-group">
				  <span class="input-group-addon">$</span>
				  <input type="text" name="price" class="form-control" aria-label="Amount (to the nearest dollar)" value="${service.price}">
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-5"></div>
			<div class="col-md-5">
        		<button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-floppy-disk"></i> Save Service</button>
        	</div>
       	</div>
    </form>
</div>
<script type="text/javascript">
	$('.navbar-nav li').removeClass('active');
	$('#serviceNav').addClass('active');
</script>
<%@include file="common/footer.jspf" %>