package wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import wms.exception.BusinessException;
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
			@RequestParam("price") int price,
			RedirectAttributes redirectAttributes) {

		try {
			productService.addProduct(productCd, productName, price);
			return "redirect:/stock";
		} catch (BusinessException e) {
			redirectAttributes.addFlashAttribute("addErrorMessage", e.getMessage());
			return "redirect:/stock";
		}
	}

	@PostMapping("/edit")
	public String edit(
			@RequestParam("productId") Long productId,
			@RequestParam("productCd") String productCd,
			@RequestParam("productName") String productName,
			@RequestParam("price") int price,
			RedirectAttributes redirectAttributes) {

		try {
			productService.editProduct(productId, productCd, productName, price);
			return "redirect:/stock";
		} catch (BusinessException e) {
			redirectAttributes.addFlashAttribute("editErrorMessage", e.getMessage());
			return "redirect:/stock";
		}
	}
}