package com.web.demo.ch10;

import com.alibaba.fastjson.JSONArray;
import com.web.demo.utils.JdbcMobile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//@WebServlet(name = "Servlet")
@WebServlet("/AdminOrderEdit")
public class AdminOrderEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONArray array = new JSONArray();
        Statement stmt = null;
        try{
            String id = request.getParameter("id");
            Connection con= JdbcMobile.getConnection();
            stmt = con.createStatement();
//            String sql = "UPDATE orderform SET state = "+"'"+state+"'"+" WHERE id= "+"'"+id+"'";
            String sql = "UPDATE orderform SET state = "+"'"+1+"'"+" WHERE id= "+"'"+id+"'";
            stmt.executeUpdate(sql);
            con.close();
        }
        catch(SQLException exp){
            exp.printStackTrace();
        }
    }
}
