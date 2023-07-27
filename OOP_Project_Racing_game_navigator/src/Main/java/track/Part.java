package track;

import java.util.ArrayList;
import java.util.List;

public class Part {
    private int name;
    private List<Way> ways;

    public Part(int name, List<Way> ways) {
        this.name = name;
        this.ways = ways;
    }

    public Part(int name) {
        this.name = name;
    }

    public void addWay(Way way) {
        ways.add(way);
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Way> getWays() {
        return ways;
    }

    public void setWays(List<Way> ways) {
        this.ways = ways;
    }
}