<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1>Manage Offered Services</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${services}" var="service">
            <tr>
                <td>${service.name}</td>
                <td>${service.description}</td>
                <td>${service.price}</td>
                <td><a type="button" class="btn btn-success"
                       href="/service/update?id=${service.id}"><i class="glyphicon glyphicon-pencil"></i> Update</a></td>
                <td><a type="button" class="btn btn-warning"
                       href="/service/delete?id=${service.id}"><i class="glyphicon glyphicon-trash"></i> Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a type="button" class="btn btn-info" href="/service/add"><i class="glyphicon glyphicon-plus"></i> Add New Service</a>
    </div>
</div>
<script type="text/javascript">
	$('.navbar-nav li').removeClass('active');
	$('#serviceNav').addClass('active');
</script>
<%@include file="common/footer.jspf" %>