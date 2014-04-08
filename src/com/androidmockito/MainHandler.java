package com.androidmockito;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MainHandler extends Handler{

	private MainActivity activity;
	private MainController controller;
	
	public MainHandler(MainActivity activity){
		setActivity(activity);
		setMainController(activity.getMainController());
	}
	
	@Override
	public void handleMessage(Message msg) {
		// TODO Auto-generated method stub
		super.handleMessage(msg);
		
		switch (msg.what) {
		case MainController.MESSAGE_ONE:
			Log.d("rheno", "init");
			break;
		case MainController.MESSAGE_TWO:
			getActivity().getTextView1().setText((String)msg.obj);
			break;	

		default:
			break;
		}
	}

	public MainActivity getActivity() {
		return activity;
	}

	public void setActivity(MainActivity activity) {
		this.activity = activity;
	}

	public MainController getMainController() {
		return controller;
	}

	public void setMainController(MainController mainController) {
		this.controller = mainController;
	}
}
