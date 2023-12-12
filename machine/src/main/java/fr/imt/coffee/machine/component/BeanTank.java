package fr.imt.coffee.machine.component;

import fr.imt.coffee.storage.type.CoffeeType;

public class BeanTank extends Tank{

    private CoffeeType beanCoffeeType;
    /**
     * Réservoir de graines de café de la cafetière
     *
     * @param initialVolume Volume de graines à mettre dans le réservoir à sa création
     * @param minVolume     Volume de graines minimal du réservoir
     * @param maxVolume     Volume de graines maximal du réservoir
     * @param beanCoffeeType Type de café dans le réservoir
     */
    public BeanTank(double initialVolume, double minVolume, double maxVolume, CoffeeType beanCoffeeType) {
        super(initialVolume, minVolume, maxVolume);
        this.beanCoffeeType = beanCoffeeType;
    }

    public void increaseCoffeeVolumeInTank(double coffeeVolume, CoffeeType coffeeType){
        if (this.beanCoffeeType != coffeeType){
            throw new IllegalArgumentException("You can't mix two different types of coffee in the same tank");
        } else if (coffeeVolume > this.getMaxVolume() - this.getActualVolume()){
            throw new IllegalArgumentException("You can't put more coffee than the tank can contain");
        } else if (coffeeVolume < 0){
            throw new IllegalArgumentException("You can't put a negative volume of coffee");
        }
        this.increaseVolumeInTank(coffeeVolume);
        this.beanCoffeeType = coffeeType;
    }
    public CoffeeType getBeanCoffeeType() {
        return beanCoffeeType;
    }

    public void setBeanCoffeeType(CoffeeType beanCoffeeType) {
        this.beanCoffeeType = beanCoffeeType;
    }
}
