package wms.service;

import org.springframework.stereotype.Service;

import wms.mapper.ProductMapper;
import wms.mapper.StockMapper;
import wms.model.Product;

@Service
public class ProductService {

	private final ProductMapper productMapper;
	private final StockMapper stockMapper;

	public ProductService(ProductMapper productMapper, StockMapper stockMapper) {
		this.productMapper = productMapper;
		this.stockMapper = stockMapper;
	}

	public void addProduct(String productCd, String productName, int price) {
		insertProduct(productCd, productName, price);

	}

	private void insertProduct(String productCd, String productName, int price) {
		Product productData = new Product();
		productData.setProductCd(productCd);
		productData.setProductName(productName);
		productData.setPrice(price);
		productData.setCrePrg(this.getClass().getName());
		productMapper.insertSelective(productData);
	}
}
