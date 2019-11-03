import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class KoszykTest {

    private Koszyk koszyk;
    private Produkt produkt;

    @BeforeEach
    public void setUp() {
        produkt = new Produkt("truskawki", 19.99, 2);
        koszyk = new Koszyk();
    }

    @Test
    void addTest() {
        Produkt produkt2=new Produkt("morela", 0.99, 1);
        koszyk.add(produkt2);
        koszyk.add(produkt); //koszyk zawira 1 produkt - truskawki
        assertEquals(2, koszyk.getNumberOfElements());
        System.out.println("addTest passed");
    }

    @Test
    void removeTest() {
        koszyk.add(produkt); //koszyk zawira 1 produkt - truskawki
        try {
            koszyk.remove(produkt);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(0, koszyk.getNumberOfElements());
        System.out.println("removeTest passed");
    }

    @Test
    void removeExceptionTest() {
        Produkt produkt3 = new Produkt("sliwki", 0.5, -2);
        Assertions.assertThrows(ProductNotFoundException.class, ()->{koszyk.remove(produkt3);});
        System.out.println("removeExceptionTest passed");
    }

    @Test
    void removeContainsTest(){
        koszyk.add(produkt); //koszyk zawira 1 produkt - truskawki
        try {
            koszyk.remove(produkt);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
        assertFalse(koszyk.contains(produkt));
        System.out.println("removeContainsTest passed");
    }
    @Test
    void isEmptyTest() {
        Koszyk koszyk2 = new Koszyk();
        assertTrue(koszyk2.isEmpty());
        System.out.println("isEmptyTest passed");
    }

    @Test
    void removeAllTest(){
        Produkt produkt2 = new Produkt("morela", 0.99, 1);
        koszyk.add(produkt); //koszyk zawira 1 produkt - truskawki
        koszyk.add(produkt2);

        koszyk.removeAll();
        assertTrue(koszyk.isEmpty());
        System.out.println("removeAllTest passed");
    }

    @Test
    void valueTest(){
        Produkt produkt2 = new Produkt("morela", 0.99, 1);

        koszyk.add(produkt); //koszyk zawira 1 produkt - truskawki
        koszyk.add(produkt2);
        assertEquals(40.97, koszyk.value());
        System.out.println("valueTest passed");
    }
}
