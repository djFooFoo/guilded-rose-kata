package com.gildedrose;

public class AgedBrieItemHandler implements ItemHandler {
    @Override
    public void updateQuality(UpdateItemCommand updateItemCommand) {
        raiseQuality(updateItemCommand);

        if(updateItemCommand.sellByDateHasPassed()){
            raiseQuality(updateItemCommand);
        }
    }

    private void raiseQuality(UpdateItemCommand item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }
    }
}
