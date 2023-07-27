package players;
import Logic.Benefit;


import java.util.ArrayList;
import java.util.List;



import Logic.BenefitType;

public class Player extends Racer {

    private Benefit benefit;
    public Player(String name, int speed, int place) {
        super(name, speed, place);
        this.benefit = null;
    }

    // adding benefit
    public void addBenefit(String name) throws InvalidBenefitException {
        try {
            BenefitType type = BenefitType.valueOf(name.toUpperCase());
            this.benefit = new Benefit(name, type);
        } catch (IllegalArgumentException e) {
            throw new InvalidBenefitException("Invalid benefit: " + name);
        }
    }

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Place: " + getPlace());
        if(this.benefit != null) {
            System.out.println("Benefit:" + this.benefit.getName());
        } else {
            System.out.println("Benefit: no benefit");
        }

    }

    @Override
    public Benefit getBenefit() {
        return benefit;
    }

    @Override
    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }
}