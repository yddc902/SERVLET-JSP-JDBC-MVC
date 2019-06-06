package com.yashdesai.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;

import com.yashdesai.model.EmployeeModel;
import com.yashdesai.dao.EmployeeDao;

public class EmployeeController extends HttpServlet {
    private static String CREATE = "/employee.jsp";
    private static String UPDATE = "/edit.jsp";
    private static String READ = "/listemployee.jsp";

    private EmployeeDao dao;

	public EmployeeController() {
		super();
        dao = new EmployeeDao();
	}

    protected void doGet(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String eId = request.getParameter("empid");
        String action = request.getParameter("action");

        if(action.equals("insert")) {
            EmployeeModel employee = new EmployeeModel();
            int empid = 0;
            if(request.getParameter("empid")!=null) {
                empid = Integer.parseInt(request.getParameter("empid"));
            }
            employee.setEmpId(empid);
            employee.setEmpName(request.getParameter("empname"));
            employee.setEmpDept(request.getParameter("empdept"));

            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date doj = format.parse(request.getParameter("empdoj"));
                employee.setEmpDOJ(doj);
            }catch(ParseException pe) {pe.printStackTrace();}


            employee.setEmpSalary(Integer.parseInt(request.getParameter("empsalary")));
            dao.createEmployee(employee);
            redirect = READ;
            request.setAttribute("employees", dao.getAllEmployees());
        }else if(action.equals("delete")) {
            int empID = Integer.parseInt(request.getParameter("empid"));
            dao.deleteEmployee(empID);
            redirect = READ;
            request.setAttribute("employees", dao.getAllEmployees());
        }else if(action.equals("editform")) {
            redirect = UPDATE;
        }else if(action.equals("update")) {
            int empID = Integer.parseInt(request.getParameter("empid"));
            EmployeeModel employee = new EmployeeModel();
            employee.setEmpId(Integer.parseInt(request.getParameter("empid")));
            employee.setEmpName(request.getParameter("empname"));
            employee.setEmpDept(request.getParameter("empdept"));
            try {
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date doj = format.parse(request.getParameter("empdoj"));
                employee.setEmpDOJ(doj);
            }catch(ParseException pe) {pe.printStackTrace();}
            employee.setEmpSalary(Integer.parseInt(request.getParameter("empsalary")));
            dao.updateEmployee(employee);
            redirect = READ;
            request.setAttribute("employee", employee);
        }else if(action.equals("listemployee")) {
            redirect = READ;
            request.setAttribute("employees", dao.getAllEmployees());
        }else {
            redirect = CREATE;
        }

        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
