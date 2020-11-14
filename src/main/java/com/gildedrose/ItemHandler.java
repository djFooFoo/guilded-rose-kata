package com.gildedrose;

public interface ItemHandler {
    default void update(Item item) {
        item.decrementSellIn();
        item.decrementQuality();
    }
}
