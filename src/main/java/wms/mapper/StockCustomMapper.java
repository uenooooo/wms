package wms.mapper;

import java.util.List;

import wms.dto.StockListDto;
import wms.dto.StockQtyDto;
import wms.model.Stock;

public interface StockCustomMapper {
	List<StockListDto> selectStockList();

	StockQtyDto selectStockQty(Long productId);

	int increaseStockQty(Stock row);

	int decreaseStockQty(Stock row);
}
