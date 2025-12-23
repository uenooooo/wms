//package service;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import wms.model.Receive;
//import wms.service.ReceiveService;
//
//@SpringBootTest
//@Transactional // テスト後に DB をロールバック
//public class ReceiveServiceTest {
//
//    @Autowired
//    private ReceiveService receiveService;
//
//    @Test
//    public void testReceive() {
//        Receive receive = new Receive();
//        receive.setProductId(1L); // 存在する product_id
//        receive.setQuantity(5);
//
//        receiveService.receive(receive);
//
//        // Optional: insert 後に mapper 経由で確認する場合
//        // Receive inserted = receiveMapper.findById(receive.getReceiveId());
//        // assertNotNull(inserted);
//    }
//}
