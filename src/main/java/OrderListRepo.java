import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo{
    private List<Order> orders = new ArrayList<>();


    public OrderListRepo() {
        Product product = new Product("1", "Apfel");


        this.addOrder(new Order("1", List.of(product),"start","","",null));
        this.addOrder(new Order("2", List.of(product),"start","","",null));
        this.addOrder(new Order("3", List.of(product),"start","","",null));
        this.addOrder(new Order("4", List.of(product),"sended","","",null));

    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public Order addOrder(Order newOrder) {
        orders.add(new Order(newOrder.id(),newOrder.products(),newOrder.PROCESSING(),newOrder.IN_DELIVERY(),newOrder.COMPLETED(), LocalDateTime.now()));
        return newOrder;
    }

    public void removeOrder(String id) {
        for (Order order : orders) {
            if (order.id().equals(id)) {
                orders.remove(order);
                return;
            }
        }
    }
}
