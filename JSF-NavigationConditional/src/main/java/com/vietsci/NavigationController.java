package com.vietsci;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class NavigationController implements Serializable {
	private static final long serialVersionUID = 1L;
	private final String PAGE1_URI = "/pages/page1";
	private final String PAGE2_URI = "/pages/page2";
	private final String HOME_PAGE_URI = "/pages/home";
	
	// This managed property will read value from request parameter pageId
	@ManagedProperty(value="#{param.pageId}")
	private String pageId;
	
	private boolean registerCompleted = true;
	public int orderQty = 100;
	
	//Conditional navigation based on pageId
	//if pageId is 1 show page1.xhtml,
	//if pageId is 2 show page2.xhtml
	//else show home.xhtml
	public String showPage(){
		if ("1".equals(pageId)) {
			return PAGE1_URI;
		} else if ("2".equals(pageId)) {
			return PAGE2_URI;
		} else {
			return HOME_PAGE_URI;
		}
	}

	//========= Setter and Getter =============//
	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public boolean isRegisterCompleted() {
		return registerCompleted;
	}

	public void setRegisterCompleted(boolean registerCompleted) {
		this.registerCompleted = registerCompleted;
	}

	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
}