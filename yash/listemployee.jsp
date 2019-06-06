<%@ page import="com.yashdesai.model.EmployeeModel" %>
<%@ page import="com.yashdesai.dao.EmployeeDao" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <title>All Employees</title>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }
            th{
                padding: 8px;
                text-align: center;
                border: 3px solid #dee;
            }
            td {
                padding: 8px;
                text-align: left;
                border: 1px solid #ddd;
            }
            .a-button {
                background-color: DodgerBlue;
                border-radius: 5px;
                color: white;
                padding: .5em;
                text-decoration: none;
            }
            
            tr:hover {background-color:#f5f5f5;}
        </style>
    </head>
    <body style="font-family:sans-serif; margin:50px;">
        <%
            EmployeeDao dao = new EmployeeDao();
            List<EmployeeModel> employeeList = dao.getAllEmployees();
            if(employeeList.isEmpty()) {out.println("<h1><center>No Records Found</center></h1>");} else {
        %>
        <table >
            <tr>
                <th>Employee ID</th>
                <th>Employee Name</th>
                <th>Department</th>
                <th>Date of Joinning</th>
                <th>Salary</th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <% for(EmployeeModel employee : employeeList) {  %>
                <td><%=employee.getEmpId()%></td>
                <td><%=employee.getEmpName()%></td>
                <td><%=employee.getEmpDept()%></td>
                <td><%=employee.getEmpDOJ()%></td>
                <td><%=employee.getEmpSalary()%></td>
                <td><a class="edit-btn" href="Employee?action=editform&empid=<%=employee.getEmpId()%>">Edit</a></td>
				<td><a class="delete-btn" href="Employee?action=delete&empid=<%=employee.getEmpId()%>">Delete</a></td>
            </tr>
                <% } }  %>
        </table>
        <p><a class="a-button" href="employee.jsp">Create New Employee</a></p>
    </body>
</html>
