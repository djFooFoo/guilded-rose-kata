package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemHandlerFactoryTest {
    @Test
    public void givenAgedBrieReturnsAgedBrieItemHandler() {
        ItemHandler itemHandler = ItemHandlerFactory.getItemHandlerForName("Aged Brie");

        assertThat(itemHandler).isInstanceOf(AgedBrieItemHandler.class);
    }

    @Test
    public void givenBackStageReturnsBackStageItemHandler() {
        ItemHandler itemHandler = ItemHandlerFactory.getItemHandlerForName("Backstage passes to a TAFKAL80ETC concert");

        assertThat(itemHandler).isInstanceOf(BackStageItemHandler.class);
    }

    @Test
    public void givenSulfurasGivesLegendaryItemHandler() {
        ItemHandler itemHandler = ItemHandlerFactory.getItemHandlerForName("Sulfuras, Hand of Ragnaros");

        assertThat(itemHandler).isInstanceOf(LegendaryItemHandler.class);
    }

    @Test
    public void givenOtherTextReturnsItemHandler() {
        ItemHandler itemHandler = ItemHandlerFactory.getItemHandlerForName("other text");

        assertThat(itemHandler).isInstanceOf(ItemHandler.class);
    }
}
