package com.gildedrose.handler;

import com.gildedrose.UpdateItemCommand;

public class AgedBrieItemHandler implements ItemHandler {
    @Override
    public void updateQuality(UpdateItemCommand updateItemCommand) {
        updateItemCommand.raiseQuality();

        if (updateItemCommand.sellInDateHasPassed()) {
            updateItemCommand.raiseQuality();
        }
    }

}
