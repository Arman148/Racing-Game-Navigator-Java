package track;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private String name;
    private int length;
    private List<Part> parts;

    public Track(String name, List<Part> parts) {
        this.name = name;
        this.parts = parts;
        this.length = parts.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
}