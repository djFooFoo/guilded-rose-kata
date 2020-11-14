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

        app.updateQuality();

        Item item1 = app.getItem(0);
        assertThat(item1.quality).isEqualTo(1);
        assertThat(item1.sellIn).isEqualTo(0);
        Item item2 = app.getItem(1);
        assertThat(item2.quality).isEqualTo(3);
        assertThat(item2.sellIn).isEqualTo(2);
    }

    @Test
    void givenPositiveSelInAgedBrieQualityRaisesByOne() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 30, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.quality).isEqualTo(41);
    }

    @Test
    void givenPositiveSelInAgedBrieQualityNeverGoesAbove50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 30, 50)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void givenNegativeOrZeroSelInAgedBrieItemQualityIncreasesTwiceAsFast() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 40)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.quality).isEqualTo(42);
    }

    @Test
    void givenNegativeOrZeroSelInAgedBrieItemQualityNeverGoesAbove50() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 0, 49)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void agedBrieSellInDecreasesByOne() {
        Item[] items = new Item[] {
                new Item("Aged Brie", 23, 44)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.sellIn).isEqualTo(22);
    }

    @Test
    void legendaryItemSellInDoesNotChange() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 23, 80)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.sellIn).isEqualTo(23);
    }

    @Test
    void legendaryItemQualityDoesNotChange() {
        Item[] items = new Item[] {
                new Item("Sulfuras, Hand of Ragnaros", 23, 80)
        };

        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);
        assertThat(item.quality).isEqualTo(80);
    }
}
