package com.aryan;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class UsersAlsoClickedServlet
 */
@WebServlet("/also-clicked")
public class UsersAlsoClickedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("userId") == null) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        int userId = (int) session.getAttribute("userId");
	        int productId = -1;

	        List<Product> list = new ArrayList<>();

	        try (Connection con = DBConnection.getConnection()) {

	            // 🔹 1. Get last clicked product by this user
	            String lastClickSql =
	                    "SELECT product_id FROM user_clicks " +
	                    "WHERE user_id = ? " +
	                    "ORDER BY last_clicked DESC LIMIT 1";

	            PreparedStatement ps1 = con.prepareStatement(lastClickSql);
	            ps1.setInt(1, userId);

	            ResultSet rs1 = ps1.executeQuery();
	            if (rs1.next()) {
	                productId = rs1.getInt("product_id");
	            }

	            // If user never liked anything
	            if (productId == -1) {
	                request.setAttribute("products", list);
	                request.getRequestDispatcher("also-clicked.jsp")
	                       .forward(request, response);
	                return;
	            }

	            // 🔹 2. Users Also Clicked logic
	            String sql =
	                "SELECT p.product_id, p.product_name, p.brand, " +
	                "       pl.price, pl.product_link " +
	                "FROM user_clicks uc1 " +
	                "JOIN user_clicks uc2 ON uc1.user_id = uc2.user_id " +
	                "JOIN products p ON uc2.product_id = p.product_id " +
	                "JOIN product_listings pl ON p.product_id = pl.product_id " +
	                "JOIN ( " +
	                "   SELECT product_id, MIN(price) AS min_price " +
	                "   FROM product_listings GROUP BY product_id " +
	                ") mp ON pl.product_id = mp.product_id " +
	                "   AND pl.price = mp.min_price " +
	                "WHERE uc1.product_id = ? " +
	                "AND uc2.product_id <> ? " +
	                "ORDER BY uc2.click_count DESC " +
	                "LIMIT 10";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, productId);
	            ps.setInt(2, productId);

	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Product p = new Product();
	                p.setProductId(rs.getInt("product_id"));
	                p.setProductName(rs.getString("product_name"));
	                p.setBrand(rs.getString("brand"));
	                p.setPrice(rs.getDouble("price"));
	                p.setLink(rs.getString("product_link"));
	                list.add(p);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        request.setAttribute("products", list);
	        request.getRequestDispatcher("also-clicked.jsp")
	               .forward(request, response);
	    }
	}
