package com.saimen.pages.nuPay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.saimen.AbstractPage;

public class NUPAYmerchantWebPage extends AbstractPage {
    @FindBy(xpath = "//h3[text()='List Data Merchants']")
    private WebElement validator;

    @FindBy(xpath = "//table[@class='q-table']/tbody/tr[1]")
    private WebElement namaMerchant;
    @FindBy(xpath = "//table[@class='q-table']/tbody/tr[1]/td[2]")
    private List<WebElement> merchantList;
    @FindBy(xpath = "(//i[@class='fa fa-edit q-icon notranslate'])[1]")
    private List<WebElement> editList;
    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> rowList;

    public NUPAYmerchantWebPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public int cariKolom(String namaMerchant) {
        this.wait.until(ExpectedConditions.visibilityOf(this.namaMerchant));

        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElements(rowList));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            if (columns.size() >= 2) {
                String merchantText = columns.get(2).getText().trim();
                if (merchantText.equalsIgnoreCase(namaMerchant)) {
                    System.out.println("Kolom ke - " + (i + 1));
                    return i + 1;
                }
            }
        }

        Assert.fail("Tidak ada Nama Merchant yang sesuai: " + namaMerchant);
        return -1;
    }

    public void assertData(String expectedMID, String expectedNamaMerchant, String expectedJenisKiosk,
            String expectedDate,
            int kolomBerapa) {
        this.wait.until(ExpectedConditions.visibilityOf(this.namaMerchant));

        Assert.assertEquals(
                driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[1]"))
                        .getText(),
                expectedMID);
        Assert.assertEquals(
                driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[2]")).getText(),
                expectedNamaMerchant);
        Assert.assertEquals(
                driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[3]")).getText(),
                "Active");

        if (expectedJenisKiosk.equalsIgnoreCase("single")) {
            Assert.assertEquals(
                    driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[4]"))
                            .getText(),
                    "Yes");
        } else if (expectedJenisKiosk.equalsIgnoreCase("multi")) {
            Assert.assertEquals(
                    driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[4]"))
                            .getText(),
                    "No");
        }

        Assert.assertEquals(
                driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[5]")).getText(),
                expectedDate);
        Assert.assertEquals(
                driver.findElement(By.xpath("//table[@class='q-table']/tbody/tr[" + kolomBerapa + "]/td[6]")).getText(),
                expectedDate);

    }

    public void clickEdit(int kolomBerapa) {

        driver.findElement(By.xpath("(//i[@class='fa fa-edit q-icon notranslate'])[" + kolomBerapa + "]")).click();
    }

}
