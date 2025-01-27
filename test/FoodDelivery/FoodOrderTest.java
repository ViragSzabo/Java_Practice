package FoodDelivery;

import FoodDelivery.Exceptions.FoodTypeCannotBeNull;
import FoodDelivery.Exceptions.InvalidOrderException;
import FoodDelivery.Orders.FoodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodOrderTest
{
    private FoodOrder foodOrder;

    @BeforeEach
    void setUp()
    {
        this.foodOrder = new FoodOrder(123, 34);
    }

    @Test
    void calculateTotalPrice() throws InvalidOrderException, FoodTypeCannotBeNull
    {
        assertThrows(InvalidOrderException.class, () -> this.foodOrder.calculateTotalPrice());
        assertThrows(FoodTypeCannotBeNull.class, () -> this.foodOrder.addFood(null));

        this.foodOrder.addFood(FoodType.DESSERT);
        assertEquals(5.25, this.foodOrder.calculateTotalPrice());

        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.BURGER);
        this.foodOrder.addFood(FoodType.SUSHI);
        assertNotEquals(5.25, this.foodOrder.calculateTotalPrice());
        assertEquals(82.5, this.foodOrder.calculateTotalPrice());

        this.foodOrder.addFood(FoodType.DESSERT);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.BURGER);
        this.foodOrder.addFood(FoodType.SUSHI);
        assertNotEquals(82.5, this.foodOrder.calculateTotalPrice());
        assertEquals(164.75, this.foodOrder.calculateTotalPrice());

        this.foodOrder.addFood(FoodType.DESSERT);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.BURGER);
        this.foodOrder.addFood(FoodType.SUSHI);
        assertNotEquals(164.75, this.foodOrder.calculateTotalPrice());
        assertEquals(246.95, this.foodOrder.calculateTotalPrice());

        assertFalse(foodOrder.getType().isEmpty());
    }

    @Test
    void calculateDeliveryFee() throws FoodTypeCannotBeNull
    {
        assertThrows(FoodTypeCannotBeNull.class, () -> this.foodOrder.addFood(null));

        this.foodOrder.addFood(FoodType.DESSERT);
        assertEquals(0.25, this.foodOrder.calculateDeliveryFee());

        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.BURGER);
        this.foodOrder.addFood(FoodType.SUSHI);
        assertNotEquals(0.25, this.foodOrder.calculateDeliveryFee());
        assertEquals(0.50, this.foodOrder.calculateDeliveryFee());

        this.foodOrder.addFood(FoodType.DESSERT);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.BURGER);
        this.foodOrder.addFood(FoodType.SUSHI);
        assertNotEquals(0.50, this.foodOrder.calculateDeliveryFee());
        assertEquals(0.75, this.foodOrder.calculateDeliveryFee());

        this.foodOrder.addFood(FoodType.DESSERT);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.PIZZA);
        this.foodOrder.addFood(FoodType.BURGER);
        this.foodOrder.addFood(FoodType.SUSHI);
        assertNotEquals(0.75, this.foodOrder.calculateDeliveryFee());
        assertEquals(0.95, this.foodOrder.calculateDeliveryFee());
    }

    @Test
    void OrderInformation() throws InvalidOrderException, FoodTypeCannotBeNull
    {
        this.foodOrder.setOrderID(111);
        assertEquals(111, this.foodOrder.getOrderID());

        this.foodOrder.setCustomerID(1);
        assertEquals(1, this.foodOrder.getCustomerID());

        this.foodOrder.addFood(FoodType.DESSERT);
        assertEquals(5.25, this.foodOrder.calculateTotalPrice());
    }
}