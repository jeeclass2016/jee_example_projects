package com.vietsci;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 
import javax.faces.event.ActionEvent;

import java.io.Serializable;
 
@ManagedBean
@SessionScoped
public class ListenerBean implements Serializable {
 
	private static final long serialVersionUID = 1L;
 
	public String buttonId; 

	public void printIt(ActionEvent event){
		//Get submit button id
		buttonId = event.getComponent().getClientId();
		System.out.println("CLient ID is: " + buttonId);
	}
	
	public String outcome(){
		return "result";
	}
	
}