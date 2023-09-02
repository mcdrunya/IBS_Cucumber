package ru.ibs.jdbc;

import javax.sql.DataSource;
import java.io.IOException;

public class Setup {
    public static FoodDatabaseHelper setUpDatabase() throws IOException {
        DataSource dataSource = DatabaseConfig.createDataSource();

        return new FoodDatabaseHelper(dataSource);
    }
}
