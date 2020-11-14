package com.gildedrose;

public class BackStageItemHandler implements ItemHandler {
    @Override
    public void update(Item item) {
        item.decrementSellIn();
        raiseQuality(item);

        if (item.getSellIn() <= 10) {
            raiseQuality(item);
        }

        if (item.getSellIn() <= 5) {
            raiseQuality(item);
        }

        if (item.sellByDateHasPassed()){
            item.dropQualityToZero();
        }
    }

    private void raiseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }
    }
}
