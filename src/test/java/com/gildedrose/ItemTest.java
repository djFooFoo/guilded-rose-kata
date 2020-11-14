package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {
    @Test
    void incrementQualityAddsOne() {
        int initialQuality = 2;
        Item item = new Item("item1", 0, initialQuality);

        item.incrementQuality();

        assertThat(item.getQuality()).isEqualTo(initialQuality + 1);
    }

    @Test
    void decrementQualityAddsOne() {
        int initialQuality = 2;
        Item item = new Item("item1", 0, initialQuality);

        item.decrementQuality();

        assertThat(item.getQuality()).isEqualTo(initialQuality - 1);
    }

    @Test
    void resetQualityResetsToZero() {
        Item item = new Item("item1", 0, 3);

        item.resetQuality();

        assertThat(item.getQuality()).isEqualTo(0);
    }
}
