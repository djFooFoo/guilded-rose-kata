package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackStageItemHandlerTest {
    @Test
    void givenBackStagePassSellInValueDecrements() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 19, 22);

        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.update(item);

        assertThat(item.getSellIn()).isEqualTo(18);
    }

    @Test
    void givenBackStagePassQualityRaisesByOne() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 19, 22);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(23);
    }

    @Test
    void givenBackStagePassQualityWithSellInIs10DaysOrLessRaisesByTwo() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 22);
        ItemHandler itemHandler = new BackStageItemHandler();

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(24);
    }
}
