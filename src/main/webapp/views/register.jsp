<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Registration"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Registration</h3><br>
		
        <form:form action="register" method="post" modelAttribute="register">
        
       
      	<div class="form-group">
       	<label class="col-md-3 control-label">First Name</label>
       	<div class="col-md-9">
        <form:input path="firstName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label  class="col-md-3 control-label">Middle Name</label>
       	<div class="col-md-9">
        <form:input path="middleName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Last Name</label>
       	<div class="col-md-9">
        <form:input path="lastName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Contact Number</label>
       	<div class="col-md-9">
        <form:input path="contactNumber" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Email</label>
       	<div class="col-md-9">
        <form:input path="email" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Password</label>
       	<div class="col-md-9">
        <form:password path="password" cssClass="form-control"></form:password>
       	</div>
      	</div>&nbsp;
    
      	
        <!-- Button -->
 		<div class="col-md-offset-3 col-md-9">
 		<button type="reset" class="btn btn-primary">Reset</button>
 		<button type="submit" class="btn btn-primary">Register</button>
		</div>
      		
        </form:form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>