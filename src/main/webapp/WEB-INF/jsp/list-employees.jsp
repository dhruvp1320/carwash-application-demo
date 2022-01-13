<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>
<div class="container">
    <h1>Manage Employees</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Full Name</th>
            <th>Address</th>
            <th>Gender</th>
            <th>Contact Number</th>
            <th>Email Address</th>
            <th>Position</th>
            <th>Status</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.firstName} ${employee.lastName}</td>
                <td>${employee.address}</td>
                <td>${employee.gender}</td>
                <td>${employee.contactNumber}</td>
                <td>${employee.emailAddress}</td>
                <td>${employee.position}</td>
                <td>${employee.status}</td>
                <td><a type="button" class="btn btn-success"
                       href="/employee/update?id=${employee.id}"><i class="glyphicon glyphicon-pencil"></i> Update</a></td>
                <td><a type="button" class="btn btn-warning"
                       href="/employee/delete?id=${employee.id}"><i class="glyphicon glyphicon-trash"></i> Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a type="button" class="btn btn-info" href="/employee/add"><i class="glyphicon glyphicon-plus"></i> Add New Employee</a>
    </div>
</div>
<script type="text/javascript">
	$('.navbar-nav li').removeClass('active');
	$('#employeeNav').addClass('active');
</script>
<%@include file="common/footer.jspf" %>