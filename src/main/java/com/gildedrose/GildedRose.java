package com.gildedrose;

import com.gildedrose.handler.ItemHandler;

class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            ItemHandler itemHandler = ItemHandlerFactory.getItemHandlerForName(item.name);
            UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);
            itemHandler.execute(updateItemCommand);
        }
    }

}
