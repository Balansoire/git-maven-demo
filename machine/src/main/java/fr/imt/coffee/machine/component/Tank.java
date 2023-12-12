package fr.imt.coffee.machine.component;

public class Tank {
    private final double maxVolume;
    private final double minVolume;
    private double actualVolume;

    /**
     * Réservoir d'eau de la cafetière.
     * @param initialVolume Volume à mettre dans le réservoir à sa création
     * @param minVolume Volume minimal du réservoir
     * @param maxVolume Volume maximal du réservoir
     */
    public Tank(double initialVolume, double minVolume, double maxVolume){
        this.maxVolume = maxVolume;
        this.minVolume = minVolume;
        this.actualVolume = initialVolume;
    }

    /**
     * Réduit le volume de matière dans le réservoir
     * @param volumeToDecrease Volume de matière à enlever dans le réservoir
     */
    public void decreaseVolumeInTank(double volumeToDecrease){
        if (this.actualVolume - volumeToDecrease < this.minVolume){
            throw new IllegalArgumentException("You can't decrease the volume below the minimum volume");
        } else if (volumeToDecrease < 0){
            throw new IllegalArgumentException("You can't decrease the volume with a negative value");
        }
        this.actualVolume -= volumeToDecrease;
    }

    /**
     * Augmente le volume de matière dans le réservoir
     * @param volumeToIncrease Volume de matière à ajouter dans le réservoir
     */
    public void increaseVolumeInTank(double volumeToIncrease){
        if (volumeToIncrease < 0){
            throw new IllegalArgumentException("You can't increase the volume with a negative value");
        } else if (this.actualVolume + volumeToIncrease > this.maxVolume){
            throw new IllegalArgumentException("You can't increase the volume above the maximum volume");
        }
        this.actualVolume += volumeToIncrease;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public double getMinVolume() {
        return minVolume;
    }

    public double getActualVolume() {
        return actualVolume;
    }
}
