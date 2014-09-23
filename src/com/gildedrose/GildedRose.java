package com.gildedrose;

class GildedRose {
    Item[] items; // change this type - to objects that implement my new interface 

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	
        	// Goal: items[0].updateSellinAndQuality();

            if (!isBrie(i) && !isBackstagePass(i)) { // filter out brie and filter out Sulfuras
                if (isQualityPositive(i)) { // Quality can never be negative
                    if (!isSulfuras(i)) { // filter out Sulfuras
                        decreaseItemQuality(i); // decrement quality
                    }
                }
            } else {
                if (isQualityUnder50(i)) { // quality is less than 50 (can never be more than 50)
                    increaseItemQuality(i); // increment quality

                    if (isBackstagePass(i)) { // Backstage passes
                        if (isSellinWithin10(i)) { // Quality increases by 2 when there are 10 days or less
                            if (isQualityUnder50(i)) { // quality is less than 50 (can never be more than 50)
                               increaseItemQuality(i); // increment quality
                            }
                        }

                        if (isSellinWithin5(i)) { // Quality increases by 3 when there are 5 days or less
                            if (isQualityUnder50(i)) { // quality is less than 50 (can never be more than 50)
                                increaseItemQuality(i); // increment quality
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(i)) { // filter out Sulfuras
                decreaseSellin(i); // decrement sellIn
            }

            if (hasSellinDatePassed(i)) { // negative sellin items (quality should degrade twice as fast
                if (!isBrie(i)) { // filter out brie
                    if (!isBackstagePass(i)) { // filter out passes
                        if (isQualityPositive(i)) { // quality is still non-negative
                            if (!isSulfuras(i)) { // filter out Sulfuras
                                decreaseItemQuality(i); // decrement this item's quality
                            }
                        }
                    } else { // quality degrades twice as fast at this point
                        decreaseQualityTwice(i);
                    }
                } else { // brie
                    if (isQualityUnder50(i)) { // quality is never more than 50
                        increaseItemQuality(i); // increment quality
                    }
                }
            }
        }
    }

	private int decreaseQualityTwice(int i) {
		items[i].quality = items[i].quality - items[i].quality;
		
		if (items[i].quality < 0) {
			items[i].quality = 0;
		} 
		
		return items[i].quality;
	}

	private boolean hasSellinDatePassed(int i) {
		return items[i].sellIn < 0;
	}

	private int decreaseSellin(int i) {
		return items[i].sellIn = items[i].sellIn - 1;
	}

	private boolean isSellinWithin5(int i) {
		return items[i].sellIn < 6;
	}

	private boolean isSellinWithin10(int i) {
		return items[i].sellIn < 11;
	}

	private int increaseItemQuality(int i) {
		return items[i].quality = items[i].quality + 1;
	}

	private boolean isQualityUnder50(int i) {
		return items[i].quality < 50;
	}

	private int decreaseItemQuality(int i) {
		return items[i].quality = items[i].quality - 1;
	}

	private boolean isSulfuras(int i) {
		return items[i].name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isQualityPositive(int i) {
		return items[i].quality > 0;
	}

	private boolean isBackstagePass(int i) {
		return items[i].name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean isBrie(int i) {
		return items[i].name.equals("Aged Brie");
	}
}
