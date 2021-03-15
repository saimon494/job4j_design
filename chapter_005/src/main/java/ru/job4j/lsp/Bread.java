package ru.job4j.lsp;

public class Bread extends Product {

    private Double price;

    public Bread(Double price) {
        super(price);
    }

    @Override
    public void setPrice(Double price) throws Exception {
        if (price < 20) {
            throw new Exception("Слишком низкая цена");
        }
        this.price = price;
    }
}
