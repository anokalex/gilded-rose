package fr.esiea;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //Methode qui update pour Aged Brie
    private void updateAgedBrie(Item i){
        if(i.getQuality() < 50){
            i.incQuality();
        }

        i.decSellIn();

        if(i.getSellIn() < 0 && i.getQuality() < 50){
            i.incQuality();
        }
    }

    //Methode qui update pour TAFKAL80ETC
    private void updateTAFKAL80ETC(Item i){
        if(i.getQuality() < 50){
            i.incQuality();
            if(i.getSellIn() < 11){
                i.incQuality();
            }
            if(i.getSellIn() < 6){
                i.incQuality();
            }
        }

        i.decSellIn();

        if(i.getSellIn() < 0){
            i.setQuality(0);
        }
    }

    //Methode qui update pour n'importe quel item
    private void updateItem(Item i){
        if(i.getQuality() > 0){
            i.decQuality();
        }

        i.decSellIn();

        if(i.getSellIn() < 0 && i.getQuality() > 0){
            i.decQuality();
        }
    }

    public Item update(Item i){
        if(i.getName().equals("Aged Brie")){
            this.updateAgedBrie(i);
        }else if(i.getName().equals("Backstage passes to a TAFKAL80ETC concert")){
            this.updateTAFKAL80ETC(i);
        }else if(i.getName().equals("Sulfuras, Hand of Ragnaros")){
            // Do nothing
        }else{
            this.updateItem(i);
        }
        return i;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i]= this.update(items[i]);
        }
    }
}
