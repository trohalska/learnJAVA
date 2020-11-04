package world.ucode;

import world.ucode.db.Product;
import world.ucode.db.ProductDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/products")
public class DB2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ProductDB.insert(new Product("gum", 11));
        ProductDB.insert(new Product("apple", 2));
        ProductDB.insert(new Product("phone", 1099));
        ArrayList<Product> a = ProductDB.select();

        for (int i = 0; i < a.size(); ++i) {
            writer.println("product = " + a.get(i).getName() + ", price: " + a.get(i).getPrice() + "\n");
        }
        writer.close();
    }
}

