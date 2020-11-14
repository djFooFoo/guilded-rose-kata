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
}
