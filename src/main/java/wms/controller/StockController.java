package wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wms.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public String list(Model model) {

        // 商品＋在庫の一覧を取得
        model.addAttribute("stockList", stockService.findStockList());

        // templates/stock.html を表示
        return "stock";
    }
}