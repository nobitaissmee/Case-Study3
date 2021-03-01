package model;

public class StatisticDTO {
    private Category category;
    private int counter;

    public StatisticDTO(Category category, int counter) {
        this.category = category;
        this.counter = counter;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "StatisticDTO{" +
                "category=" + category +
                ", counter=" + counter +
                '}';
    }
}
