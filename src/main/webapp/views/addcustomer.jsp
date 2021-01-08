<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Add Customer"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Add Customer</h3><br>
		
        <form:form action="addCustomer" method="post" modelAttribute="customer">
        
      	<div class="form-group">
       	<label class="col-md-3 control-label">First Name</label>
       	<div class="col-md-9">
        <form:input path="firstName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Last Name</label>
       	<div class="col-md-9">
        <form:input path="lastName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Gender</label>
       	<div class="col-md-9">
        <form:select class="form-control"   path="gender">
			
				<form:option value="male">Male</form:option>
				<form:option value="female">Female</form:option>
				<form:option value="other">Other</form:option>
		</form:select>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Age</label>
       	<div class="col-md-9">
        <form:input path="age" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Mobile No</label>
       	<div class="col-md-9">
        <form:input path="mobile" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">City</label>
       	<div class="col-md-9">
        <form:input path="city" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Address</label>
       	<div class="col-md-9">
        <form:input path="address" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
    
      	
        <!-- Button -->
 		<div class="col-md-offset-3 col-md-9">
 		<button type="reset" class="btn btn-primary">Reset</button>
 		<button type="submit" class="btn btn-primary">Add Customer</button>
		</div>
      	
      	
        </form:form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>