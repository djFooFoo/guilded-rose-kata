package com.gildedrose;

class GildedRose {
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item getItem(int zeroBasedIndex) {
        return items[zeroBasedIndex];
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityItem(item);
        }
    }

    public void updateQualityItem(Item item) {
        if("Aged Brie".equals(item.name)){
            ItemHandler itemHandler = new AgedBrieItemHandler();
            itemHandler.update(item);
        } else if("Sulfuras, Hand of Ragnaros".equals(item.name)){
            ItemHandler itemHandler = new LegendaryItemHandler();
            itemHandler.update(item);
        } else if("Backstage passes to a TAFKAL80ETC concert".equals(item.name)){
            ItemHandler itemHandler = new BackStageItemHandler();
            itemHandler.update(item);
        }
        else {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }
        }
    }
}
