package ru.praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.pages.MainPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnswersTest {

    private final By question;
    private final By answer;
    private final String result;

    public AnswersTest(By question, By answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] getOptions() {
        return new Object[][] {
                { MainPage.firstQuestion, MainPage.firstAnswer, "Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                { MainPage.secondQuestion, MainPage.secondAnswer, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." },
                { MainPage.thirdQuestion, MainPage.thirdAnswer, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30." },
                { MainPage.fourthQuestion, MainPage.fourthAnswer, "Только начиная с завтрашнего дня. Но скоро станем расторопнее." },
                { MainPage.fifthQuestion, MainPage.fifthAnswer, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010." },
                { MainPage.sixthQuestion, MainPage.sixAnswer, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится." },
                { MainPage.seventhQuestion, MainPage.seventhAnswer, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои." },
                { MainPage.eighthQuestion, MainPage.eighthAnswer, "Да, обязательно. Всем самокатов! И Москве, и Московской области." }
        };
    }

    @Test
    public void checkCorrectAnswer() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .clickOnCookieButton()
                .clickOnQuestion(question)
                .waitForDisplayingFields(answer);
        assertEquals("Текст не совпадает", result, driverRule.getDriver().findElement(answer).getText());
    }
}