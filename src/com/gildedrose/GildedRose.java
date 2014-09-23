package com.gildedrose;

class GildedRose {
    Item[] items; // change this type - to objects that inmplement my new interface 

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	
        	// Goal: items[0].updateSellinAndQuality();

            if (!items[i].name.equals("Aged Brie") // filter out brie
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // filter out Sulfuras
                if (items[i].quality > 0) { // Quality can never be negative
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // filter out Sulfuras
                        items[i].quality = items[i].quality - 1; // decrement quality
                    }
                }
            } else {
                if (items[i].quality < 50) { // quality is less than 50 (can never be more than 50)
                    items[i].quality = items[i].quality + 1; // increment quality

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // Backstage passes
                        if (items[i].sellIn < 11) { // Quality increases by 2 when there are 10 days or less
                            if (items[i].quality < 50) { // quality is less than 50 (can never be more than 50)
                               items[i].quality = items[i].quality + 1; // increment quality
                            }
                        }

                        if (items[i].sellIn < 6) { // Quality increases by 3 when there are 5 days or less
                            if (items[i].quality < 50) { // quality is less than 50 (can never be more than 50)
                                items[i].quality = items[i].quality + 1; // increment quality
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // filter out Sulfuras
                items[i].sellIn = items[i].sellIn - 1; // decrement sellIn
            }

            if (items[i].sellIn < 0) { // negative sellin items (quality should degrade twice as fast
                if (!items[i].name.equals("Aged Brie")) { // filter out brie
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) { // filter out passes
                        if (items[i].quality > 0) { // quality is still non-negative
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // filter out Sulfuras
                                items[i].quality = items[i].quality - 1; // decrement this item's quality
                            }
                        }
                    } else { // quality degrades twice as fast at this point
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else { // brie
                    if (items[i].quality < 50) { // quality is never more than 50
                        items[i].quality = items[i].quality + 1; // increment quality
                    }
                }
            }
        }
    }
}
