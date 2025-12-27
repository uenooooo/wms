package wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wms.service.ShipService;

@Controller
@RequestMapping("/ship")
public class ShipController {

	private final ShipService shipService;

	public ShipController(ShipService shipService) {
		this.shipService = shipService;
	}

	@PostMapping
	public String ship(
			@RequestParam("productId") Long productId,
			@RequestParam("quantity") int quantity) {

		shipService.ship(productId, quantity);
		return "redirect:/stock";
	}
}
