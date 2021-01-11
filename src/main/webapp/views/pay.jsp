<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Registration"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Registration</h3><br>
		
        <form action="pay" method="post" >
        
       
      	<div class="form-group">
       	<label class="col-md-3 control-label">Customer Id</label>
       	<div class="col-md-9">
        <input name="id" value="${id}" readonly="readonly" class="form-control"></input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Total Amount</label>
       	<div class="col-md-9">
        <input name="totalAmount" class="form-control"></input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Paid Amount</label>
       	<div class="col-md-9">
        <input name="paidAmount" class="form-control"></input>
       	</div>
      	</div>&nbsp;
      	
      	<div class="form-group">
       	<label class="col-md-3 control-label">Balance Amount</label>
       	<div class="col-md-9">
        <input name="balanceAmount" class="form-control"></input>
       	</div>
      	</div>&nbsp;
      	
      	
    
      	
        <!-- Button -->
 		<div class="col-md-offset-3 col-md-9">
 		<button type="submit" class="btn btn-primary">Pay</button>
		</div>
      	
      	
        </form>
		</div>
	</div>
</div>

<c:import url="/include/footer.jsp"></c:import>
