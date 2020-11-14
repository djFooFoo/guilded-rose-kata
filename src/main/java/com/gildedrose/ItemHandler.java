package com.gildedrose;

public interface ItemHandler {
    default void update(Item item) {
        item.decrementSellIn();
        decreaseQuality(item);
        if (item.sellByDateHasPassed()) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.decrementQuality();
        }
    }
}
