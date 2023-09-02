package ru.ibs.steps;

import io.cucumber.java.ru.*;
import ru.ibs.jdbc.FoodDatabaseHelper;
import ru.ibs.jdbc.Setup;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JdbcSteps {

    @И("^отображается таблица \"FOOD\"$")
    public void verifyTableIsDisplayed() throws IOException, SQLException {
        FoodDatabaseHelper foodDb = Setup.setUpDatabase();
        assertTrue(foodDb.isTableExists(), "Таблицы FOOD не существует");
    }
    @И("пользователь добавляет продукт {string} типа {string} и {string}")
    public void addProduct(String foodName, String foodType, String isExotic) throws IOException, SQLException {
        FoodDatabaseHelper foodDb = Setup.setUpDatabase();
        boolean isExoticBool = Boolean.parseBoolean(isExotic); // Преобразование строки в boolean
        foodDb.addFood(foodName, foodType, isExoticBool);
    }

    @И("отображается добавленный продукт {string} типа {string} и {string}")
    public void verifyAddedProduct(String foodName, String foodType, String isExotic) throws IOException, SQLException {
        FoodDatabaseHelper foodDb = Setup.setUpDatabase();
        boolean isExoticBool = Boolean.parseBoolean(isExotic);
        assertTrue(foodDb.isFoodExists(foodName, foodType, isExoticBool), "Продукт с тестовыми данными не найден в таблице");
    }

    @И("пользователь удаляет продукт {string} типа {string} и {string}")
    public void deleteProduct(String foodName, String foodType, String isExotic) throws IOException, SQLException {
        FoodDatabaseHelper foodDb = Setup.setUpDatabase();
        boolean isExoticBool = Boolean.parseBoolean(isExotic);
        foodDb.deleteFood(foodName, foodType, isExoticBool);
    }

    @И("продукт {string} типа {string} и {string} был удален")
    public void verifyDeletedProduct(String foodName, String foodType, String isExotic) throws IOException, SQLException {
        FoodDatabaseHelper foodDb = Setup.setUpDatabase();
        boolean isExoticBool = Boolean.parseBoolean(isExotic);
        assertFalse(foodDb.isFoodExists(foodName, foodType, isExoticBool), "Продукт с тестовыми данными не был удален");
    }
}