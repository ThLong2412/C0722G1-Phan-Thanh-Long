<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/20/2022
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page import="com.codegym.service.ICustomerService" %>--%>
<%--<%@ page import="com.codegym.service.CustomerServiceFactory" %>--%>
<%--<%@ page import="com.codegym.model.Customer" %>--%>
<%--<%!--%>
<%--    private final ICustomerService customerService = CustomerServiceFactory.getInstance();--%>
<%--%>--%>
<%--<%--%>
<%--    Long id = Long.valueOf(request.getParameter("id"));--%>
<%--    Customer customer = customerService.findOne(id);--%>
<%--%>--%>
<form action="/customers" method="get">
    <fieldset>
        <legend>Customer Information</legend>
        <input type="hidden" name="id" value="${customer.id}">
        <table>
            <tr>
                <td>Id</td>
                <td>
                    ${customer.id}
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <label>
                        <input type="text" name="name" value="${customer.name}">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td>
                    <label>
                        <input type="text" name="email" value="${customer.email}">
                    </label>
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td>
                    <label>
                        <input type="text" name="address" value="${customer.address}">
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
<a href="/customers">Back to list</a>.
