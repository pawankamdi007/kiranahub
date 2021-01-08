<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/include/header.jsp">
<c:param name="title" value="Log In"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Admin Login</h3><br>
        
        <div style="margin-left: 15px;color: red; %>">
        <c:if test="${msg!=null }">
        ${msg }
        </c:if>
		</div>
		
        <form:form action="adminlogin" method="post" modelAttribute="register">
        
       
      	<div class="form-group">
       	<label for="email" class="col-md-3 control-label">Email</label>
       	<div class="col-md-9">
        <form:input path="email" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label for="password" class="col-md-3 control-label">Password</label>
       	<div class="col-md-9">
        <form:password path="password" cssClass="form-control"></form:password>
       	</div>
      	</div>&nbsp;
      	
      	
      	<div style="margin-left: 155px">
        <a href="goToRegister">Register Here</a><br>
      	</div>&nbsp;      	     	
    
      	
        <!-- Button -->
 		<div class="col-md-offset-3 col-md-9">
 		<button type="submit" class="btn btn-primary">Log In</button>
		</div>
      	
      	
        </form:form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>
