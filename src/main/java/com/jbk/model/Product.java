package com.jbk.model;

import java.sql.Date;

import javax.validation.Valid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private long productId;

	@NotBlank(message = "productName cannot be empty.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "productName should contains only alphabetic characters.")
	private String productName;

	private double productPrice;
	private int productQty;

	@NotBlank(message = "productDiscription cannot be empty.")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "productDiscription should contains only alphabetic characters.")
	private String productDiscription;
	private Date mfgDate;
	private Date expDate;

	@Valid
	private Supplier productSupplier;

	@Valid
	private Category productCategory;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String productName, double productPrice, int productQty, String productDiscription,
			Date mfgDate, Date expDate, Supplier productSupplier, Category productCategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.productDiscription = productDiscription;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
		this.productSupplier = productSupplier;
		this.productCategory = productCategory;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public String getProductDiscription() {
		return productDiscription;
	}

	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Supplier getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(Supplier productSupplier) {
		this.productSupplier = productSupplier;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQty=" + productQty + ", productDiscription=" + productDiscription + ", mfgDate=" + mfgDate
				+ ", expDate=" + expDate + ", productSupplier=" + productSupplier + ", productCategory="
				+ productCategory + "]";
	}

}
