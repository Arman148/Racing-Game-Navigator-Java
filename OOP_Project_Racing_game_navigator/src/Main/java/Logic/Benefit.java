package Logic;


public class Benefit<T> implements Description {
    private String name;
    private BenefitType type;
    private T cast;

    private String description;

    public Benefit(String name, T cast) {
        this.name = name;
        this.cast = cast;
    }

    /*
    *   Benefit<BenefitType> turboBenefit = new Benefit<>("TURBO", BenefitType.TURBO);
    *   Benefit<String> customBenefit = new Benefit<>("Custom Benefit", "Custom Type");
    *
    *
    *  */

    public Benefit(String name, BenefitType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BenefitType getType() {
        return type;
    }

    public void setType(BenefitType type) {
        this.type = type;
    }

    @Override
    public void addDescription(String description) {
        this.description = description;
    }
}