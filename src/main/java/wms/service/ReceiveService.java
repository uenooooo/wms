package wms.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.mapper.ReceiveMapper;
import wms.mapper.StockCustomMapper;
import wms.model.Receive;
import wms.model.Stock;

@Service
public class ReceiveService {

	private final ReceiveMapper receiveMapper;
	private final StockCustomMapper stockCustomMapper;

	public ReceiveService(ReceiveMapper receiveMapper, StockCustomMapper stockCustomMapper) {
		this.receiveMapper = receiveMapper;
		this.stockCustomMapper = stockCustomMapper;
	}

	@Transactional
	public void receive(Long productId, int quantity) {
		receiveStock(productId, quantity);
		insertReceive(productId, quantity);
	}

	private void receiveStock(Long productId, int quantity) {
		Stock stockData = new Stock();
		stockData.setProductId(productId);
		stockData.setStockQty(quantity);
		stockData.setUpdPrg(ReceiveService.class.getName());
		stockData.setUpdTime(new Date());
		stockCustomMapper.increaseStockQty(stockData);
	}

	private void insertReceive(Long productId, int quantity) {
		Receive receiveData = new Receive();
		receiveData.setProductId(productId);
		receiveData.setQuantity(quantity);
		receiveData.setCrePrg(ReceiveService.class.getName());
		receiveMapper.insertSelective(receiveData);
	}
}
