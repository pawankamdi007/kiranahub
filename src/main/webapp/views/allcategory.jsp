<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<c:import url="/include/adminheader.jsp">
<c:param name="title" value="All Category"></c:param>
</c:import>

<div class="container mtb">
	<div class="row">
		<div class="col-md-6">
        <h3 style="margin-left: 15px">All Category</h3><br>
        
        <table class="table display data-table text-nowrap dataTable no-footer" id="DataTables_Table_0" role="grid">
               <thead>
                  <tr role="row">
                      
                     <th>Category Name</th>
                     <th>Action</th>
                   
                     
                    
                  </tr>
               </thead>
               <tbody>
               <c:forEach var="allCategory" items="${allCategory}">
                  <tr>
                    
                     <td>${allCategory.category}</td>
                       <td><a href="goToUpdateCategory?id=${allCategory.id }">Update |</a>
                       <a href="deleteCategory?id=${allCategory.id }" onclick="if (!(confirm('Are you sure you want to delete this Category?'))) return false">Delete</a>&nbsp; &nbsp;
                     
                       </tr>
                
                     </c:forEach>
                   
               </tbody>
            </table>
        
      </div>
		</div>
		</div>


<c:import url="/include/footer.jsp"></c:import>
