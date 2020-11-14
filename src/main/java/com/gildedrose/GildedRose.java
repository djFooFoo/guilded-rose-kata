package com.gildedrose;

class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    public void updateItem(Item item) {
        if ("Aged Brie".equals(item.name)) {
            ItemHandler itemHandler = new AgedBrieItemHandler();
            UpdateItemCommand itemDecorator = new UpdateItemCommand(item);
            itemHandler.execute(itemDecorator);
        } else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            ItemHandler itemHandler = new LegendaryItemHandler();
            UpdateItemCommand itemDecorator = new UpdateItemCommand(item);
            itemHandler.execute(itemDecorator);
        } else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            ItemHandler itemHandler = new BackStageItemHandler();
            UpdateItemCommand itemDecorator = new UpdateItemCommand(item);
            itemHandler.execute(itemDecorator);
        } else {
            ItemHandler itemHandler = new ItemHandler() {};
            UpdateItemCommand itemDecorator = new UpdateItemCommand(item);
            itemHandler.execute(itemDecorator);
        }
    }
}
