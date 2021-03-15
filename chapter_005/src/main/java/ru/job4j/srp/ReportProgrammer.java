package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {

    private Store store;

    public ReportProgrammer(MemStore store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<p>Name; Hired; Fired; Salary;</p>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>");
        }
        return text.toString();
    }
}
