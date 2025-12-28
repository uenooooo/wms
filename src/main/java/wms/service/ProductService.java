package wms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.mapper.ProductCustomMapper;
import wms.model.Product;

@Service
public class ProductService {

	private final ProductCustomMapper productCustomMapper;
	private final StockService stockService;

	public ProductService(ProductCustomMapper productCustomMapper, StockService stockService) {
		this.productCustomMapper = productCustomMapper;
		this.stockService = stockService;
	}
@Transactional
	public void addProduct(String productCd, String productName, int price) {
		Long insProductId = insertProduct(productCd, productName, price);
		stockService.insertStock(insProductId);
	}

	private Long insertProduct(String productCd, String productName, int price) {
		Product productData = new Product();
		productData.setProductCd(productCd);
		productData.setProductName(productName);
		productData.setPrice(price);
		productData.setCrePrg(this.getClass().getName());
		productCustomMapper.insertSelectiveAndGetProductId(productData);
		Long insProductId = productData.getProductId();
		return insProductId;
	}
}
