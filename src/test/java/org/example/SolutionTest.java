package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    static Solution solution;

    int result, id;
    static List<Employee> employees;
    static List<Integer> subordinates;

    Employee e1,e2,e3;

    @BeforeAll
    static void setup(){

        solution = new Solution();
        employees = new ArrayList<>();
        subordinates = new ArrayList<>();
    }

    @AfterEach
    void after(){

        employees.clear();
        subordinates.clear();
    }

    @Test
    public void twoEmployees(){

        result =-3;
        id = 5;
        subordinates.add(5);
        e1 = new Employee(1,5, subordinates);
        e2 = new Employee(5,-3, new ArrayList<>());
        employees.add(e1);
        employees.add(e2);

        assertEquals(result, solution.getImportance(employees, id));
    }

    @Test
    public void threeEmployees(){

        result = 11;
        id = 1;
        subordinates.add(2);
        subordinates.add(3);
        e1 = new Employee(1,5, subordinates);
        e2 = new Employee(2,3, new ArrayList<>());
        e3 = new Employee(3,3, new ArrayList<>());
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

        assertEquals(result, solution.getImportance(employees, id));
    }
}
