// package wms;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import wms.mapper.ProductMapper;
// import wms.model.Product;

// @Component
// public class DbTestRunner implements CommandLineRunner {

// 	private final ProductMapper productMapper;

// 	public DbTestRunner(ProductMapper productMapper) {
// 		this.productMapper = productMapper;
// 	}

// 	@Override
// 	public void run(String... args) throws Exception {
// 		List<Product> products = productMapper.selectByExample(null); // 全件取得
// 		System.out.println("=== Products ===");
// 		for (Product p : products) {
// 			System.out.println(p.getProductId() + ": " + p.getProductName());
// 		}
// 	}
// }
