package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportHR implements Report {

    private Store store;

    public ReportHR(MemStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;");
        List<Employee> employees = store.findBy(filter);
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        for (Employee employee : employees) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
