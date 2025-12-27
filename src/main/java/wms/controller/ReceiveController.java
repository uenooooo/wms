package wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import wms.service.ReceiveService;

@Controller
@RequestMapping("/receive")
public class ReceiveController {

	private final ReceiveService receiveService;

	public ReceiveController(ReceiveService receiveService) {
		this.receiveService = receiveService;
	}

	@PostMapping
	public String receive(
			@RequestParam("productId") Long productId,
			@RequestParam("quantity") int quantity) {

		receiveService.receive(productId, quantity);
		return "redirect:/stock";
	}
}
