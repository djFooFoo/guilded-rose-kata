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
        if ("Aged Brie".equals(item.name)) {
            ItemHandler itemHandler = new AgedBrieItemHandler();
            itemHandler.update(item);
        } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            ItemHandler itemHandler = new LegendaryItemHandler();
            itemHandler.update(item);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            ItemHandler itemHandler = new BackStageItemHandler();
            itemHandler.update(item);
        } else {
            ItemHandler itemHandler = new ItemHandler() {};
            itemHandler.update(item);
        }
    }
}
