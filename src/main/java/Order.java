import lombok.With;

import java.time.LocalDateTime;
import java.util.List;


public record Order(
        String id,
        List<Product> products,
        @With

        String PROCESSING,
        String IN_DELIVERY,
        String COMPLETED,

        LocalDateTime timestamp
) {
}

/*
Extend the Order object with a field that stores the order timestamp. In the 'addOrder' method, fill this field with the current timestamp.


This timestamp should be able to be used as evidence in court if customers claim that they did not place the order. Consider which data type is best suited for this, even if customers order from abroad.
 */