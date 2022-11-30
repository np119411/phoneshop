package com.phoneshop.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

public class FileUploadServlet extends HttpServlet {
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Collection<Part> fileParts= request.getParts();
        for (Part part : fileParts) {
            String fileName = part.getSubmittedFileName();
            Map result = UploadImage.uploadAvatarImage(fileName, part);
            String url = String.valueOf(result.get("url"));
            System.out.println(url);
        }
        PrintWriter out = response.getWriter();
        out.println("Upload success");

  }
} 
