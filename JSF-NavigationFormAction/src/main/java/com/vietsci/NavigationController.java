package com.vietsci;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NavigationController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String processPage1(){
		return "success";
		
	}
	
	public String processPage2(){
		return "success";
	}
}