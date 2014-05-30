package com.zabara.introweb.actions;

import com.zabara.introweb.views.View;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class HomeAction implements Action {

	@Override
	public void execute(View view) {
		view.getRequest().setAttribute("name","Yaroslav");
	}
}
