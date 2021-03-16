package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportJson implements Report {

    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("{\n");
        text.append("\"employee\":{\n");
        for (Employee employee : store.findBy(filter)) {
            text.append("\"name\":\"").append(employee.getName());
            text.append("\",\n\"hired\":\"").append(employee.getHired());
            text.append("\",\n\"fired\":\"").append(employee.getFired());
            text.append("\",\n\"salary\":\"").append(employee.getSalary());
            text.append("\"\n}");
        }
        text.append("\n}");
        return text.toString();
    }
}