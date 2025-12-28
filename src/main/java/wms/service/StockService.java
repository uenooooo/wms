package wms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wms.dto.StockListDto;
import wms.mapper.StockCustomMapper;
import wms.model.Stock;

@Service
@Transactional
public class StockService {

	private final StockCustomMapper StockCustomMapper;

	public StockService(StockCustomMapper stockMapper) {
		this.StockCustomMapper = stockMapper;
	}

	public List<StockListDto> findStockList() {
		List<StockListDto> list = StockCustomMapper.selectStockList();
		for (StockListDto dto : list) {
			if (dto.getStockQty() == null) {
				dto.setStockQty(0);
			}
		}
		return list;
	}
	
	public void insertStock(String productCd, String productName, int price) {
		Stock stockData = new Stock();
		stockData.setStockQty(0);
		stockData.setStockName(productName);
		stockData.setPrice(price);
		stockData.setCrePrg(this.getClass().getName());
		productMapper.insertSelective(stockData);
	}
}
