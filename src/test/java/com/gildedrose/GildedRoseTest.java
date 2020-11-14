package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void updatesMultipleItems() {
        Item[] items = new Item[] {
                new Item("item1", 1, 2),
                new Item("item2", 3, 4)
        };
        GildedRose app = new GildedRose(items);

        app.updateItems();

        Item item1 = app.getItem(0);
        assertThat(item1.quality).isEqualTo(1);
        assertThat(item1.sellIn).isEqualTo(0);
        Item item2 = app.getItem(1);
        assertThat(item2.quality).isEqualTo(3);
        assertThat(item2.sellIn).isEqualTo(2);
    }

    @Test
    void givenItemSellInValueDecrements() {
        Item[] items = new Item[] {
                new Item("an item", 19, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateItems();

        Item item = app.getItem(0);

        assertThat(item.getSellIn()).isEqualTo(18);
    }

    @Test
    void givenItemQualityDecreases() {
        Item[] items = new Item[] {
                new Item("an item", 19, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateItems();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(21);
    }

    @Test
    void givenItemQualityWithNegativeSellInDecreasesTwiceAsFast() {
        Item[] items = new Item[] {
                new Item("an item", -1, 5)
        };
        GildedRose app = new GildedRose(items);

        app.updateItems();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(3);
    }

    @Test
    void givenItemQualityDecreasesNeverBelowZero() {
        Item[] items = new Item[] {
                new Item("an item", -1, 0)
        };
        GildedRose app = new GildedRose(items);

        app.updateItems();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(0);
    }
}
