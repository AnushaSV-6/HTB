package com.healthyandtastybites;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.time.LocalTime;

public class Welcome extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
        String fullName = request.getParameter("fullname");
        String phoneNumber = request.getParameter("phnno");
        String email = request.getParameter("email");

   
        LocalTime currentTime = LocalTime.now();
        String greetingMessage = getGreetingMessage(currentTime);

        

        PrintWriter out = response.getWriter();
     
        out.println("<h1>" + greetingMessage + "!</h1>");
        out.println("<h2>Welcome to Healthy Tasty Bites!, Here are your info</h2>");
        out.println("<p><strong>Full Name:</strong> " + fullName + "</p>");
        out.println("<p><strong>Phone Number:</strong> " + phoneNumber + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("Thank you ");
    }

    
    public String getGreetingMessage(LocalTime time) {
        
        int hour = time.getHour();

        if (hour >= 6 && hour < 12) {
            return "Good Morning";
        } else if (hour >= 12 && hour < 18) {
            return "Good Afternoon";
        } else {
            return "Good Evening";
        }
    }
}
