package com.gildedrose.handler;

import com.gildedrose.Item;
import com.gildedrose.UpdateItemCommand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConjuredItemHandlerTest {

    @Test
    void itemQualityDecreasesTwiceAsFast() {
        Item item = new Item("an item", 19, 22);

        ItemHandler itemHandler = new ConjuredItemHandler();

        itemHandler.execute(new UpdateItemCommand(item));

        assertThat(item.quality).isEqualTo(20);
    }
}
