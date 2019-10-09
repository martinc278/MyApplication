package com.example.myapplication

class Cellar(val id: Int, val bottleList: MutableList<Bottle>, val name: String) {

    fun addBottle(name: String, price: Int) : Unit{
        val maBottle = Bottle(name, price);
        bottleList.add(maBottle);
    }

    fun getBottle(name: String) : Bottle? {
        return this.bottleList.find { it.nom == name };
    }

    fun getTotalPriceEuro() : Float{
        var prixTot: Float = 0F;
        for(i in 0..bottleList.size){
            prixTot = prixTot + bottleList[i].prix;
        }
        return prixTot;
    }

    fun getTotalPriceDollars(): Float{
        return getTotalPriceEuro()/0.8f;
    }

    fun getNbBottle() : Int {
        var nbBottle: Int = 0;
        for (i in 0..bottleList.size) {
            nbBottle = nbBottle + 1;
        }
        return nbBottle;
    }
}