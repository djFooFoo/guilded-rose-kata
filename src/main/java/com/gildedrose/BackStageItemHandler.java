package com.gildedrose;

public class BackStageItemHandler implements ItemHandler {
    @Override
    public void updateQuality(UpdateItemCommand updateItemCommand) {
        updateItemCommand.raiseQuality();

        if (updateItemCommand.getSellIn() <= 10) {
            updateItemCommand.raiseQuality();
        }

        if (updateItemCommand.getSellIn() <= 5) {
            updateItemCommand.raiseQuality();
        }

        if (updateItemCommand.sellByDateHasPassed()){
            updateItemCommand.dropQualityToZero();
        }
    }

}
