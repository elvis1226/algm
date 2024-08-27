package org.dgf.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployImportance {
    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };

    public static int getImportance(List<Employee> employees, int id) {
        int res = 0;
        Map<Integer, Employee> employeeMap = new HashMap<>();

        Employee  employee = null;
        for (Employee e : employees) {
            if (e.id == id) {
                employee = e;
            }
            employeeMap.put(e.id, e);
        }

        res = DFS(employee, employeeMap);

        return res;
    }

    public static int DFS(Employee employee, Map<Integer, Employee> map) {
        int sum = 0;
        sum += employee.importance;

        for(Integer e : employee.subordinates) {
            sum+= DFS(map.get(e), map);
        }

        return sum;
    }

    public static void main(String[] argvs) {
        Employee employee1 = new Employee(1, 2, List.of(5));
        Employee employee2 = new Employee(5, -3, List.of());
        int id1 = 5;
        int importance1 = getImportance(List.of(employee1, employee2), id1);
        System.out.println(importance1);

        Employee employee3 = new Employee(1, 5, List.of(2, 3));
        Employee employee4 = new Employee(2, 3, List.of());
        Employee employee5 = new Employee(3, 3, List.of());
        int id2 = 1;
        int importance2 = getImportance(List.of(employee3, employee4, employee5), id2);
        System.out.println(importance2);
    }

}
