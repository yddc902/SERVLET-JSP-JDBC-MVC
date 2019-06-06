<!DOCTYPE html>
<html>
    <head>
        <title>Add New Employee</title>
        <style>
            .a-button {
                background-color: DodgerBlue;
                border-radius: 5px;
                color: white;
                padding: .5em;
                text-decoration: none;
            }
            table {
                border-collapse: collapse;
            }

            td {
                padding: 15px;
                text-align: left;
            }
        </style>
    </head>
    <body style="margin:50px;font-family:sans-serif;">
        <form class="" action="Employee" method="post">
            <input type="hidden" name="action" value="insert">
            <table>
                <!--<tr>
                    <td>Employee ID</td>
                    <td> <input type="text" name="empid" required autofocus> </td>
                </tr>-->
                <tr>
                    <td>Employee Name</td>
                    <td> <input type="text" name="empname" required autofocus> </td>
                </tr>
                <tr>
                    <td>Department</td>
                    <td> <input type="text" name="empdept" required> </td>
                </tr>
                <tr>
                    <td>Date of Joinning</td>
                    <td> <input type="date" name="empdoj" required> </td>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td> <input type="text" name="empsalary" required> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="ADD" required> </td>
                </tr>
            </table>
        </form>
        <p><a class="a-button" href="Employee?action=listemployee">View All Employees</a></p>
    </body>
</html>
