package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public Solution(){

    }

    public int getImportance(List<Employee> employees, int id) {

        return recursionMethod(id, employees.stream().
                collect(Collectors.toMap(e->e.id, e->e)));
    }

    private int recursionMethod(int id, Map<Integer, Employee> directory){
        return  directory.get(id).importance +
                directory.get(id).subordinates
                        .stream()
                        .mapToInt(e -> recursionMethod(e,directory))
                        .sum();
    }
}