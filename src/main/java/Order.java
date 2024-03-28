import java.util.List;

public record Order(
        String id,
        List<Product> products,
         String PROCESSING,
        String IN_DELIVERY,
        String COMPLETED
) {
}
