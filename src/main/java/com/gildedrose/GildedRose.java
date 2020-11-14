package com.gildedrose;

class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item getItem(int zeroBasedIndex) {
        return items[zeroBasedIndex];
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    public void updateItem(Item item) {
        if (item.hasName("Aged Brie")) {
            ItemHandler itemHandler = new AgedBrieItemHandler();
            itemHandler.update(item);
        } else if (item.hasName("Sulfuras, Hand of Ragnaros")) {
            ItemHandler itemHandler = new LegendaryItemHandler();
            itemHandler.update(item);
        } else if (item.hasName("Backstage passes to a TAFKAL80ETC concert")) {
            ItemHandler itemHandler = new BackStageItemHandler();
            itemHandler.update(item);
        } else {
            ItemHandler itemHandler = new ItemHandler() {};
            itemHandler.update(item);
        }
    }
}
