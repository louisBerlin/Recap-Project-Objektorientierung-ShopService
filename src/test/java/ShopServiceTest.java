import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {

    @Test
    void addOrderTest() {
        //GIVEN
        ShopService shopService = new ShopService();
        List<String> productsIds = List.of("1");

        //WHEN
        Order actual = shopService.addOrder(productsIds);

        //THEN
        Order expected = new Order("-1", List.of(new Product("1", "Apfel")),"","","");
        assertEquals(expected.products(), actual.products());
        assertNotNull(expected.id());
    }

    @Test
    void addOrderTest_whenInvalidProductId_expectExeption() {

        try {
            //GIVEN
            ShopService shopService = new ShopService();
            List<String> productsIds = List.of("1", "2");

            //WHEN
            Order actual = shopService.addOrder(productsIds);
            fail("Es wurde eine Exception erwartet, aber keine geworfen!");
        } catch (Exception e) {
            // gut: der Fehlerzustand wurde gemeldet
        }

    }


    @Test
    void getAllOrderByStatus_with_status_start_should_answer_3() {
        //GIVEN
        ShopService shopService = new ShopService();
        assertEquals(shopService.getAllOrderByStatus("start").size(),3);    }

    @Test
    void getAllOrderByStatus_with_status_sended_should_answer_1() {
        //GIVEN
        ShopService shopService = new ShopService();
        assertEquals(shopService.getAllOrderByStatus("sended").size(),1);    }


    @Test
    void updateOrder() {

        ShopService shopService = new ShopService();
        shopService.updateOrder("3","sended");

        assertEquals(shopService.getAllOrderByStatus("sended").size(), 2);


    }


}
