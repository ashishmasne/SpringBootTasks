package com.jbk.model;

import org.springframework.stereotype.Component;

@Component
public class FinalProduct {

	private long productId;
	private String productName;
	private Supplier productSupplier;
	private Category productCategory;
	private int productQty;
	private double productPrice;
	private Charges charges;
	private double discountAmount;
	private double finalProductPrice;

	public FinalProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinalProduct(long productId, String productName, Supplier productSupplier, Category productCategory,
			int productQty, double productPrice, Charges charges, double discountAmount, double finalProductPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSupplier = productSupplier;
		this.productCategory = productCategory;
		this.productQty = productQty;
		this.productPrice = productPrice;
		this.charges = charges;
		this.discountAmount = discountAmount;
		this.finalProductPrice = finalProductPrice;
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

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public Charges getCharges() {
		return charges;
	}

	public void setCharges(Charges charges) {
		this.charges = charges;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getFinalProductPrice() {
		return finalProductPrice;
	}

	public void setFinalProductPrice(double finalProductPrice) {
		this.finalProductPrice = finalProductPrice;
	}

	@Override
	public String toString() {
		return "FinalProduct [productId=" + productId + ", productName=" + productName + ", productSupplier="
				+ productSupplier + ", productCategory=" + productCategory + ", productQty=" + productQty
				+ ", productPrice=" + productPrice + ", charges=" + charges + ", discountAmount=" + discountAmount
				+ ", finalProductPrice=" + finalProductPrice + "]";
	}

}
