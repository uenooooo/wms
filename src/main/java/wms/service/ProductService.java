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
		Long insProductId = insertProduct(productCd, productName, price);
		insertStock(insProductId);
	}

	private Long insertProduct(String productCd, String productName, int price) {
		Product productData = new Product();
		productData.setProductCd(productCd);
		productData.setProductName(productName);
		productData.setPrice(price);
		productData.setCrePrg(this.getClass().getName());
		productMapper.insertSelective(productData);
		Long insProductId;
		return insProductId;
	}

	private void insertStock(Long productId) {
		Stock stockData = new Stock();
		stockData.setProductId(productId);
		stockData.setQuantity(0);
		stockData.setCrePrg(this.getClass().getName());
		stockMapper.insertSelective(stockData);
	}
}
