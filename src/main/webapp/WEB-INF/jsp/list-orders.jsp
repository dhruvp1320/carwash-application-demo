<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1>Manage Orders</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Order Date</th>
            <th>Service Availed</th>
            <th>Customer</th>
            <th>Attendant</th>
            <th>Amount</th>
            <th>Status</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.orderDate}</td>
                <td>${order.service.name}</td>
                <td>${order.customer.firstName} ${order.customer.lastName}</td>
                <td>${order.attendant.firstName} ${order.attendant.lastName}</td>
                <td>${order.amount}</td>
                <td>${order.orderStatus}</td>
                <td><a type="button" class="btn btn-success"
                       href="/order/update?id=${order.id}"><i class="glyphicon glyphicon-pencil"></i> Update</a></td>
                <td><a type="button" class="btn btn-warning"
                       href="/order/delete?id=${order.id}"><i class="glyphicon glyphicon-trash"></i> Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a type="button" class="btn btn-info" href="/order/add"><i class="glyphicon glyphicon-plus"></i> Add New Job Order</a>
    </div>
</div>
<script type="text/javascript">
	$('.navbar-nav li').removeClass('active');
	$('#orderNav').addClass('active');
</script>
<%@include file="common/footer.jspf" %>