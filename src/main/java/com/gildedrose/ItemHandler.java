package com.gildedrose;

public interface ItemHandler {
    default void updateSellIn(UpdateItemCommand updateItemCommand) {
        updateItemCommand.decrementSellIn();
    }

    default void updateQuality(UpdateItemCommand updateItemCommand) {
        decreaseQuality(updateItemCommand);
        if (updateItemCommand.sellByDateHasPassed()) {
            decreaseQuality(updateItemCommand);
        }
    }

    default void execute(UpdateItemCommand updateItemCommand) {
        updateSellIn(updateItemCommand);
        updateQuality(updateItemCommand);
    }

    private void decreaseQuality(UpdateItemCommand updateItemCommand) {
        if (updateItemCommand.getQuality() > 0) {
            updateItemCommand.decrementQuality();
        }
    }
}
