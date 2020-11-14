package com.gildedrose;

public class BackStageItemHandler implements ItemHandler {
    @Override
    public void updateQuality(UpdateItemCommand updateItemCommand) {
        raiseQuality(updateItemCommand);

        if (updateItemCommand.getSellIn() <= 10) {
            raiseQuality(updateItemCommand);
        }

        if (updateItemCommand.getSellIn() <= 5) {
            raiseQuality(updateItemCommand);
        }

        if (updateItemCommand.sellByDateHasPassed()){
            updateItemCommand.dropQualityToZero();
        }
    }

    private void raiseQuality(UpdateItemCommand item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }
    }
}
