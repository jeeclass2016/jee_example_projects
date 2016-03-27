package com.vietsci.listener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class MyActionListener implements ActionListener{

	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		System.out.println("Call to MyActionListener");
	}
	
}
