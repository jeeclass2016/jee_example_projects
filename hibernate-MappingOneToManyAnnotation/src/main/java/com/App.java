package com;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.stock.Stock;
import com.stock.StockDailyRecord;
import com.util.HibernateUtil;

public class App {

	Session session;
	Transaction tx = null;

	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML mapping)");

		App app = new App();
//		app.addStock();
		app.listStocks();

		System.out.println("Done");
	}

	/**
	 * CREATE Stock
	 */
	public void addStock() {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			tx = session.beginTransaction();
			
			Stock stock = new Stock();
			stock.setStockCode("A001");
			stock.setStockName("STOCK 1");
			session.save(stock);

			Date change_date1 = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(change_date1);
			calendar.add(Calendar.DATE, 1);
			Date change_date2 = calendar.getTime();
			
			StockDailyRecord stockDailyRecord1 = new StockDailyRecord(stock, new BigDecimal("10"),
					new BigDecimal("9"), new BigDecimal("1"), change_date1);
			StockDailyRecord stockDailyRecord2 = new StockDailyRecord(stock, new BigDecimal("20"),
					new BigDecimal("15"), new BigDecimal("5"), change_date2);
			
			stock.getStockDailyRecords().add(stockDailyRecord1);
			stock.getStockDailyRecords().add(stockDailyRecord2);
			
			session.save(stockDailyRecord1);
			session.save(stockDailyRecord2);

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
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
			List<Stock> stocks = (List<Stock>) session.createQuery(
					"FROM com.stock.Stock").list();
			System.out.println("After gt list: " + stocks.size());
			Set<StockDailyRecord> stockDailyRecords;
			for (Stock stck : stocks) {
				if (stck == null) {
					continue;
				}
				System.out.print("STOCK ID: " + stck.getStockId());
				System.out.print(" STOCK CODE: " + stck.getStockCode());
				System.out.println(" STOCK NAME: " + stck.getStockName());
				System.out.println("=======================================");
				
				stockDailyRecords = stck.getStockDailyRecords();
				for(StockDailyRecord dailyRecord : stockDailyRecords) {
					if (dailyRecord == null) {
						continue;
					}
					System.out.print("RECORD_ID: " + dailyRecord.getRecordId());
					System.out.print(" PRICE_OPEN: " + dailyRecord.getPriceOpen());
					System.out.print(" PRICE_CLOSE: " + dailyRecord.getPriceClose());
					System.out.print(" PRICE_CHANGE: " + dailyRecord.getPriceChange());
					System.out.print(" CHANGE_DATE: " + dailyRecord.getChangeDate());
					System.out.print(" STOCK_ID: " + dailyRecord.getStock().getStockId() + "\n");
				}
				System.out.println("*************************************************");
			}

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
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
