package com.zabara.introweb.views;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 *
 * front-controller-view
 */
public class View {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Logger logger = Logger.getLogger(View.class.getName());

	public View(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}

	public void navigate() throws ServletException, IOException {
		String path = "/WEB-INF/pages" + request.getServletPath() + ".jsp";
		request.getRequestDispatcher(path).forward(request, response);
		logger.info("view navigate to [" + path + "]");
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
}
