package com.gildedrose.handler;

import com.gildedrose.UpdateItemCommand;

public class BackStageItemHandler implements ItemHandler {
    @Override
    public void updateQuality(UpdateItemCommand updateItemCommand) {
        updateItemCommand.raiseQuality();

        if (updateItemCommand.getSellByDate() <= 10) {
            updateItemCommand.raiseQuality();
        }

        if (updateItemCommand.getSellByDate() <= 5) {
            updateItemCommand.raiseQuality();
        }

        if (updateItemCommand.sellInDateHasPassed()) {
            updateItemCommand.dropQualityToZero();
        }
    }

}
