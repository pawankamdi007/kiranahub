<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="Cart"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">Cart</h3><br>
        
        <table class="table" id="DataTables_Table_0" role="grid">
               <thead>
                  <tr role="row">
                      
                     <th>Item Name</th>
                      <th>Brand Name</th>
                     
                      <th>Price</th>
                      <th>Action</th>
                                       
                  </tr>
               </thead>
               <tbody >
               <c:forEach var="allItems" items="${allItems}">
                  <tr>
                    
                     <td>${allItems.itemName}</td>
                     <td>${allItems.brandName}</td>
                    
                     <td>${allItems.price}</td>
                    <td><a class="btn btn-danger" href="deleteCartItem?id=${allItems.id}" onclick="if (!(confirm('Are you sure you want to remove this Item from Cart ?'))) return false">Remove</a>&nbsp; &nbsp;</td>
                       
                     </tr>
                
                     </c:forEach>
                   
               </tbody>
            </table>
        
      </div>
		</div>
		</div>


<c:import url="/include/footer.jsp"></c:import>
