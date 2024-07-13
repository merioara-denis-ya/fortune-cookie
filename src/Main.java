import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String goodFortuneText = "Вам повезёт!";
        ArrayList<String> goodFortune = new ArrayList<>();
        goodFortune.add(goodFortuneText);

        String badFortuneText = "Сегодня будет дождь";
        ArrayList<String> badFortune = new ArrayList<>();
        badFortune.add(badFortuneText);

        boolean isPositive = false;
        FortuneConfig fortuneConfig = new FortuneConfig(isPositive);
        FortuneCookieFactory fortuneCookieFactory = new FortuneCookieFactory(fortuneConfig, goodFortune, badFortune);
        FortuneCookieController fortuneCookieController = new FortuneCookieController(fortuneCookieFactory);

        String result = fortuneCookieController.tellFortune().getFortuneText();

        System.out.println("Result:" + result);
    }
}
