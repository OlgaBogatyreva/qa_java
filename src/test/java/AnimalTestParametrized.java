import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTestParametrized {

    private final String animalClass;
    private final List food;

    public AnimalTestParametrized(String animalClass, List food) {
        this.animalClass = animalClass;
        this.food = food;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getCities() {
        return new Object[][]{
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")},
        };
    }

    @Test
    public void getFoodTestExpectedOk() throws Exception {
        Animal animal = new Animal();
        Assert.assertEquals(animal.getFood(animalClass), food);
    }
}
