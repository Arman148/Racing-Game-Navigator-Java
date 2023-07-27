package track;
import Logic.Benefit;
import Logic.BenefitType;

public class Way {
    private int name;
    private Benefit benefit;

    public Way(int name) {
        this.name = name;
        this.benefit = null;
    }

    public Way(int name, String benefit) {
        this.name = name;
        if (benefit.equalsIgnoreCase("turbo")) {
            this.benefit = new Benefit("turbo", BenefitType.TURBO);
        } else if (benefit.equalsIgnoreCase("gun")) {
            this.benefit = new Benefit("gun", BenefitType.GUN);
        } else if (benefit.equalsIgnoreCase("oil")) {
            this.benefit = new Benefit("gun", BenefitType.OIL);
        } else if (benefit.equalsIgnoreCase("health")) {
            this.benefit = new Benefit("gun", BenefitType.HEALTH);
        } else {
            this.benefit = null;
        }
    }


    public boolean hasBenefit() {
        return (benefit != null);
    }


    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public void setBenefit(Benefit benefit) {
        this.benefit = benefit;
    }
}