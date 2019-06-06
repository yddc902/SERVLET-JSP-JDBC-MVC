package com.yashdesai.dao;

import java.sql.*;
import java.util.*;

import com.yashdesai.model.EmployeeModel;
import com.yashdesai.connection.ConnectionProvider;

public class EmployeeDao {
    private Connection conn;

	public EmployeeDao() {
		conn = ConnectionProvider.getConnection();
	}

    public void createEmployee(EmployeeModel employeemodel) {
        try {
            String sql = "insert into employee(empName, empDept, empDOJ, empSalary) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeemodel.getEmpName());
            ps.setString(2, employeemodel.getEmpDept());
            java.sql.Date sqldoj = new java.sql.Date(employeemodel.getEmpDOJ().getTime());
            ps.setDate(3, sqldoj);
            ps.setInt(4, employeemodel.getEmpSalary());
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int empId) {
        try {
            String sql = "DELETE FROM employee WHERE empID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(EmployeeModel employeemodel) {
        try {
            String sql = "update employee set empName=?, empDept=?, empDOJ=?, empSalary=? where empID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeemodel.getEmpName());
            ps.setString(2, employeemodel.getEmpDept());
            java.sql.Date sqldoj = new java.sql.Date(employeemodel.getEmpDOJ().getTime());
            ps.setDate(3, sqldoj);
            ps.setInt(4, employeemodel.getEmpSalary());
            ps.setInt(5, employeemodel.getEmpId());
            ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public List getAllEmployees() {
        List employeeList = new ArrayList();
        try {
            String sql = "select * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                EmployeeModel employeemodel = new EmployeeModel();
                employeemodel.setEmpId(rs.getInt("empID"));
                employeemodel.setEmpName(rs.getString("empName"));
                employeemodel.setEmpDept(rs.getString("empDept"));
                employeemodel.setEmpDOJ(rs.getDate("empDOJ"));
                employeemodel.setEmpSalary(rs.getInt("empSalary"));

                employeeList.add(employeemodel);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public EmployeeModel getEmployeeById(int empId) {
        EmployeeModel employeemodel = new EmployeeModel();
        try {
            String sql = "select * from employee where empID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                //EmployeeModel employeemodel = new EmployeeModel();
                employeemodel.setEmpId(rs.getInt("empID"));
                employeemodel.setEmpName(rs.getString("empName"));
                employeemodel.setEmpDept(rs.getString("empDept"));
                employeemodel.setEmpDOJ(rs.getDate("empDOJ"));
                employeemodel.setEmpSalary(rs.getInt("empSalary"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return employeemodel;
    }
}
