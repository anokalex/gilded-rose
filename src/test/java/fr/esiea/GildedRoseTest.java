package fr.esiea;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseTest{

	@Test
	public void non_specific_object_quality_and_price_decrease_by_one(){
		Item item = new Item("apple", 2, 10);
		Item[] items = new Item[]{item};
		
		GildedRose tavern = new GildedRose(items);
		
		tavern.updateQuality();
		
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(item.getQuality()).as("Apple quality").isEqualTo(9);
		
		softly.assertThat(item.getSellIn()).as("Apple price").isEqualTo(1);
		
		softly.assertAll();
	}
	
	 @Test
    public void non_specific_object_sellin_negative() {
        Item item = new Item("apple", 0, 10);
		Item[] items = new Item[]{item};
		
		GildedRose tavern = new GildedRose(items);
		
		tavern.updateQuality();
		
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(item.getQuality()).as("Apple quality").isEqualTo(8);
		
		softly.assertThat(item.getSellIn()).as("Apple price").isEqualTo(-1);
		
		softly.assertAll();
    }
	
	@Test
    public void aged_brie_quality_and_sellin() {
        Item item = new Item("Aged Brie", 0, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
		
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality()).as("Aged Brie quality").isEqualTo(12);

        solftly.assertThat(item.getSellIn()).as("Aged Brie price").isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void tafkal80etc_quality_and_sellin() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
		
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality()).as("TAFKAL80ETC quality").isEqualTo(0);

        solftly.assertThat(item.getSellIn()).as("TAFKAL80ETC price").isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void non_specific_object_to_string() {
        Item item = new Item("Apple", 10, 10);
        SoftAssertions solftly = new SoftAssertions();

        solftly.assertThat(item.toString()).as("Apple toString method").isEqualTo("Apple, 10, 10");

        solftly.assertAll();
    }

    @Test
    public void sulfuras_test() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        Item[] items = new Item[]{item};

        GildedRose tavern = new GildedRose(items);
		
        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality()).as("Sulfuras, Hand of Ragnaros quality").isEqualTo(10);

        solftly.assertThat(item.getSellIn()).as("TAFKAL80ETC price").isEqualTo(10);

        solftly.assertAll();
    }
}
