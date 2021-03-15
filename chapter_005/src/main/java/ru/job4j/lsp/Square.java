package ru.job4j.lsp;

public class Square extends Rectangle {

    @Override
    public void setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h);
    }

    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }
}
