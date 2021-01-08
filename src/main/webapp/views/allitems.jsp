<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="All Items"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-7">
        <h3 style="margin-left: 15px">All Items</h3><br>
        
        <form action="goToSearchItems" method="post">
        
        <div class="col-12 col-sm-12 form-inline">
        <input class="form-control" type="text" name="category" placeholder="Search By category" >
   
        <input class="form-control" type="text" name="price" placeholder="Search By Price" > 
        <button class="btn btn-success ml-3" type="submit">Search</button>
       </div>
        </form>
        
        
        <table class="table display data-table text-nowrap dataTable no-footer" id="DataTables_Table_0" role="grid">
               <thead>
                  <tr role="row">
                      
                     <th>Item Name</th>
                      <th>Brand Name</th>
                      <th>Quantity</th>
                      <th>Price</th>
                     <th style="text-align:center">Action</th>
                                       
                  </tr>
               </thead>
               <tbody>
               <c:forEach var="allItems" items="${allItems}">
                  <tr> 
                     <td>${allItems.itemName}</td>
                     <td>${allItems.brandName}</td>
                     <td>${allItems.quantity}</td>
                     <td>${allItems.price}</td>
                     <td><a class="btn btn-info" href="goToUpdateItem?id=${allItems.id }">Update </a>
                     <a class="btn btn-danger" href="deleteItem?id=${allItems.id }" onclick="if (!(confirm('Are you sure you want to delete this Category?'))) return false">Delete</a>&nbsp; &nbsp;
                     <a class="btn btn-success" href="goToAddToCart?id=${allItems.id }">Add to Cart </a>
                     <button class="btn">+</button> 
                     &nbsp;
                     <button class="btn" >-</button>
                     </td>
                     <td><input  class="" type="text" name="qt" value="0"></td>
                      </tr>
                
                     </c:forEach>
                   
               </tbody>
            </table>
            <a href="goToAddItem" class="btn btn-success mt-5">Add Item</a>
      </div>
      
      
		</div>
		</div>


<c:import url="/include/footer.jsp"></c:import>
