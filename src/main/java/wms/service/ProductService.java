package wms.service;

import org.springframework.stereotype.Service;

import wms.mapper.ProductCustomMapper;
import wms.mapper.ProductMapper;
import wms.model.Product;

@Service
public class ProductService {

	private final ProductMapper productMapper;
	private final ProductCustomMapper productCustomMapper;

	public ProductService(ProductMapper productMapper,
			ProductCustomMapper productCustomMapper) {
		this.productMapper = productMapper;
		this.productCustomMapper = productCustomMapper;
	}

	public Product findById(Long productId) {
		return productMapper.selectByPrimaryKey(productId);
	}

	public Product findByProductCd(String productCd) {
		return productCustomMapper.selectByProductCd(productCd);
	}
}
