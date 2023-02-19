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
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensExpectedOk() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(2);
        Assert.assertEquals(2, lion.getKittens());
    }

    @Test
    public void doesHasManeExpectedTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void doesHasManeExpectedFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Assert.assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void doesHasManeExpectedOk() throws Exception {
        boolean isException = false;
        try {
            Lion lion = new Lion("Неопределившийся", feline);
        } catch (Exception exception) {
            isException = true;
        }
        Assert.assertEquals(true, isException);
    }

    @Test
    public void getFoodExpectedOk() throws Exception {
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Трава", "Различные растения"));
        Assert.assertEquals(List.of("Трава", "Различные растения"), lion.getFood());
    }
}
