package com.lingh;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

@SuppressWarnings({"SqlDialectInspection", "SqlNoDataSourceInspection"})
class MySQLAndPostgresTest {


    @Test
    void testMySQL() {
        System.out.println("Starting MySQL ...");
        Awaitility.await().atMost(Duration.ofMinutes(1)).ignoreExceptionsMatching(e -> e instanceof CommunicationsException)
                .until(() -> {
                    openConnectionInMySQL().close();
                    return true;
                });
        System.out.println("MySQL started");
        try (Connection connection = openConnectionInMySQL()) {
            connection.createStatement().executeUpdate("CREATE DATABASE demo_ds_1;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection openConnectionInMySQL() throws SQLException {
        Properties props = new Properties();
        return DriverManager.getConnection("jdbc:tc:mysql:8.2.0-oracle://test-native-databases-mysql/demo_ds_0?TC_DAEMON=true&user=root&password=", props);
    }

    @Test
    void testPostgres() {
        System.out.println("Starting Postgres ...");
        Awaitility.await().atMost(Duration.ofMinutes(1))
                .until(() -> {
                    openConnectionInPostgres().close();
                    return true;
                });
        System.out.println("Postgres started");
        try (Connection connection = openConnectionInPostgres()) {
            connection.createStatement().executeUpdate("CREATE DATABASE demo_ds_1;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Connection openConnectionInPostgres() throws SQLException {
        Properties props = new Properties();
        return DriverManager.getConnection("jdbc:tc:postgresql:16.1-bookworm://test-native-databases-postgres/demo_ds_0?TC_DAEMON=true", props);
    }
}
