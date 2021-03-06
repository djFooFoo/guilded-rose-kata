package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.UpdateItemCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackStageItemHandlerTest {
    @Test
    void givenBackStagePassSellInValueDecrements() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 19, 22);

        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.sellIn).isEqualTo(18);
    }

    @Test
    void givenBackStagePassQualityRaisesByOne() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 19, 22);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(23);
    }

    @Test
    void givenBackStagePassQualityWithSellInIs10DaysOrLessRaisesByTwo() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 22);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(24);
    }

    @Test
    void givenBackStagePassQualityWithSellInIs5DaysOrLessRaisesByThree() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 22);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(25);
    }

    @Test
    void givenBackStagePassQualityWithSellByDateHasPassedDropsTo0() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 22);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void givenBackStagePassQualityNeverRaisesAbove50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(50);
    }
}
