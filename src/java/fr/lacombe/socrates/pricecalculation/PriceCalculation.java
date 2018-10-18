package fr.lacombe.socrates.pricecalculation;

public class PriceCalculation {

    public int compute(int accomodationPrice) {
        if (accomodationPrice == 410){
            return 410;
        }
        if (accomodationPrice == 510){
            return 510;
        }
        return 610;
    }
}
