import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();


// Add an 'updateOrder' method in the ShopService that updates the Order based on an orderId and a new order status.
// Use the Lombok @With annotation for this.
    public void updateOrder (String orderId, String status) {
        System.out.println(orderRepo.getOrderById(orderId));
        Order order = orderRepo.getOrderById(orderId).withPROCESSING(status);
                // delete old one
        orderRepo.removeOrder(orderId);
                // add order with modification
        orderRepo.addOrder(order);

        System.out.println(orderRepo.getOrderById(orderId));
    }

    // Modify the 'addOrder' method in the ShopService so that an exception is thrown if the product does not exist.
    public Order addOrder(List<String> productIds) {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> productToOrder = productRepo.getProductById(productId);


            try {
                products.add(productToOrder.get());

            } catch (Exception e) {
                System.out.println("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
                throw new RuntimeException(e);
            }



        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products,"","","", LocalDateTime.now());

        return orderRepo.addOrder(newOrder);
    }




    /*
    Write a method in the ShopService that returns a list of all orders with a specific order status (parameter) using streams.
     */

    public List<Order> getAllOrderByStatus (String orderStatus) {
        List<Order> orders = orderRepo.getOrders();
        return orders.stream().filter(n -> n.PROCESSING().equals(orderStatus))
                .collect(Collectors.toList());
    }
}
