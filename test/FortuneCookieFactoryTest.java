import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FortuneCookieFactoryTest {
    FortuneConfig fortuneConfig = new FortuneConfig(true);
    String goodFortuneText = "Вам повезёт!";
    public ArrayList<String> goodFortune;
    String badFortuneText = "Сегодня будет дождь";
    ArrayList<String> badFortune;

    FortuneCookieFactory fortuneCookieFactory;

    @BeforeEach
    void beforeEach() {
        goodFortune = new ArrayList<>();
        goodFortune.add(goodFortuneText);
        badFortune = new ArrayList<>();
        badFortune.add(badFortuneText);

        fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, goodFortune, badFortune);
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        int result = fortuneCookieFactory.getCookiesBaked();

        Assertions.assertEquals(1, result);
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.bakeFortuneCookie();
        int result = fortuneCookieFactory.getCookiesBaked();

        Assertions.assertEquals(2, result);
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCreatedCall() {
        fortuneCookieFactory.bakeFortuneCookie();
        fortuneCookieFactory.resetCookiesCreated();
        int result = fortuneCookieFactory.getCookiesBaked();

        Assertions.assertEquals(0, result);
    }
}