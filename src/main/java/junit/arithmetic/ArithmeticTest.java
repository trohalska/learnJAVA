package junit.arithmetic;

import org.junit.*;

public class ArithmeticTest {
    private static Arithmetic a;

    @BeforeClass
    public static void runTest() {
        a = new Arithmetic();
    }

    @Test
    public void testAdd() {
        int result = a.add(1, 2);
        Assert.assertEquals(3, result);
    }

    @Ignore
    @Test
    public void testDeduct() {
        int result = a.deduct(1, 2);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testMultiply() {
        int result = a.multiply(2, 3);
        Assert.assertEquals(6, result);
    }

    @Test
    public void testDivide() {
        double result = a.divide(6, 2);
        if(result != 3.0) Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testDivideException() {
        a.divide(6, 0);
    }
}