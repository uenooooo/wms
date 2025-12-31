package wms.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.exception.BusinessException;
import wms.mapper.ProductCustomMapper;
import wms.mapper.ProductMapper;
import wms.model.Product;

@Service
public class ProductService {

	private final ProductMapper productMapper;
	private final ProductCustomMapper productCustomMapper;
	private final StockService stockService;

	public ProductService(ProductMapper productMapper, ProductCustomMapper productCustomMapper,
			StockService stockService) {
		this.productMapper = productMapper;
		this.productCustomMapper = productCustomMapper;
		this.stockService = stockService;
	}

	@Transactional
	public void addProduct(String productCd, String productName, int price) {
		checkDuplicateProductCd(productCd, null);
		Long insProductId = insertProduct(productCd, productName, price);
		stockService.insertStock(insProductId);
	}

	@Transactional
	public void editProduct(Long productId, String productCd, String productName, int price) {
		checkDuplicateProductCd(productCd, productId);
		updateProduct(productId, productCd, productName, price);
	}

	private void checkDuplicateProductCd(String productCd, Long productId) {
		if (productCustomMapper.existsProductCdExcludingId(productCd, productId)) {
			throw new BusinessException("商品CDが重複しています");
		}
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

	private void updateProduct(Long productId, String productCd, String productName, int price) {
		Product productData = new Product();
		productData.setProductId(productId);
		productData.setProductCd(productCd);
		productData.setProductName(productName);
		productData.setPrice(price);
		productData.setUpdPrg(this.getClass().getName());
		productData.setUpdTime(new Date());
		productMapper.updateByPrimaryKeySelective(productData);
	}
}
