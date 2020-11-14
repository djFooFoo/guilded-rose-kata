package com.gildedrose;

public class UpdateItemCommand {
    private final Item item;

    UpdateItemCommand(Item item) {
        this.item = item;
    }

    public void raiseQuality() {
        if(item.quality < 50){
            item.quality++;
        }
    }

    public void decrementQuality() {
        item.quality--;
    }

    public void decrementSellIn() {
        item.sellIn--;
    }

    public boolean sellByDateHasPassed() {
        return item.sellIn < 0;
    }

    public int getQuality() {
        return item.quality;
    }

    public void dropQualityToZero() {
        item.quality = 0;
    }

    public int getSellIn() {
        return item.sellIn;
    }
}
