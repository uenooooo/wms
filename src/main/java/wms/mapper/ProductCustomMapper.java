package wms.mapper;

import wms.model.Product;

public interface ProductCustomMapper {

    int insertSelectiveAndGetProductId(Product product);
}
