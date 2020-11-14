package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateItemCommandTest {

    @Test
    void incrementQualityRaisesQualityByOne() {
        Item item = new Item("bla", 0, 0);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);

        updateItemCommand.raiseQuality();

        assertThat(item.quality).isEqualTo(1);
    }

    @Test
    void decrementQualityLowersQualityByOne() {
        Item item = new Item("bla", 0, 1);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);

        updateItemCommand.decrementQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void decrementSellInLowersSellInByOne() {
        Item item = new Item("bla", 4, 1);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);

        updateItemCommand.decrementSellIn();

        assertThat(item.sellIn).isEqualTo(3);
    }

    @Test
    void sellByDateHasPassedReturnsTrueIfSellInIsLowerThanZero() {
        Item item = new Item("bla", -1, 1);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);

        assertThat(updateItemCommand.sellByDateHasPassed()).isEqualTo(true);
    }

    @Test
    void sellByDateHasPassedReturnsFalseIfSellInIsZeroOrHigher() {
        Item item = new Item("bla", 0, 1);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);

        assertThat(updateItemCommand.sellByDateHasPassed()).isEqualTo(false);
    }

    @Test
    void dropQualityToZeroMakesQualityZero() {
        Item item = new Item("bla", 0, 40);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);
        updateItemCommand.dropQualityToZero();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void qualityOfAnItemIsNeverMoreThan50() {
        Item item = new Item("bla", 0, 50);

        UpdateItemCommand updateItemCommand = new UpdateItemCommand(item);
        updateItemCommand.raiseQuality();

        assertThat(item.quality).isEqualTo(50);
    }
}