package com.gildedrose.handler;

import com.gildedrose.UpdateItemCommand;

public class ConjuredItemHandler implements ItemHandler {
    @Override
    public void updateQuality(UpdateItemCommand updateItemCommand) {
        ItemHandler.super.updateQuality(updateItemCommand);
        ItemHandler.super.updateQuality(updateItemCommand);
    }
}
