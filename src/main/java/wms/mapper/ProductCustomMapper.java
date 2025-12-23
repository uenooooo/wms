package wms.mapper;

import org.apache.ibatis.annotations.Param;

import wms.model.Product;

public interface ProductCustomMapper {
	Product selectByProductCd(@Param("productCd") String productCd);
}