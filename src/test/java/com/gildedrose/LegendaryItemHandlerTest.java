package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryItemHandlerTest {
    @Test
    void givenLegendaryItemSellInDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 19, 22);

        ItemHandler itemHandler = new LegendaryItemHandler();

        itemHandler.update(item);

        assertThat(item.sellIn).isEqualTo(19);
    }
}
