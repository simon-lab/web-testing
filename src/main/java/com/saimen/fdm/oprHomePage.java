package com.saimen.fdm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.saimen.AbstractPage;

public class oprHomePage extends AbstractPage {
    @FindBy(xpath = "//span[@class='brand-text font-weight-light']")
    private WebElement validator;
    @FindBy(xpath = "//h4[text()='Approval Request']")
    private WebElement approvalPopUpValidator;
    @FindBy(xpath = "//div[@class='swal2-icon swal2-success swal2-icon-show']")
    private WebElement approveValidator;
    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    private WebElement closeBtn;

    @FindBy(xpath = "//a[@data-target='#approval-modal']")
    private WebElement approvalBtn;
    @FindBy(xpath = "//button[@class='//div[@class='col-md-8 datarow']/h5']")
    private List<WebElement> dataApproveList;
    @FindBy(xpath = "//button[@class='btn_app btn btn-sm btn-success']")
    private WebElement approveBtn;

    @FindBy(xpath = "//a[@href='/mos']")
    private WebElement fdmBtn;

    public oprHomePage(WebDriver driver) {
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.validator));
        return this.validator.isDisplayed();
    }

    public void fdmClick() {
        fdmBtn.click();
    }

    public void approvalClick() {
        approvalBtn.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.approvalPopUpValidator));
    }

    public int cariKolom(String namaMerchant) {

        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElements(dataApproveList));

        for (int i = 0; i < rows.size(); i++) {
            WebElement namaElement = rows.get(i).findElement(By.cssSelector("div.col-md-8.datarow h5"));
            String nama = namaElement.getText().trim();
            if (nama.equalsIgnoreCase(namaMerchant)) {
                System.out.println("Ditemukan di baris ke-" + i);
                return i;
            }
        }

        Assert.fail("Nama merchant " + namaMerchant + " tidak ditemukan di list approval");
        return -1;
    }

    public void approve1Click() {
        approveBtn.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.approveValidator));
        closeBtn.click();
    }

    public void approveClick(int kolomBerapa) {
        driver.findElement(By.xpath("(//button[@class='btn_app btn btn-sm btn-success'])[" + kolomBerapa + "]"))
                .click();
        this.wait.until(ExpectedConditions.visibilityOf(this.approveValidator));
        closeBtn.click();
    }

    public void rejectedClick(int kolomBerapa) {
        driver.findElement(By.xpath("(//button[@class='btn_app btn btn-sm btn-danger'])[" + kolomBerapa + "]"))
                .click();
    }

    public void detailClick(int kolomBerapa) {
        driver.findElement(By.xpath("(//button[@class='btn_app btn btn-sm btn-secondary'])[" + kolomBerapa + "]"))
                .click();
    }

}
