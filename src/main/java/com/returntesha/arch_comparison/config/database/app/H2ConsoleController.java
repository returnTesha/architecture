package com.returntesha.arch_comparison.config.database.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class H2ConsoleController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/h2-info")
    public Map<String, Object> getH2Info() {
        Map<String, Object> info = new HashMap<>();
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            info.put("databaseProductName", metaData.getDatabaseProductName());
            info.put("databaseProductVersion", metaData.getDatabaseProductVersion());
            info.put("url", metaData.getURL());
            info.put("userName", metaData.getUserName());

            // 테이블 목록 조회
            List<String> tables = new ArrayList<>();
            ResultSet rs = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
            info.put("tables", tables);

            info.put("message", "H2 database is running and accessible");
            info.put("consoleNote", "H2 Console at /h2-console may not be available in Spring Boot 4.0. Use this endpoint to verify database connectivity.");

        } catch (Exception e) {
            info.put("error", e.getMessage());
        }
        return info;
    }
}
