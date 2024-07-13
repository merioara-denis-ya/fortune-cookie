import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FortuneCookieControllerTest {
    public FortuneCookieController fortuneCookieController;

    String goodFortuneText = "Вам повезёт!";
    public ArrayList<String> goodFortune;
    String badFortuneText = "Сегодня будет дождь";
    ArrayList<String> badFortune;

    @BeforeEach
    void beforeEach() {
        goodFortune = new ArrayList<>();
        goodFortune.add(goodFortuneText);
        badFortune = new ArrayList<>();
        badFortune.add(badFortuneText);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        boolean isPositive = true;
        FortuneConfig fortuneConfig = new FortuneConfig(isPositive);
        FortuneCookieFactory fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, goodFortune, badFortune);
        FortuneCookieController fortuneCookieController = new FortuneCookieController(fortuneCookieFactory);

        String result = fortuneCookieController.tellFortune().getFortuneText();

        Assertions.assertEquals(goodFortuneText, result);
    }

    @Test
    public void shouldReturnNegativeFortune() {
        boolean isPositive = false;
        FortuneConfig fortuneConfig = new FortuneConfig(isPositive);
        FortuneCookieFactory fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, goodFortune, badFortune);
        FortuneCookieController fortuneCookieController = new FortuneCookieController(fortuneCookieFactory);

        String result = fortuneCookieController.tellFortune().getFortuneText();

        Assertions.assertEquals(badFortuneText, result);
    }
}