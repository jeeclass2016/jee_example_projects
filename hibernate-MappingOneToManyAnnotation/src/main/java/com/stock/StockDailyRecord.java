package com.stock;

// Generated Apr 1, 2016 6:18:04 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * StockDailyRecord generated by hbm2java
 */
@Entity
@Table(name = "STOCK_DAILY_RECORD", uniqueConstraints = @UniqueConstraint(columnNames = "CHANGE_DATE"))
public class StockDailyRecord implements java.io.Serializable {

	private long recordId;
	private Stock stock;
	private BigDecimal priceOpen;
	private BigDecimal priceClose;
	private BigDecimal priceChange;
	private Date changeDate;

	public StockDailyRecord() {
	}

	public StockDailyRecord(long recordId, Stock stock, Date changeDate) {
		this.recordId = recordId;
		this.stock = stock;
		this.changeDate = changeDate;
	}

	public StockDailyRecord(long recordId, Stock stock, BigDecimal priceOpen,
			BigDecimal priceClose, BigDecimal priceChange, Date changeDate) {
		this.recordId = recordId;
		this.stock = stock;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.changeDate = changeDate;
	}
	
	public StockDailyRecord(Stock stock, BigDecimal priceOpen,
			BigDecimal priceClose, BigDecimal priceChange, Date changeDate) {
		this.stock = stock;
		this.priceOpen = priceOpen;
		this.priceClose = priceClose;
		this.priceChange = priceChange;
		this.changeDate = changeDate;
	}

	@Id
	@Column(name = "RECORD_ID", unique = true, nullable = false, precision = 10, scale = 0)
	@GeneratedValue(generator="stock_daily_record_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name = "stock_daily_record_seq", sequenceName = "STOCK_DAILY_RECORD_SEQ")
	public long getRecordId() {
		return this.recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STOCK_ID", nullable = false)
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Column(name = "PRICE_OPEN", precision = 6)
	public BigDecimal getPriceOpen() {
		return this.priceOpen;
	}

	public void setPriceOpen(BigDecimal priceOpen) {
		this.priceOpen = priceOpen;
	}

	@Column(name = "PRICE_CLOSE", precision = 6)
	public BigDecimal getPriceClose() {
		return this.priceClose;
	}

	public void setPriceClose(BigDecimal priceClose) {
		this.priceClose = priceClose;
	}

	@Column(name = "PRICE_CHANGE", precision = 6)
	public BigDecimal getPriceChange() {
		return this.priceChange;
	}

	public void setPriceChange(BigDecimal priceChange) {
		this.priceChange = priceChange;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHANGE_DATE", unique = true, nullable = false, length = 7)
	public Date getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

}
