package com.androidmockito;

import android.os.Message;

public class MainController {
	
	public static final int MESSAGE_ONE = 1;
	
	public static final int MESSAGE_TWO = 2;
	
	private MainHandler handler;
	
	private MainActivity activity;
	
	public MainController(MainActivity activity, MainHandler handler){
		setActivity(activity);
		setHandler(handler);
	}
	
	public void inits(){
		Message msg = new Message();
		msg.what = MESSAGE_ONE;
	    getHandler().sendMessage(msg);
	}

	public void clickButton(String string) {
		Message msg = new Message();
		msg.what = MESSAGE_TWO;
		msg.obj = string;
	    getHandler().sendMessage(msg);
	}
	
	public MainHandler getHandler() {
		return handler;
	}

	public void setHandler(MainHandler handler) {
		this.handler = handler;
	}

	public MainActivity getActivity() {
		return activity;
	}

	public void setActivity(MainActivity activity) {
		this.activity = activity;
	}

}
