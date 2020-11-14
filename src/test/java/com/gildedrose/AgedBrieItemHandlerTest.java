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
}
