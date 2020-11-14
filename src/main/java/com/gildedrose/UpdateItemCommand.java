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

    public void lowerQuality() {
        if(item.quality > 0){
            item.quality--;
        }
    }

    public void lowerSellByDate() {
        item.sellIn--;
    }

    public boolean sellInDateHasPassed() {
        return item.sellIn < 0;
    }

    public void dropQualityToZero() {
        item.quality = 0;
    }

    public int getSellByDate() {
        return item.sellIn;
    }
}
