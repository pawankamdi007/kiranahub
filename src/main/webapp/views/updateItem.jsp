<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Update Item"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Update Item</h3><br>
		
        <form:form action="addItem" method="post" modelAttribute="myItems">
        
       
       	<div class="form-group">
       	<label class="col-md-3 control-label">Item Id</label>
       	<div class="col-md-9">
        <form:input path="id" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp; 
       
      	<div class="form-group">
       	<label class="col-md-3 control-label">Item Name</label>
       	<div class="col-md-9">
        <form:input path="itemName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Brand Name</label>
       	<div class="col-md-9">
        <form:input path="brandName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Category</label>
       	<div class="col-md-9">
        <form:input path="category" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Price</label>
       	<div class="col-md-9">
        <form:input path="price" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Quantity</label>
       	<div class="col-md-9">
        <form:input path="quantity" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	
        <!-- Button -->
 		<div class="col-md-offset-3 col-md-9">
 		<button type="submit" class="btn btn-primary">Update</button>
		</div>
      	
      	
        </form:form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>
