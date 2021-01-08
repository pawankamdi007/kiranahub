<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Category"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Add Category</h3><br>
		
        <form:form action="addcategory" method="post" modelAttribute="category">
        
       
      	<div class="form-group">
       	<label class="col-md-3 control-label">Add Category</label>
       	<div class="col-md-9">
        <form:input path="category" cssClass="form-control"></form:input>
       	</div>
      	</div>&nbsp;
  
      	
        <!-- Button -->
 		<div class="col-md-offset-3 col-md-9">
 		<button type="reset" class="btn btn-primary">Reset</button>
 		<button type="submit" class="btn btn-primary">Add Category</button>
		</div>
      	
      	
        </form:form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>