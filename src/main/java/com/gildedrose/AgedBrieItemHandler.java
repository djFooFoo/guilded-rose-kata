package com.gildedrose;

public class AgedBrieItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        item.decrementSellIn();
        raiseQuality(item);
    }

    private void raiseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }
    }
}
