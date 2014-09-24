package com.gildedrose;

public class BackstagePass extends QualityItem {
	
	public BackstagePass(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateSellinAndQuality() {
		if (isQualityUnder50()) { // quality is less than 50 (can never be more than 50)
		    increaseItemQualityBy(1); // increment quality

		    if (isSellinWithin(10)) { // Quality increases by 2 when there are 10 days or less
		        if (isQualityUnder50()) { // quality is less than 50 (can never be more than 50)
		           increaseItemQualityBy(1); // increment quality
		        }
		    }

		    if (isSellinWithin(5)) { // Quality increases by 3 when there are 5 days or less
		        if (isQualityUnder50()) { // quality is less than 50 (can never be more than 50)
		            increaseItemQualityBy(1); // increment quality
		        }
		    }
		}
		
		decreaseSellinBy(1); // decrement sellIn
		
		if (hasSellinDatePassed()) { // negative sellin items (quality should degrade twice as fast
			decreaseItemQualityBy(this.quality); // backstage pass - quality degrades twice as fast after thow show down to zero
		}
	}
}
