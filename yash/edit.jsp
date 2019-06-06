<%@ page import="com.yashdesai.model.EmployeeModel" %>
<%@ page import="com.yashdesai.dao.EmployeeDao" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit Employee</title>
    </head>
    <body>
        <% EmployeeModel employee = new EmployeeModel(); %>
        <% EmployeeDao dao = new EmployeeDao(); %>

        <form class="" action="Employee" method="post">
            <input type="hidden" name="action" value="update" /> 
            <%
                String id = request.getParameter("empid");
                if(!(id == null)) {
                    int empId = Integer.parseInt(id);
                    employee = dao.getEmployeeById(empId);
                // } will be closed in next scriptlet
            %>
            <table>
                <tr>
                    <td>Employee ID</td>
                    <td> <input type="text" name="empid" value="<%=employee.getEmpId()%>" readonly> </td>
                </tr>
                <tr>
                    <td>Employee Name</td>
                    <td> <input type="text" name="empname" value="<%=employee.getEmpName()%>"  autofocus required> </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td> <input type="text" name="empdept" value="<%=employee.getEmpDept()%>" required> </td>
                </tr>
                <tr>
                    <td>Date of Joinning</td>
                    <td> <input type="date" name="empdoj" value="<%=employee.getEmpDOJ()%>" required> </td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td> <input type="text" name="empsalary" value="<%=employee.getEmpSalary()%>" required> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="UPDATE" required> </td>
                </tr>
            </table>
            <%
				} else
					out.println("ID Not Found");
			%>
        </form>
    </body>
</html>
