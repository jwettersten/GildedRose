package com.gildedrose;

class GildedRose {
    Item[] items; // change this type - to objects that implement my new interface 

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	
        	// Ultimate goal: items[0].updateSellinAndQuality();
        	// TDD goal: extract methods and organize into types before creating new subtype 
        	// Extracting methods
        	// Reorganizing methods to represent behaviors for each type 	
        	// Replace conditional with polymorphism

        	if (isBrie(i)) { // Brie
        		 
        		updateBrieSellinAndQuality(i);
        	
        	} else if (isBackstagePass(i)) { // Backstage pass
        		
        		updateBackstagePassSellinAndQuality(i);
        	
        	} else if (!isSulfuras(i)) { // everything else except for Sulfuras
        		
        		updateGeneralSellinAndQuality(i);
        	}
        }
    }

	private void updateGeneralSellinAndQuality(int i) {
		if (isQualityPositive(i)) {
			decreaseItemQuality(i);
		}
		
		decreaseSellin(i); // decrement sellIn
		
		if (hasSellinDatePassed(i)) {
			if (isQualityPositive(i)) { // quality is still non-negative
				decreaseItemQuality(i); // decrement this item's quality
			}
		}
	}

	private void updateBackstagePassSellinAndQuality(int i) {
		if (isQualityUnder50(i)) { // quality is less than 50 (can never be more than 50)
		    increaseItemQuality(i); // increment quality

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
		
		decreaseSellin(i); // decrement sellIn
		
		if (hasSellinDatePassed(i)) { // negative sellin items (quality should degrade twice as fast
			decreaseQualityTwice(i); // backstage pass - quality degrades twice as fast after thow show down to zero
		}
	}

	private void updateBrieSellinAndQuality(int i) {
		if (isQualityUnder50(i)) { // quality is less than 50 (can never be more than 50)
		     increaseItemQuality(i); // increment quality
		 }
		 
		 decreaseSellin(i); // decrement sellIn
		 
		 if (hasSellinDatePassed(i)) {
			 if (isQualityUnder50(i)) { // quality is never more than 50
		         increaseItemQuality(i); // increment quality
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

	private int decreaseItemQuality(int i) {
		return items[i].quality = items[i].quality - 1;
	}

	private boolean isSulfuras(int i) {
		return items[i].name.equals("Sulfuras, Hand of Ragnaros");
	}

	private boolean isQualityUnder50(int i) {
		return items[i].quality < 50;
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
