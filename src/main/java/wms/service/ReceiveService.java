package wms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.mapper.ReceiveMapper;
import wms.model.Product;
import wms.model.Receive;

@Service
public class ReceiveService {

	private final ReceiveMapper receiveMapper;
	private final ProductService productService;

	public ReceiveService(ReceiveMapper receiveMapper, ProductService productService) {
		this.receiveMapper = receiveMapper;
		this.productService = productService;
	}

	@Transactional
	public void receive(String productCd, int quantity) {
		Long productId = getProductId(productCd);
		insertReceive(productId, quantity);
	}

	private long getProductId(String productCd) {
		Product product = productService.findByProductCd(productCd);

		if (product == null) {
			throw new IllegalArgumentException("商品マスタに存在しません。productCd： " + productCd);
		}
		return product.getProductId();
	}

	private void insertReceive(Long productId, int quantity) {
		Receive receiveData = new Receive();
		receiveData.setProductId(productId);
		receiveData.setQuantity(quantity);
		receiveData.setCrePrg(ReceiveService.class.getName());
		receiveMapper.insertSelective(receiveData);
	}
}
