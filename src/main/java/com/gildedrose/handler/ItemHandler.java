package com.gildedrose.handler;

import com.gildedrose.UpdateItemCommand;

public interface ItemHandler {
    default void updateSellIn(UpdateItemCommand updateItemCommand) {
        updateItemCommand.lowerSellByDate();
    }

    default void updateQuality(UpdateItemCommand updateItemCommand) {
        updateItemCommand.lowerQuality();
        if (updateItemCommand.sellInDateHasPassed()) {
            updateItemCommand.lowerQuality();
        }
    }

    default void execute(UpdateItemCommand updateItemCommand) {
        updateSellIn(updateItemCommand);
        updateQuality(updateItemCommand);
    }

}
