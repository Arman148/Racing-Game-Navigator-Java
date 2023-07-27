package players;


import java.util.ArrayList;
import java.util.List;


import Logic.Benefit;

import Logic.BenefitType;



public class Opponent extends Racer {

    private Benefit benefit;

    @Override
    public Benefit getBenefit() {
        return benefit;
    }

    @Override
    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }


    public Opponent(String name, int speed, int place) {
        super(name, speed, place);

    }

    //overriden Method to add a new benefit to the opponent
    public void addBenefit(String name) {
        BenefitType type = null;

        // Determine the BenefitType based on the provided name
        if(name.equalsIgnoreCase("TURBO")) {
            type = BenefitType.TURBO;
        } else if(name.equalsIgnoreCase("OIL")) {
            type = BenefitType.OIL;
        }

        // Create a new Benefit object if a valid BenefitType is determined
        if(type != null) {
            Benefit newBenefit = new Benefit(name, type);
            this.benefit = newBenefit;
        } else {
            System.out.println("Opponent can only receive TURBO and OIL benefits.");
        }
    }

    // Method to create a Benefit object based on the provided type
    private Benefit createBenefitInstance(String name, BenefitType type) {
        Benefit benefit = null;

        // Use RTTI to create an object of a specific type
        if (type == BenefitType.TURBO) {
            benefit = new TurboBenefit(name, type);  // Assuming TurboBenefit is a subclass of Benefit
        } else if (type == BenefitType.OIL) {
            benefit = new OilBenefit(name, type);  // Assuming OilBenefit is a subclass of Benefit
        }

        return benefit;
    }

    // Overridden method to print the opponent's information
    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Place: " + getPlace());
    }

    private class TurboBenefit extends Benefit {
        private String name;
        public TurboBenefit(String name, BenefitType type) {
            super(name, type);
        }

    }

    private class OilBenefit extends Benefit {
        private String name;
        public OilBenefit(String name, BenefitType type) {
            super(name, type);
        }
    }
}