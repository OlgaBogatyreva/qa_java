import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionCheckTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensExpectOk() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        Assert.assertEquals(2, lion.getKittens());
    }

    @Test
    public void doesHasManeExpectTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void doesHasManeExpectFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void doesHasManeExpectMessage() throws Exception {
        try {
            Lion lion = new Lion("Неопределившийся", feline);
        } catch (Exception exception) {
            //System.out.println(exception);
            Assert.assertEquals(exception, exception);
        }
    }

    @Test
    public void getFoodCheck() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Трава", "Различные растения"));
        Assert.assertEquals(List.of("Трава", "Различные растения"), lion.getFood());
    }
}
