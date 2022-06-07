package com.siva.studentApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siva.studentApp.dao.DBUtil;


@WebServlet("/ProcessLoginServlet")
public class ProcessLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean validation = validate(username, password);
		
		RequestDispatcher rd = null;
		
		if(validation) {
			rd = request.getRequestDispatcher("/StudenControllerServlet");
			rd.forward(request, response);
		}
		
		request.getRequestDispatcher("/login.jsp").include(request, response);
	}

	private boolean validate(String username, String password) {
		try (
				Connection con = DBUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM admins WHERE username= ? AND password = ? ")
						) {
			pstmt.setString(2, password);
			 ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}