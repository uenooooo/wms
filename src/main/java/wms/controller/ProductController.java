package wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wms.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/add")
	public String add(
			@RequestParam("productCd") String productCd,
			@RequestParam("productName") String productName,
			@RequestParam("price") int price) {
		productService.addProduct(productCd, productName, price);
		return "redirect:/stock";
	}
}