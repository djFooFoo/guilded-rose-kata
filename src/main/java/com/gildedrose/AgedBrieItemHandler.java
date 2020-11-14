package com.gildedrose;

public class AgedBrieItemHandler implements ItemHandler {
    @Override
    public void updateQuality(Item item) {
        raiseQuality(item);

        if(item.sellByDateHasPassed()){
            raiseQuality(item);
        }
    }

    private void raiseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }
    }
}
