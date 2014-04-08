package com.androidmockito;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private MainController mainController;
	
	private MainHandler mainHandler;
	
	private Button button1;
	
	private TextView textView1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mainHandler = new MainHandler(this);
        mainController = new MainController(this, mainHandler);
        
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        
        textView1 = (TextView) findViewById(R.id.textView1);
        
        getMainController().inits();
        
    }

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public MainHandler getMainHandler() {
		return mainHandler;
	}

	public void setMainHandler(MainHandler mainHandler) {
		this.mainHandler = mainHandler;
	}

	public Button getButton1() {
		return button1;
	}

	public void setButton1(Button button1) {
		this.button1 = button1;
	}

	public TextView getTextView1() {
		return textView1;
	}

	public void setTextView1(TextView textView1) {
		this.textView1 = textView1;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			getMainController().clickButton("Haii");
			break;

		default:
			break;
		}
	}   
    
}
