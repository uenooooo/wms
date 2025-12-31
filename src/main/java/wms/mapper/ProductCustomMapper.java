package wms.mapper;

import org.apache.ibatis.annotations.Param;

import wms.model.Product;

public interface ProductCustomMapper {

	int insertSelectiveAndGetProductId(Product product);

	boolean existsProductCdExcludingId(
			@Param("productCd") String productCd,
			@Param("productId") Long productId);
}
