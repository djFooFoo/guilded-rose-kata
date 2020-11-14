package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemHandlerTest {
    @Test
    void givenItemSellInValueDecrements() {
        Item item = new Item("an item", 19, 22);

        ItemHandler itemHandler = new ItemHandler(){};

        itemHandler.update(item);

        assertThat(item.getSellIn()).isEqualTo(18);
    }

    @Test
    void givenItemQualityDecreases() {
        Item item = new Item("an item", 19, 22);

        ItemHandler itemHandler = new ItemHandler(){};

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(21);
    }

    @Test
    void givenItemQualityAndSellByDateHasPassedDecreasesTwiceAsFast() {
        Item item = new Item("an item", -1, 22);

        ItemHandler itemHandler = new ItemHandler(){};

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(20);
    }

    @Test
    void givenItemQualityDecreasesNeverBelowZero() {
        Item item = new Item("an item", -1, 0);

        ItemHandler itemHandler = new ItemHandler(){};

        itemHandler.update(item);

        assertThat(item.getQuality()).isEqualTo(0);
    }
}
