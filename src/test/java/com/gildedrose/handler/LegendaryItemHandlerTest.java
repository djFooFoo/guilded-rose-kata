package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.UpdateItemCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LegendaryItemHandlerTest {
    @Test
    void givenLegendaryItemSellInDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 19, 22);

        ItemHandler itemHandler = new LegendaryItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.sellIn).isEqualTo(19);
    }

    @Test
    void givenLegendaryItemQualityDoesNotChange() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 19, 80);

        ItemHandler itemHandler = new LegendaryItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(80);
    }
}
