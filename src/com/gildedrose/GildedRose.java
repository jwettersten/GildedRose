package com.gildedrose;

class GildedRose {
    QualityItem[] items; 

    public GildedRose(QualityItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	items[i].updateSellinAndQuality();
        }
    }
}
