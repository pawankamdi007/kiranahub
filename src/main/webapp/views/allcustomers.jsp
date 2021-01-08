<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="All Customers"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-7">
        <h3 style="margin-left: 15px">All Customers</h3><br>
        
        
        <table class="table display data-table text-nowrap dataTable no-footer" id="DataTables_Table_0" role="grid">
               <thead>
                  <tr role="row">
                      
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Mobile </th>
                      <th>City</th>
                     
                     <th style="text-align:center">Action</th>
                                       
                  </tr>
               </thead>
               <tbody>
               <c:forEach var="allcustomer" items="${allcustomer}">
                  <tr> 
                     <td>${allcustomer.firstName}</td>
                     <td>${allcustomer.lastName}</td>
                     <td>${allcustomer.mobile}</td>
                     <td>${allcustomer.city}</td>
                     <td><a class="btn btn-info" href="goToUpdateCustomer?id=${allcustomer.id }">Update </a>
                     <a class="btn btn-danger" href="goTodeleteCustomer?id=${allcustomer.id }" onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>&nbsp; &nbsp;
                     </td>
                     
                      </tr>
                
                     </c:forEach>
                   
               </tbody>
            </table>
            <a href="goToAddItem" class="btn btn-success mt-5">Add Customer</a>
      </div>
      
      
		</div>
		</div>


<c:import url="/include/footer.jsp"></c:import>
