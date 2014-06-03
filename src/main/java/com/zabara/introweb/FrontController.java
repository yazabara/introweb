package com.zabara.introweb;

import com.zabara.introweb.actions.Action;
import com.zabara.introweb.actions.ActionException;
import com.zabara.introweb.actions.ActionFactory;
import com.zabara.introweb.views.View;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class FrontController extends HttpServlet {

	private static final Logger logger = Logger.getLogger(FrontController.class.getName());

	@Override
	public void init() throws ServletException {
		super.init();
		logger.info(FrontController.class.getName() + "was initialized");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		View view = new View(request, response);
		try {
			Action action = getAction(request);
			action.execute(view);
		} catch (ActionException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
		view.navigate();
	}

	protected Action getAction(HttpServletRequest request) throws ActionException {
		return ActionFactory.getAction(request.getPathInfo());
	}
}
