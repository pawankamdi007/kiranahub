<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Add Item"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Add Item</h3><br>
		
        <form:form action="addItem" method="post" modelAttribute="inventory">
        
       
      	<div class="form-group">
       	<label class="col-md-3 control-label">Item Name</label>
       	<div class="col-md-9">
        <form:input path="itemName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label  class="col-md-3 control-label">Brand Name</label>
       	<div class="col-md-9">
        <form:input path="brandName" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Price</label>
       	<div class="col-md-9">
        <form:input path="price" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Category</label>
       	<div class="col-md-9">
        <form:select class="form-control"   path="category">
			<c:forEach items="${addCategories }" var="addCategories">
				<form:option value="${addCategories.category}">${addCategories.category}</form:option>
			</c:forEach>
		</form:select>
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
 		<button type="reset" class="btn btn-primary">Reset</button>
 		<button type="submit" class="btn btn-primary">Add Item</button>
		</div>
      	
      	
        </form:form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>