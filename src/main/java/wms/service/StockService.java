package wms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.dto.StockListDto;
import wms.mapper.StockCustomMapper;
import wms.mapper.StockMapper;
import wms.model.Stock;

@Service
@Transactional
public class StockService {

	private final StockCustomMapper stockCustomMapper;
	private final StockMapper stockMapper;

	public StockService(StockCustomMapper stockCustomMapper, StockMapper stockMapper) {
		this.stockCustomMapper = stockCustomMapper;
		this.stockMapper = stockMapper;
	}

	public List<StockListDto> findStockList() {
		List<StockListDto> list = stockCustomMapper.selectStockList();
		for (StockListDto dto : list) {
			if (dto.getStockQty() == null) {
				dto.setStockQty(0);
			}
		}
		return list;
	}

	public void insertStock(Long productId) {
		Stock stockData = new Stock();
		stockData.setProductId(productId);
		stockData.setStockQty(0);
		stockData.setCrePrg(this.getClass().getName());
		stockMapper.insertSelective(stockData);
	}
}
