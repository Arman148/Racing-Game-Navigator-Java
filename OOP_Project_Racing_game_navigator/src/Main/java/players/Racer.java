package players;

import java.util.ArrayList;
import java.util.List;

import Logic.Benefit;
import Logic.BenefitType;

public class Racer {

    private String name;

    private Benefit benefit;
    private int speed;
    private int place;

    public Racer(String name, int speed, int place) {
        this.name = name;
        this.speed = speed;
        this.place = place;
    }

    public String getName() {
        return name;
    }



    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }



    public void addSpeed(int additionalSpeed) {
        this.speed += additionalSpeed;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }


    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Place: " + getPlace());
        System.out.println("Benefit:" + this.benefit.getName());

    }
}
