package com.androidmockito.test;

import static org.mockito.Mockito.*;
import org.mockito.ArgumentCaptor;
import com.androidmockito.MainController;
import com.androidmockito.MainHandler;

import android.os.Message;
import android.test.AndroidTestCase;

public class MainControllerTest extends AndroidTestCase {

	// Object for Mock
	private MainController mainController;

	@Override
	protected void setUp() throws Exception {

		super.setUp();

		// Instance MainController Object Mock
		mainController = mock(MainController.class);
	}

	public void initsTest() {

		// Instance MainHandler Object Mock
		MainHandler handler = mock(MainHandler.class);

		// Assign mainController.getHandler() to MainHandler Object Mock
		when(mainController.getHandler()).thenReturn(handler);

		// Call Real Methods
		doCallRealMethod().when(mainController).inits();
		mainController.inits();

		// Initilize ArgumentCaptor from message
		ArgumentCaptor<Message> msg = ArgumentCaptor.forClass(Message.class);

		// Capture Argument from message
		verify(mainController.getHandler()).sendMessageAtTime(msg.capture(),
				anyLong());

		// Check what message value
		assertEquals(MainController.MESSAGE_ONE, msg.getValue().what);

	}

	public void clickButtonTest() {
		// Instance MainHandler Object Mock
		MainHandler handler = mock(MainHandler.class);

		// Assign mainController.getHandler() to MainHandler Object Mock
		when(mainController.getHandler()).thenReturn(handler);

		// Call Real Methods
		doCallRealMethod().when(mainController).clickButton("Haii");
		mainController.clickButton("Haii");

		// Initilize ArgumentCaptor from message
		ArgumentCaptor<Message> msg = ArgumentCaptor.forClass(Message.class);

		// Capture Argument from message
		verify(mainController.getHandler()).sendMessageAtTime(msg.capture(),
				anyLong());

		// Check what message value
		assertEquals(MainController.MESSAGE_TWO, msg.getValue().what);
		
		// Check object message value
		assertEquals("Haii", (String) msg.getValue().obj);
		
	}

}
