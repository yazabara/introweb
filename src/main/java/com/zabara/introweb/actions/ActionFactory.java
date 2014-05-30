package com.zabara.introweb.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class ActionFactory {

	private static ActionFactory instance = null;
	private Logger logger = Logger.getLogger(ActionFactory.class.getName());
	private static Map<String,Action> actions;

	static {
		instance = new ActionFactory();
	}

	private ActionFactory() {
		fillActions();
		logger.info(ActionFactory.class.getName() + "was initialized");
	}

	private void fillActions() {
		actions = new HashMap<String, Action>();
		actions.put("home", new HomeAction());
	}

	public static ActionFactory getInstance() {
		if (instance == null) {
			instance = new ActionFactory();
		}
		return instance;
	}

	public static Action getAction(String name) throws ActionException {
		if (!actions.containsKey(name)){
			throw new ActionException("action not found");
		}
		return actions.get(name);
	}
}
