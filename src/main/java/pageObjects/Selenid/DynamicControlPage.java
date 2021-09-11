package pageObjects.Selenid;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicControlPage extends MainSelenidePage {
    private SelenideElement checkbox = $("input[type='checkbox']");
    private SelenideElement removeCheckboxButton = $x("//form[@id='checkbox-example']/button");
    private SelenideElement enableOrDisableButton = $x("//form[@id='input-example']/button");
    private SelenideElement successMessage = $x("//p[@id='message']");

    public DynamicControlPage setCheckbox(){
        checkbox.shouldBe(Condition.visible).click();
        return new DynamicControlPage();
    }
    public DynamicControlPage removeCheckbox(boolean remove){
        removeCheckboxButton.shouldBe(Condition.enabled).click();
        if (remove){
            checkbox.should(Condition.disappear);
            removeCheckboxButton.should(Condition.matchText("Add"));
        }else {
            checkbox.should(Condition.appear);
            removeCheckboxButton.should(Condition.matchText("Remove"));
        }
        return new DynamicControlPage();
    }

    public DynamicControlPage enableButton(boolean enable){
        if (enable){
            enableOrDisableButton.should(Condition.matchText("Enable")).click();
        }
        else {
            enableOrDisableButton.should(Condition.visible).should(Condition.matchText("Disable")).click();
        }
        return new DynamicControlPage();
    }

    public String getSuccessMessage(){
        return successMessage.should(Condition.visible).getText();
    }
}
