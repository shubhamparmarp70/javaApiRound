package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ApiService {

    public void executeFlow() {

        System.out.println("Application Running Successfully");

        // STEP 1 → SQL Query

        String finalSqlQuery = """
                SELECT e.name AS employee_name,
                       d.department_name,
                       e.salary
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.id
                WHERE e.salary = (
                    SELECT MAX(e2.salary)
                    FROM employees e2
                    WHERE e2.department_id = e.department_id
                );
                """;

        // STEP 2 → Print Query

        System.out.println("Final SQL Query:");

        System.out.println(finalSqlQuery);
    }
}