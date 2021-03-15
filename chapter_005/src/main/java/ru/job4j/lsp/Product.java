package ru.job4j.lsp;

public class Product {

    private Double price;

    public Product(Double price) {
        this.price = price;
    }

    public void setPrice(Double price) throws Exception {
        if (price < 0) {
            throw new Exception("Цена меньше 0");
        }
        this.price = price;
    }
}
