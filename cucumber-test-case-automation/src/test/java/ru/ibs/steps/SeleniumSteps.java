package ru.ibs.steps;

import io.cucumber.java.ru.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumSteps {

    // Общие шаги

    @И("открыта страница с продуктами")
    public void pageOpened(){
        Hooks.before_all();
    }

    @И("^отображается кнопка \"Добавить\"$")
    public void verifyAddButtonIsDisplayed() {
        assertTrue(Hooks.foodPage.addBtn.isDisplayed());
    }

    @И("^пользователь нажимает кнопку \"Добавить\"$")
    public void clickAddButton() {
        Hooks.foodPage.clickAddBtn();
        Hooks.wait.until(ExpectedConditions.visibilityOf(Hooks.foodPage.productForm));
    }

    // Шаги проверки формы добавления товара (наличие элементов в форме)


    @И("^отображается поле для ввода наименования$")
    public void verifyNameFieldIsDisplayed() {
        assertTrue(Hooks.foodPage.nameField.isDisplayed());
    }

    @И("^отображается поле для выбора типа продукта$")
    public void verifyTypeFieldIsDisplayed() {
        assertTrue(Hooks.foodPage.typeField.isDisplayed());
    }

    @И("^отображается флажок для экзотического продукта$")
    public void verifyExoticCheckBoxIsDisplayed() {
        assertTrue(Hooks.foodPage.exoticCheckBox.isDisplayed());
    }

    @И("^отображается кнопка \"Сохранить\"$")
    public void verifySaveButtonIsDisplayed() {
        assertTrue(Hooks.foodPage.saveBtn.isDisplayed());
    }

    // Шаги для проверки добавления нового товара

    @И("^отображается колонка \"Наименование\"$")
    public void verifyNameColumnIsDisplayed() {
        assertTrue(Hooks.foodPage.colName.isDisplayed());
    }

    @И("^отображается колонка \"Тип\"$")
    public void verifyTypeColumnIsDisplayed() {
        assertTrue(Hooks.foodPage.colType.isDisplayed());
    }

    @И("^отображается колонка \"Экзотический\"$")
    public void verifyExoticColumnIsDisplayed() {
        assertTrue(Hooks.foodPage.colExotic.isDisplayed());
    }

    @И("^пользователь вводит \"(.*)\" в поле для наименования$")
    public void inputProductName(String productName) {
        Hooks.foodPage.inputName(productName);
    }

    @И("^пользователь выбирает тип \"(.*)\"$")
    public void selectProductType(String productType) {
        Hooks.foodPage.selectType(productType);
    }

    @И("^пользователь отмечает флажок экзотического продукта$")
    public void checkExoticCheckBox() {
        if (!Hooks.foodPage.exoticCheckBox.isSelected()) {
            Hooks.foodPage.clickCheckBox();
        }
    }

    @И("^пользователь нажимает кнопку \"Сохранить\"$")
    public void clickSaveButton() {
        Hooks.foodPage.clickSaveBtn();
    }

    @Тогда("^продукт \"(.*)\" должен быть успешно добавлен$")
    public void verifyProductIsAdded(String productName) {
        Hooks.foodPage.tableUpdated(productName);
    }

}
