<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/20/2022
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.codegym.service.CustomerService" %>
<%@ page import="com.codegym.service.CustomerServiceFactory" %>
<%@ page import="com.codegym.model.Customer" %>
<%!
    private  CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    Long id = Long.valueOf(request.getParameter("id"));
    Customer customer = customerService.findOne(id);
%>
<form action="/customers/" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="<%= customer.getId() %>">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    <%= customer.getId() %>
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <label>
                        <input type="text" name="name" value="<%= customer.getName() %>">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <label>
                        <input type="text" name="email" value="<%= customer.getEmail() %>">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <label>
                        <input type="text" name="address" value="<%= customer.getAddress() %>">
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Update">
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<a href="/customers/">Back to list</a>.
