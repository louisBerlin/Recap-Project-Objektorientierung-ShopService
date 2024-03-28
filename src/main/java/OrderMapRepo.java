import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo{
    private Map<String, Order> orders = new HashMap<>();


    public OrderMapRepo() {

            Product product = new Product("1", "Apfel");



        this.addOrder(new Order("1", List.of(product),"start","","",null));
        this.addOrder(new Order("2", List.of(product),"start","","",null));
        this.addOrder(new Order("3", List.of(product),"start","","",null));
        this.addOrder(new Order("4", List.of(product),"sended","","",null));


    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order getOrderById(String id) {
        return orders.get(id);
    }

    @Override
    public Order addOrder(Order newOrder) {
        orders.put(newOrder.id(), new Order(newOrder.id(),newOrder.products(),newOrder.PROCESSING(),newOrder.IN_DELIVERY(),newOrder.COMPLETED(), LocalDateTime.now()));
        return newOrder;
    }



    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }
}
