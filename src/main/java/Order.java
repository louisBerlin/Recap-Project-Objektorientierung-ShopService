import java.util.List;

public record Order(
        String id,

        String PROCESSING,
        String IN_DELIVERY,
        String COMPLETED,
        List<Product> products
) {
}
