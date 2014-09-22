package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * Item attribute definitions:
 * Name: name/type of item
 * SellIn: the number of days we have to sell the item
 * Quality: how valuable the item is
 * 
 * Rules:
 * At the end of each day our system lowers both values for every item
 * Once the sell by date has passed, Quality degrades twice as fast
 * The Quality of an item is never negative
 * "Aged Brie" actually increases in Quality the older it gets
 * The Quality of an item is never more than 50
 * "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
 * "Backstage passes", like aged brie, increases in Quality as it's SellIn value approaches; 
 * 	+ Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
 *  + Quality drops to 0 after the concert
*/
public class GildedRoseTest {

	GildedRose app;
	
    // General cases
    @Test
    public void testDecreaseInQualityPerDay() {
    	Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 2);
        
        assertEquals(18, app.items[0].quality);
     
    }
    
	private void updateItemQualityAndSellinPerDay(GildedRose app, int totalDays) {
        for (int day=0; day<totalDays; day++) {
        	app.updateQuality();
        }
	}
    
    @Test
    public void testNonNegativeQualityAfterExpirationPerDay() {
    	Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 7) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 10);
        
        assertEquals(0, app.items[0].quality);
     
    }
    
    @Test
    public void testTwiceAppliedDecreaseInQualityPerDay() {
    	Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 2) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(0, app.items[0].quality);
     
    }
	
	// "Aged Brie"
    @Test
    public void testAgedBrieIncreaseInQualityPerDay() {
    	Item[] items = new Item[] { new Item("Aged Brie", 2, 0) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(1, app.items[0].quality);
    }
    
    @Test
    public void testAgedBrieTwiceAppliedIncreaseInQualityPerDay() {
    	Item[] items = new Item[] { new Item("Aged Brie", 0, 2) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(4, app.items[0].quality);
    }
    
    @Test
    public void testAgedBrieMaxQuality() {
    	Item[] items = new Item[] { new Item("Aged Brie", 2, 10) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 50);
        
        assertEquals(50, app.items[0].quality);
    }
    
    // "Backstage passes"
    @Test
    public void testBackstagePassIncreaseInQualityPerDay() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(21, app.items[0].quality);
    }
    
    @Test
    public void testBackstagePassIncreaseInQualityWithin10DaysOfShow() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(22, app.items[0].quality);
    }
    
    @Test
    public void testBackstagePassIncreaseInQualityWithin5DaysOfShow() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(23, app.items[0].quality);
    }
    
    @Test
    public void testBackstagePassQualityAfterShow() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 1);
        
        assertEquals(0, app.items[0].quality);
    }
    
    // "Sulfuras"
    @Test
    public void testSulfurasNoChangeInQualityPerDay() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 50);
        
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    public void testSulfurasNoChangeInSellinPerDay() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) }; 
        
    	app = new GildedRose(items);
        
        updateItemQualityAndSellinPerDay(app, 50);
        
        assertEquals(0, app.items[0].sellIn);
    }
  
}
