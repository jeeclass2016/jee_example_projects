package com;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stock.Stock;
import com.stock.StockDetail;
import com.util.HibernateUtil;

public class App {
	
	Session session;
	Transaction tx = null;
	
	public static void main(String[] args) {
		System.out.println("Hibernate one to one (XML mapping)");
		
		App app = new App();

		Stock stock = new Stock();
		stock.setStockCode("S004");
		stock.setStockName("STOCK 4");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("VIETSCI");
		stockDetail.setCompDesc("Best tech company");
		stockDetail.setRemark("The fourth stock");
		stockDetail.setListedDate(new Date());
		
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		
//		app.addStock(stock, stockDetail);
		app.listStocks();
		
		System.out.println("Done");
	}
	
	
	/**
	 * CREATE Stock
	 */
	public void addStock(Stock stock, StockDetail stockDetail) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();

			session.save(stock);
			tx.commit();
			
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * READ all stocks information in database
	 */
	public void listStocks() {
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			tx = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Stock> stocks = (List<Stock>)session.createQuery("FROM com.stock.Stock").list();
			StockDetail stockDetail = null;
			System.out.println("After gt list: " + stocks.size());
			for (Stock stck : stocks) {
				System.out.print("STOCK ID: " + stck.getStockId());
				System.out.print("STOCK CODE: " + stck.getStockCode());
				System.out.println("STOCK NAME: " + stck.getStockName());
				System.out.println("========== Stock detail =========");
				stockDetail = stck.getStockDetail();
				System.out.print("COMP NAME: " + stockDetail.getCompName());
				System.out.print("COMP DESC: " + stockDetail.getCompDesc());
				System.out.print("REMARK: " + stockDetail.getRemark());
			}
			
			tx.commit();
			
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * UPDATE a stock information in database
	 */
	public void updateStock() {
		
	}
	
	/**
	 * DELETE a stock information in database
	 */
	public void deleteStock() {
		
	}
	
	
}
