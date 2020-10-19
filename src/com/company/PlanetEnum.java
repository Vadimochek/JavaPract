package com.company;

public enum PlanetEnum {
    MERCURY(2439000,0.32868),
    VENUS(6050000,4.81068),
    EARTH(6371000, 5.97600),
    MARS( 3389000,0.63345),
    JUPITER(69911000,1876.64328),
    SATURN(58232000,561.80376),
    URANUS(25362000,86.05440),
    NEPTUNE(24622000,101.59200);

    public final long rad;
    public final double mas;
    PlanetEnum(long rad,double mas){
        this.rad=rad;
        this.mas=mas;
    }
    public String gravitation(double mas, long rad){
        return String.valueOf((6.67*mas*(Math.pow(10,24)))/(rad*rad*(Math.pow(10,11))));
    }
}
