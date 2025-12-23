//package wms;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import wms.model.Receive;
//import wms.service.ReceiveService;
//
//@Component
//public class ReceiveTestRunner implements CommandLineRunner {
//
//	private final ReceiveService receiveService;
//
//	public ReceiveTestRunner(ReceiveService receiveService) {
//		this.receiveService = receiveService;
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Receive receive = new Receive();
//		receive.setProductId(1L); // テスト用の商品ID
//		receive.setQuantity(10); // 入荷数
//
//		receiveService.receive(receive);
//
//		System.out.println("=== Insert Done ===");
//		System.out.println("ProductId: " + receive.getProductId() + ", Quantity: " + receive.getQuantity());
//	}
//}
