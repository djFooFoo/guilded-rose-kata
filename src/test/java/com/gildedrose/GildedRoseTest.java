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
    void givenBackStagePassSellInValueDecrements() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 19, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);

        assertThat(item.getSellIn()).isEqualTo(18);
    }

    @Test
    void givenBackStagePassQualityRaisesByOne() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 19, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(23);
    }

    @Test
    void givenBackStagePassQualityWithSellInIs10DaysOrLessRaisesByTwo() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(24);
    }

    @Test
    void givenBackStagePassQualityWithSellInIs5DaysOrLessRaisesByThree() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(25);
    }

    @Test
    void givenBackStagePassQualityWithSellByDateHasPassedDropsTo0() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 22)
        };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        Item item = app.getItem(0);

        assertThat(item.getQuality()).isEqualTo(0);
    }
}
