package ru.job4j.jdbc;

import org.junit.Test;

import java.io.FileReader;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TableEditorTest {
    @Test
    public void checkTableEditor() throws Exception {
        final Properties properties = new Properties();
        properties.load(new FileReader("./src/main/resources/app.properties"));
        try (TableEditor tableEditor = new TableEditor(properties)) {
            tableEditor.createTable("test_table");
            tableEditor.addColumn("test_table", "name", "text");
            tableEditor.addColumn("test_table", "amount1", "int");
            tableEditor.addColumn("test_table", "amount2", "int");
            tableEditor.addColumn("test_table", "price", "int");
            tableEditor.renameColumn("test_table", "amount1", "amount");
            tableEditor.dropColumn("test_table", "amount2");

            StringBuilder expected = new StringBuilder();
            expected.append(String.format("%-15s %-15s%n", "column", "type"));
            expected.append(String.format("%-15s %-15s%n", "name", "text"));
            expected.append(String.format("%-15s %-15s%n", "amount", "int4"));
            expected.append(String.format("%-15s %-15s%n", "price", "int4"));
            assertThat(tableEditor.getScheme("test_table"), is(expected.toString()));
            tableEditor.dropTable("test_table");
            assertThat(tableEditor.getScheme("test_table"),
                    is(String.format("%-15s %-15s%n", "column", "type")));
        }
    }
}