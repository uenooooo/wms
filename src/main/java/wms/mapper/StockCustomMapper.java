package wms.mapper;

import java.util.List;

import wms.dto.StockListDto;
import wms.model.Stock;

public interface StockCustomMapper {
	List<StockListDto> selectStockList();
	int increaseStockQty(Stock row);
}
