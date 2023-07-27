package Logic;

public interface Description {
    void addDescription(String Desctiption);

    default void defaultDescription() {
        System.out.println("this is an benefit which you can get on the road");
    }
}
