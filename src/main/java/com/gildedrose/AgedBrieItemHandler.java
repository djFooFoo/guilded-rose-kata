package com.gildedrose;

public class AgedBrieItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        item.decrementSellIn();
        item.incrementQuality();
    }
}
