
package org.rac021.business;

/**
 *
 * @author ryahiaoui
 */

public class Plane {
    
    private final String model            ;
    private final int    total_passengers ;
    private final int    distance_km      ;
    private final int    speed_km         ;

    public Plane( String model, int total_passengers, int distance_km, int speed_km) {
        this.model            = model            ;
        this.total_passengers = total_passengers ;
        this.distance_km      = distance_km      ;
        this.speed_km         = speed_km         ;
    }

    public String getModel() {
        return model ;
    }

    public int getTotal_passengers() {
        return total_passengers ;
    }

    public int getDistance_km() {
        return distance_km ;
    }

    public int getSpeed_km() {
        return speed_km ;
    }
}
