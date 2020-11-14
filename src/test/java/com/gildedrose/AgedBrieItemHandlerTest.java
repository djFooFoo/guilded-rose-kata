package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AgedBrieItemHandlerTest {
    @Test
    void givenAgedBrieSellInValueDecrements() {
        Item item = new Item("Aged Brie", 19, 22);

        ItemHandler itemHandler = new AgedBrieItemHandler();

        itemHandler.update(item);

        assertThat(item.sellIn).isEqualTo(18);
    }

    @Test
    void givenAgedBrieQualityRaisesByOne() {
        Item item = new Item("Aged Brie", 30, 40);

        ItemHandler itemHandler = new AgedBrieItemHandler();

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(41);
    }

    @Test
    void givenAgedBrieQualityNeverRaisesAbove50() {
        Item item = new Item("Aged Brie", 30, 50);

        ItemHandler itemHandler = new AgedBrieItemHandler();

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(50);
    }

    @Test
    void givenSellByDateHasPassedAgedBrieQualityRaisesTwiceAsFast() {
        Item item = new Item("Aged Brie", 0, 30);

        ItemHandler itemHandler = new AgedBrieItemHandler();

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(32);
    }
}
