import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testNullList() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, 0);
        });
        assertEquals("allItems list can't be null!", exception.getMessage());
    }

    @Test
    void testNullItemName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("", "32412", 100, 0));
        assertTrue(SILab2.checkCart(items, 1000));
        assertEquals("unknown", items.get(0).getName());
    }

    @Test
    void testInvalidBarcode() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ime", "4fsse4s", 100, 0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, 1000);
        });
        assertEquals("Invalid character in item barcode!", exception.getMessage());
    }

    @Test
    void testNoBarcode() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ime", null, 100, 0));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items, 1000);
        });
        assertEquals("No barcode!", exception.getMessage());
    }

    @Test
    void testDiscountAndPriceReduction() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ime", "013332", 350, 0.44));
        assertTrue(SILab2.checkCart(items, 100));
    }

    @Test
    void testNoDiscount() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ime", "123456", 100, 0));
        assertTrue(SILab2.checkCart(items, 1000));
    }

    @Test
    void testTotalSumGreaterThanPayment() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Ime", "55555", 2000, 0));
        assertFalse(SILab2.checkCart(items, 1000));
    }
}