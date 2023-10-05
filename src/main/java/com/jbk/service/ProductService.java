package com.jbk.service;

import java.util.List;

import com.jbk.model.FinalProduct;
import com.jbk.model.Product;

public interface ProductService {

	public int addProduct(Product product);

	public Object deleteProduct(long productId);

	public Product getProductById(long productId);

	public List<Product> getAllProduct();

	public Product updateProduct(Product product);

	public Object getFinalProductById(long productId);
}
