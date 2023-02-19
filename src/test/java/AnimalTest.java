import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }

    @Test
    public void getFoodTestExpectedException() throws Exception {
        Animal animal = new Animal();
        boolean isExeption = false;
        try {
            animal.getFood("Кот");
        } catch (Exception exception) {
            isExeption = true;
        }
        Assert.assertEquals(true, isExeption);
    }
}
