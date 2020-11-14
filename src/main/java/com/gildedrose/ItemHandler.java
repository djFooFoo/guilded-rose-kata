package com.gildedrose;

public interface ItemHandler {
    default void updateSellIn(Item item) {
        item.decrementSellIn();
    }

    default void updateQuality(Item item) {
        decreaseQuality(item);
        if (item.sellByDateHasPassed()) {
            decreaseQuality(item);
        }
    }

    default void update(Item item) {
        updateSellIn(item);
        updateQuality(item);
    }

    private void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.decrementQuality();
        }
    }
}
