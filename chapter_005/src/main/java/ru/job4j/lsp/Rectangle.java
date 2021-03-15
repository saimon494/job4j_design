package ru.job4j.lsp;

public class Rectangle {

    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDimensions(Rectangle r, int w, int h) {
        r.setWidth(w);
        r.setHeight(h);
    }
}
