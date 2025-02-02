import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(11, "булочка", 40);
    Product product2 = new Product(22, "косичка", 50);
    Product product3 = new Product(33, "улитка", 60);

    @Test
    public void testDeleteExistingOne() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(product1.getId());
        Product[] expected = {product2, product3};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testNotDeleteNotExistingOne() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(55);
        });

    }
}


