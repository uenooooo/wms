package wms.service;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.dto.StockQtyDto;
import wms.mapper.ShipMapper;
import wms.mapper.StockCustomMapper;
import wms.model.Ship;
import wms.model.Stock;

@Service
public class ShipService {

	private final ShipMapper shipMapper;
	private final StockCustomMapper stockCustomMapper;

	public ShipService(ShipMapper shipMapper, StockCustomMapper stockCustomMapper) {
		this.shipMapper = shipMapper;
		this.stockCustomMapper = stockCustomMapper;
	}

	@Transactional
	public void ship(Long productId, int quantity) {
		checkStock(productId, quantity);
		shipStock(productId, quantity);
		insertShip(productId, quantity);
	}

	private void checkStock(Long productId, int quantity) {
		StockQtyDto stockQtyDto = stockCustomMapper.selectStockQty(productId);
		if (quantity > stockQtyDto.getStockQty()) {
			throw new IllegalArgumentException("在庫が足りません。商品ID: " + productId);
		}
	}

	private void shipStock(Long productId, int quantity) {
		Stock stockData = new Stock();
		stockData.setProductId(productId);
		stockData.setStockQty(quantity);
		stockData.setUpdPrg(ShipService.class.getName());
		stockData.setUpdTime(new Date());
		stockCustomMapper.decreaseStockQty(stockData);
	}

	private void insertShip(Long productId, int quantity) {
		Ship shipData = new Ship();
		shipData.setProductId(productId);
		shipData.setQuantity(quantity);
		shipData.setCrePrg(this.getClass().getName());
		shipMapper.insertSelective(shipData);
	}
}
