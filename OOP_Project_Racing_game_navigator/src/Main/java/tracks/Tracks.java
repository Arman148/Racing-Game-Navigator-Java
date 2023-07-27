package tracks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Logic.Benefit;
import Logic.BenefitType;
import track.Part;
import track.Track;
import track.Way;

public class Tracks {


        // example tracks
    public static Track Track1() {                  // track one
        List<Part> parts = new ArrayList<>();

        // First part
        List<Way> part1 = new ArrayList<>();
        Way way1Part1 = new Way(1);
        Way way2Part1 = new Way(2, "turbo");
        Way way3Part1 = new Way(3);
        part1.add(way1Part1);
        part1.add(way2Part1);
        part1.add(way3Part1);


        // Second part
        List<Way> part2 = new ArrayList<>();
        Way way1Part2 = new Way(1, "gun");
        Way way2Part2 = new Way(2);
        Way way3Part2 = new Way(3);
        part2.add(way1Part2);
        part2.add(way2Part2);
        part2.add(way3Part2);

        // Third part
        List<Way> part3 = new ArrayList<>();
        Way way1Part3 = new Way(1);
        Way way2Part3 = new Way(2);
        Way way3Part3 = new Way(3, "oil");
        part3.add(way1Part3);
        part3.add(way2Part3);
        part3.add(way3Part3);

        // Add the parts to the list of parts
        parts.add(new Part(1, part1));
        parts.add(new Part(2, part2));
        parts.add(new Part(3, part3));

        return new Track("Track1", parts);
    }
}

