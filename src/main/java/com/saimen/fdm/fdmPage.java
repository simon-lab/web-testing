package com.saimen.fdm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.saimen.AbstractPage;

public class fdmPage extends AbstractPage {
    @FindBy(xpath = "//h4[.='List MOS']")
    private WebElement validator;
    @FindBy(xpath = "//*[@id='mosList']/tbody/tr/td[1]")
    private WebElement listValidator;

    @FindBy(xpath = "//a[@href='/mos']")
    private WebElement fdmBtn;
    @FindBy(xpath = "//span[@class='align-middle d-sm-inline-block d-none me-sm-2']")
    private WebElement buatMosBtn;
    @FindBy(xpath = "//input[@id='create_date']")
    private WebElement dateBtn;
    @FindBy(xpath = "//select[@id='status']")
    private WebElement statusBtn;
    @FindBy(xpath = "//div[@id='mosList_filter']//input[@class='form-control form-control-sm']")
    private WebElement searchFunc;
    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> rowList;
    @FindBy(xpath = "//table/tbody/tr[2]/td[2]")
    private WebElement namaMerchant;
    @FindBy(xpath = "//table/tbody/tr[2]/td[3]")
    private WebElement namaPerusahaan;
    @FindBy(xpath = "//table/tbody/tr[2]/td[4]")
    private WebElement pemilikMerchant;
    @FindBy(xpath = "//table/tbody/tr[2]/td[5]")
    private WebElement tglDaftar;
    @FindBy(xpath = "//table/tbody/tr[2]/td[6]/span")
    private WebElement status;
    @FindBy(xpath = "//button[@class='btn btn-warning btn-xs']")
    private WebElement editBtn;
    @FindBy(xpath = "(//button[@class='btn btn-secondary btn-xs'])[2]")
    private WebElement detailBtn;
    @FindBy(xpath = "//button[@class='btn btn-danger btn-xs']")
    private WebElement deleteBtn;
    @FindBy(xpath = "//button[text()='Yes, delete it!']")
    private WebElement acceptDeleteBtn;
    @FindBy(xpath = "//button[@class='swal2-cancel swal2-styled']")
    private WebElement cancelDeleteBtn;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-xs']")
    private WebElement analystBtn;
    @FindBy(xpath = "//li[@id='mosList_previous']")
    private WebElement previousBtn;
    @FindBy(xpath = "//li[@id='mosList_next']")
    private WebElement nextBtn;

    public fdmPage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.namaMerchant));
        return this.validator.isDisplayed();
    }

    public void setStatus(String status) {
        Select dropdown = new Select(statusBtn);

        if (status == "approved") {
            dropdown.selectByValue("APPROVED");
        } else {
            dropdown.selectByValue("DRAFT");
        }
    }

    public void buatMOS() {
        buatMosBtn.click();
    }

    public void analystClick() {
        analystBtn.click();
    }

    public int cariKolom(String namaMerchant) {

        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElements(rowList));

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            if (columns.size() >= 2) {
                String merchantText = columns.get(1).getText().trim(); // kolom ke-2
                if (merchantText.equalsIgnoreCase(namaMerchant)) {
                    System.out.println("Kolom ke - " + (i + 1));
                    return i + 1;
                }
            }
        }

        Assert.fail("Tidak ada Nama Merchant yang sesuai: " + namaMerchant);
        return -1;
    }

    public void assertData(String expectedNamaMerchant, String expectedNamaPerusahaan, String expectedPemilikMerchant,
            String expectedTglDaftar, String expectedStatus, int kolomBerapa, String unikString) {

        this.wait.until(ExpectedConditions.visibilityOf(this.namaMerchant));

        Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr[" + kolomBerapa + "]/td[2]")).getText(),
                expectedNamaMerchant + " " + unikString);
        Assert.assertTrue(driver.findElement(By.xpath("//table/tbody/tr[" + kolomBerapa + "]/td[3]")).getText()
                .equalsIgnoreCase(expectedNamaPerusahaan + " " + unikString));
        // Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr[" +
        // kolomBerapa + "]/td[4]")).getText(),
        // expectedPemilikMerchant + " " + unikString);
        Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr[" + kolomBerapa + "]/td[5]")).getText(),
                expectedTglDaftar);
        Assert.assertEquals(driver.findElement(By.xpath("//table/tbody/tr[" + kolomBerapa + "]/td[6]/span")).getText(),
                expectedStatus);
        // Assert.assertEquals(namaPerusahaan.getText(), expectedNamaPerusahaan);
        // Assert.assertEquals(pemilikMerchant.getText(), expectedPemilikMerchant);
        // Assert.assertEquals(tglDaftar.getText(), expectedTglDaftar);
    }

    public void editClick() {
        editBtn.click();
    }

    public void detailClick(int kolomBerapa) {
        driver.findElement(By.xpath("(//button[@class='btn btn-secondary btn-xs'])[" + kolomBerapa + "]")).click();
    }

    public void deleteClick() {
        deleteBtn.click();
        acceptDeleteBtn.click();
    }
}
