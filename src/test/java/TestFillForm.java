
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import com.codeborne.selenide.selector.ByText;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestFillForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        String userName = "Nataly";
        //Open page
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        // Add  First Name
        $("#firstName").setValue(userName);
        // Add Last Name
        $("#lastName").setValue("Bochkova");
        // Add Email
        $("#userEmail").setValue("Nataly@natal.com");
        // Add Gender
        $x("//label[contains(text(),'Female')]").click();
        // Add Mobile
        $("#userNumber").setValue("79999999999");
        // Add Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--023").click();
        // Add Subjects
        $x(".//*[@id='subjectsContainer']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        // Add Hobbies
        $x("//label[text()='Sports']").click();
        // Add Picture
        $x("//input[@id='uploadPicture']").uploadFile(new File("C:\\QA GURU\\demoga-\\src\\test\\resources\\Screenshot_188.png"));
        // Add Current Address
        $("#currentAddress").setValue("Moscow,Lenina 152");
        // Add State
        $("#stateCity-wrapper").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("NCR")).click();
        // Add City
        $("#city").click();
        $("#city").$(new ByText("Delhi")).click();
        // Click on Submit
        $("#submit").click();
        // Check
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Nataly Bochkova"), text("Nataly@natal.com"), text("23 June,1992"), text("Female"), text("English"), text("Delhi"));
    }
}

