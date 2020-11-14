package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    void incrementQuality() {
        this.quality += 1;
    }

    void decrementQuality() {
        this.quality -= 1;
    }

    void dropQualityToZero() {
        this.quality = 0;
    }

    public int getQuality() {
        return this.quality;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public boolean sellByDateHasPassed() {
        return this.sellIn < 0;
    }

    public boolean hasName(String name) {
        return name.equals(this.name);
    }

    void decrementSellIn() {
        this.sellIn -= 1;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
