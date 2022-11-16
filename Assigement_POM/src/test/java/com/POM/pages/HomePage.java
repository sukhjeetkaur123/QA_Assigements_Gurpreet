package com.POM.pages;

import com.testBase.TestBase;
import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class HomePage extends TestBase {
    @FindBy(xpath = "//label[contains(text(),'Community')]")
    WebElement community_checkBox;

    public HomePage() {
        PageFactory.initElements(driver,this);
    }
    public String verifyTitle() {
        System.out.println("the titlr"+driver.getTitle());
        return driver.getTitle();
    }

//    BEfore click checkbox to verify is it unchecked
    public void verifyBoxUnChecked(){
        String value = driver.findElement(By.xpath("//input[@id='su__facet-1-Community']")).getAttribute("class");
       Assert.assertEquals(value,"su__toggle-input su__cursor su__mr-2 ");
    }

    public void selctRandomFilterAndSelectRandomOptionandAndCheckedUnderThat() throws InterruptedException {
        int options = driver.findElements(By.xpath("((//div[@class='su__w-100 su__bg-white'])[2]//input[@type='checkbox'])")).size();
        Random random = new Random();
//        int index = random.nextInt(options+1);
        int min = 1;
        int max = 2;
        int value = (int) (Math.random() * (max-min+1)+min);
        String str = "((//div[@class='su__w-100 su__bg-white'])[2]//input[@type='checkbox'])[" +value+ "]";
        WebElement ele = driver.findElement(By.xpath(str));
        System.out.println("the elemet is"+str);
        Actions action = new Actions(driver);
        action.moveToElement(ele).click().perform();

        if(value==1){
            verifyBoxIsCheckedDocumentation();
          selectRandomOptionFromDocumentChechBox();
        }
        else if(value==2){
            verfiyBoxIsChecked();
            selectRandomOptionFromCommunityChechBox();
        }
    }

    public void verfiyBoxIsChecked() throws InterruptedException {
        Thread.sleep(3000);
        String value = driver.findElement(By.xpath("//input[@id='su__facet-1-Community']")).getAttribute("class");
        Assert.assertEquals(value, "su__toggle-input su__cursor su__mr-2 su__filter-checked");
    }

    public void verifyBoxIsCheckedDocumentation() throws InterruptedException {
        Thread.sleep(3000);
        String value = driver.findElement(By.xpath("//input[@id='su__facet-1-Documentation']")).getAttribute("class");
        Assert.assertEquals(value, "su__toggle-input su__cursor su__mr-2 su__filter-checked");

    }

    public void selectRandomOptionFromDocumentChechBox(){
        int options = driver.findElements(By.xpath("(//div[@class='su__filter-content-row su__position-relative su__pb-1 su__px-3 su__bg-gray-hover su__py-1 topic '])")).size();
        Random random = new Random();
        int min = 0;
        int max = 8;
        int value = (int) (Math.random() * (max-min+1)+min);
        String str = "((//div[@class='su__w-100 su__bg-white'])[4]//input[@type='checkbox'])[" +value+ "]";
        WebElement ele = driver.findElement(By.xpath(str));
        String actual = ele.getText();
        System.out.println("the actual data :"+actual);
        Actions action = new Actions(driver);
        action.moveToElement(ele).click().perform();

        List<WebElement> list = driver.findElements(By.xpath("((//div[@class='su__w-100 su__bg-white'])[4]//input[@type='checkbox'])"));
        for(WebElement expect:list) {
            String expected = expect.getText();
            System.out.println("the expected data" + expected);
            if (expected.contains(actual)) {
                System.out.println("the data is presnt in list");
            } else {
                System.out.println("the data in the list is not avaaiable");
            }
        }
    }

    public void selectRandomOptionFromCommunityChechBox(){
        int options = driver.findElements(By.xpath("((//div[@class='su__w-100 su__bg-white'])[4]//input[@type='checkbox'])")).size();
        Random random = new Random();
        int index = random.nextInt(options+1);
        String str = "((//div[@class='su__w-100 su__bg-white'])[4]//input[@type='checkbox'])[" +index+ "]";
        WebElement ele = driver.findElement(By.xpath(str));
        System.out.println("the elemet is"+str);
        Actions action = new Actions(driver);
        action.moveToElement(ele).click().perform();
        String actual= ele.getText();
        List<WebElement> list = driver.findElements(By.xpath("((//div[@class='su__w-100 su__bg-white'])[4]//input[@type='checkbox'])"));
        for(WebElement expect:list){
            String expected = expect.getText();
            System.out.println("the expected data"+expected);
            if(expected.contains(actual)){
                System.out.println("the data is presnt in list");
            }
            else {
                System.out.println("the data in the list is not avaaiable");
            }
        }
        }
}

