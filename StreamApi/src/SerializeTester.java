import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeTester {
    @Test
    @DisplayName("Should serialize Cafe object")
    void serializeCafe() throws IOException {
        List<Pizza> menu = new ArrayList<>();
        Main.initMenu(menu);
        List<Customer> customers = new ArrayList<>();
        Main.initListCustomers(customers, menu);
        Cafe cafe1 = new Cafe(menu, customers);
        CafeSerializer.saveObject(cafe1);
    }

    @Test
    @DisplayName("Should deserialize Cafe object")
    void deserializeCafe() throws IOException, ClassNotFoundException {
        var res = CafeSerializer.readObject();
        System.out.println(res);
    }

}
