package com.gildedrose;

public interface ItemHandler {
    default void updateSellIn(UpdateItemCommand updateItemCommand) {
        updateItemCommand.decrementSellIn();
    }

    default void updateQuality(UpdateItemCommand updateItemCommand) {
        updateItemCommand.lowerQuality();
        if (updateItemCommand.sellByDateHasPassed()) {
            updateItemCommand.lowerQuality();
        }
    }

    default void execute(UpdateItemCommand updateItemCommand) {
        updateSellIn(updateItemCommand);
        updateQuality(updateItemCommand);
    }

}
