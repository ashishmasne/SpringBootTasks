package com.jbk.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.ProductDao;
import com.jbk.exceptions.ResourceNotExistsExceptions;
import com.jbk.model.Address;
import com.jbk.model.Category;
import com.jbk.model.Charges;
import com.jbk.model.FinalProduct;
import com.jbk.model.Product;
import com.jbk.model.Supplier;
import com.jbk.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Autowired
	private FinalProduct finalProduct;

	@Override
	public int addProduct(Product product) {

		String productId = new SimpleDateFormat("yyyyMMddmmss").format(new java.util.Date());
		product.setProductId(Long.parseLong(productId));

		return dao.addProduct(product);

	}

	@Override
	public Object deleteProduct(long productId) {
		return dao.deleteProduct(productId);
	}

	@Override
	public Product getProductById(long productId) {

		return dao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProduct() {

		return dao.getAllProduct();
	}

	@Override
	public Product updateProduct(Product product) {

		return dao.updateProduct(product);
	}

	@Override
	public Object getFinalProductById(long productId) {

		int status = 0;

		Product product = dao.getFinalProductById(productId);

		if (product == null) {

			return status;

		} else {

			String finalProductId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

			finalProduct.setProductId(Long.parseLong(finalProductId));
			finalProduct.setProductName(product.getProductName());
			finalProduct.setProductQty(product.getProductQty());
			finalProduct.setProductPrice(product.getProductPrice());

			finalProduct
					.setDiscountAmount((product.getProductPrice() * product.getProductCategory().getDiscount()) / 100);

			// Calculate gst, deliveryCharges, and FinalProductPrice
			double gst = (product.getProductPrice() * product.getProductCategory().getGst()) / 100;
			double deliveryCharges = product.getProductCategory().getDeliveryCharges();
			double finalProductPrice = product.getProductPrice() + gst + deliveryCharges
					- finalProduct.getDiscountAmount();

			finalProduct.setCharges(new Charges(gst, deliveryCharges));
			finalProduct.setFinalProductPrice(finalProductPrice);
			// Create and set the ProductSupplier object
			Supplier productSupplier = new Supplier();
			productSupplier.setSupplierId(product.getProductSupplier().getSupplierId());
			productSupplier.setSupplierName(product.getProductSupplier().getSupplierName());
			productSupplier.setSupplierMobileNumber(product.getProductSupplier().getSupplierMobileNumber());

			// Create and set the SupplierAddress object
			Address supplierAddress = new Address();
			supplierAddress.setAddressId(product.getProductSupplier().getSupplierAddress().getAddressId());
			supplierAddress.setCity(product.getProductSupplier().getSupplierAddress().getCity());
			supplierAddress.setDistrict(product.getProductSupplier().getSupplierAddress().getDistrict());
			supplierAddress.setState(product.getProductSupplier().getSupplierAddress().getState());
			supplierAddress.setPinCode(product.getProductSupplier().getSupplierAddress().getPinCode());

			productSupplier.setSupplierAddress(supplierAddress);
			finalProduct.setProductSupplier(productSupplier);

			// Create and set the ProductCategory object
			Category productCategory = new Category();
			productCategory.setCategoryId(product.getProductCategory().getCategoryId());
			productCategory.setCategoryName(product.getProductCategory().getCategoryName());
			productCategory.setDiscription(product.getProductCategory().getDiscription());
			productCategory.setDiscount(product.getProductCategory().getDiscount());
			productCategory.setGst(product.getProductCategory().getGst());
			productCategory.setDeliveryCharges(product.getProductCategory().getDeliveryCharges());

			finalProduct.setProductCategory(productCategory);

			return finalProduct;
		}

	}
}
