<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1>Manage Customers</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Full Name</th>
            <th>Address</th>
            <th>Gender</th>
            <th>Contact Number</th>
            <th>Email Address</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.firstName} ${customer.lastName}</td>
                <td>${customer.address}</td>
                <td>${customer.gender}</td>
                <td>${customer.contactNumber}</td>
                <td>${customer.emailAddress}</td>
                <td><a type="button" class="btn btn-success"
                       href="/customer/update?id=${customer.id}"><i class="glyphicon glyphicon-pencil"></i> Update</a></td>
                <td><a type="button" class="btn btn-warning"
                       href="/customer/delete?id=${customer.id}"><i class="glyphicon glyphicon-trash"></i> Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a type="button" class="btn btn-info" href="/customer/add"><i class="glyphicon glyphicon-plus"></i> Add New Customer</a>
    </div>
</div>
<script type="text/javascript">
	$('.navbar-nav li').removeClass('active');
	$('#customerNav').addClass('active');
</script>
<%@include file="common/footer.jspf" %>