package com.gildedrose;

import com.gildedrose.handler.*;

import java.util.HashMap;
import java.util.Map;

public class ItemHandlerFactory {

    private static final ItemHandler DEFAULT_ITEM_HANDLER = new ItemHandler() {
    };
    private static final Map<String, ItemHandler> ITEM_HANDLERS = new HashMap<>();

    private ItemHandlerFactory() {
    }

    static {
        ITEM_HANDLERS.put("Aged Brie", new AgedBrieItemHandler());
        ITEM_HANDLERS.put("Backstage passes to a TAFKAL80ETC concert", new BackStageItemHandler());
        ITEM_HANDLERS.put("Sulfuras, Hand of Ragnaros", new LegendaryItemHandler());
        ITEM_HANDLERS.put("Conjured Mana Cake", new ConjuredItemHandler());
    }

    public static ItemHandler getItemHandlerForName(String name) {
        return ITEM_HANDLERS.getOrDefault(name, DEFAULT_ITEM_HANDLER);
    }
}
