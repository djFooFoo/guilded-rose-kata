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

        Item item1 = app.items[0];
        assertThat(item1.quality).isEqualTo(1);
        assertThat(item1.sellIn).isEqualTo(0);
        Item item2 = app.items[1];
        assertThat(item2.quality).isEqualTo(3);
        assertThat(item2.sellIn).isEqualTo(2);
    }
}
