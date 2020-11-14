package com.gildedrose;

public class BackStageItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        item.decrementSellIn();
        item.incrementQuality();
        if (item.getSellIn() < 11) {
            item.incrementQuality();
        }
    }
}
