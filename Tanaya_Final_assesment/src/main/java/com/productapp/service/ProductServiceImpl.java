package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.Product;
import com.productapp.dao.ProductDao;
import com.productapp.exceptions.ProductNotFoundException;
@Service
@Transactional //ACID
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAll() {
		if(1==1)
			throw new RuntimeException();
	
		return productDao.findAll();
	}

	@Override
	public Product getById(int id) {
		Product product=productDao.findById(id).
				orElseThrow(()-> new ProductNotFoundException("product with id "+ id +" is not found"));
		return product;
	}

	@Override
	public Product update(int id, Product product) {
		Product productToUpdate= getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

	@Override
	public Product add(Product product) {
		 productDao.save(product);
		 return product;
	}

	@Override
	public Product delete(int id) {
		
		Product productToDelete= getById(id);
		productDao.delete(productToDelete);
		
		return productToDelete;
	}

}
