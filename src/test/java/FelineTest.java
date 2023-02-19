import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline felineSpy;

    @Mock
    Feline felineMock;

    @Test
    public void getKittensWithParameterExpectOk() {
        Feline feline = new Feline();
        Assert.assertEquals(1, feline.getKittens(1));
    }

    @Test
    public void getKittensWithoutParameterExpectOk() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getFamilyExpectedOk() {
        Feline feline = new Feline();
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeetExpectedOk() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of("Трава", "Различные растения"));
        Assert.assertEquals(List.of("Трава", "Различные растения"), felineMock.eatMeat());
    }

}
