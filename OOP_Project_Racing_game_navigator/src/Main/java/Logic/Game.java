package Logic;

import java.util.*;

import javafx.scene.control.TextArea;

import players.InvalidBenefitException;
import players.Player;
import players.Opponent;
import players.Racer;
import track.Part;
import track.Track;
import track.Way;
import tracks.Tracks;


public class Game {
    private String name;
    private Player player;
    private List<Opponent> opponents;
    private Track track;
    private int chosenWay;

    private int currentPart = 0;


    public int getCurrentPart() {
        return currentPart;
    }

    public void setCurrentPart(int currentPart) {
        this.currentPart = currentPart;
    }



    public int getChosenWay() {
        return chosenWay;
    }

    public void setChosenWay(int chosenWay) {
        this.chosenWay = chosenWay;
    }


    public Game(String name, TextArea consoleTextArea) {
        this.name = name;
        this.player = null;
        this.opponents = new ArrayList<>();
        this.track = null;
        this.chosenWay = 0;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponent> opponents) {
        this.opponents = opponents;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public void helloWorld() {
        System.out.println("Hello World");
    }

    public void createPlayer() {

        String[] names = { "John", "James", "Mike", "Andrew", "William", "Benjamin", "Samuel", "Alexander", "Daniel", "Matthew", "Ethan", "Joseph", "Christopher" };
        Random random = new Random();
        String playerName = names[random.nextInt(names.length)];
        player = new Player(playerName, 0, 0);
        this.player = player;
        this.player.printInfo();

    }

    public void createOpponent() {
        System.out.println("creating opponent");
        String[] names = { "Liu", "Chen", "Li", "Wang", "Zhang", "Yang", "Zhao", "Wu", "Hu", "Zhou" }; // add more
        Random random = new Random();
        String opponentName = names[random.nextInt(names.length)];
        Opponent opponent = new Opponent(opponentName, 0, 0);
        opponents.add(opponent);
        printOpponentsInfo();
    }

    public void printOpponentsInfo() {
        System.out.println("Opponents Information:");
        for (Opponent opponent : opponents) {
            opponent.printInfo();
        }
    }

    public void resetGame() {
        this.player = null;
        this.opponents.clear();
        this.track = null;
    }


    // play function initializing everything
    public void play() {

        if (this.player == null) {
            System.out.println("No Player created. Please create Player before playing the game.");
            return;
        }

        if (this.opponents.isEmpty()) {
            System.out.println("No opponents created. Please create opponents before playing the game.");
            return;
        }

        // Initialize the track
        Track track = Tracks.Track1();
        this.track = track;

        addPositions();


        addSpeeds();

        // Perform the game logic
        System.out.println("Playing the game...");
        // Add your game logic here

        // Print track information
        System.out.println("Track: " + track.getName());
        System.out.println("Track Length: " + track.getLength());

        // Print player information
        System.out.println("Player Information:");
        if (player != null) {
            player.printInfo();
        } else {
            System.out.println("No player created.");
        }

        // Print opponents information
        printOpponentsInfo();
    }

    // adding random positions
    private void addPositions() {
        int numRacers = opponents.size() + 1;
        List<Integer> positions = new ArrayList<>();


        for (int i = 1; i <= numRacers; i++) {
            positions.add(i);
        }


        Collections.shuffle(positions);

        // Assign the positions to all racers
        if (player != null) {
            player.setPlace(positions.get(0));
        }

        for (int i = 0; i < opponents.size(); i++) {
            opponents.get(i).setPlace(positions.get(i + 1));
        }
    }

    // adding random speed
    private void addSpeeds() {
        Random random = new Random();

        if (player != null) {
            int speed = random.nextInt(41) + 60; // Random speed from 60 to 100
            player.setSpeed(speed);
        }

        for (Opponent opponent : opponents) {
            int speed = random.nextInt(41) + 60; // Random speed from 60 to 100
            opponent.setSpeed(speed);
        }
    }


    // in start function racers getting their logical places by speed and going to irst part of track
    public void start() {
        System.out.println("Starting positions and speeds are:");

        // Sort racers by their place
        List<Racer> racers = new ArrayList<>();
        racers.add(player);
        racers.addAll(opponents);
        racers.sort(Comparator.comparingInt(Racer::getPlace));

        // Print racer information
        for (Racer racer : racers) {
            System.out.println(racer.getName() + ",         speed: " + racer.getSpeed() + " km/h,      place: " + racer.getPlace());
        }

        System.out.println("..................RACE STARTED................");
        System.out.println("\n");
        System.out.println("\n");

        for (int i = 0; i < 3; i++) {
            System.out.println("Adding speed round " + (i + 1) + "...\n");

            // Add random speed to each racer
            for (Racer racer : racers) {
                int additionalSpeed = (int) (Math.random() * 11) + 10;
                racer.addSpeed(additionalSpeed);
            }

            // Recalculate positions based on speed
            racers.sort(Comparator.comparingInt(Racer::getSpeed).reversed());
            for (int j = 0; j < racers.size(); j++) {
                racers.get(j).setPlace(j + 1);
            }

            // Print updated racer information
            System.out.println("Updated positions and speeds:\n");
            for (Racer racer : racers) {
                System.out.println(racer.getName() + ",         speed: " + racer.getSpeed() + " km/h,      place: " + racer.getPlace());
            }


        }

        // Print information about the first part of the track
        System.out.println("\n\n");
        System.out.println("ATTENTION! Ahead of the first section of the route\n");

        Part firstPart = track.getParts().get(this.currentPart); // Assuming the parts are stored in a list

        // Print the number of ways on the first part
        System.out.println("There are " + firstPart.getWays().size() + " ways on this part of the track:");

        // Print information about each way
        for (Way way : firstPart.getWays()) {
            String benefitInfo = (way.getBenefit() != null) ? way.getBenefit().getName() : "No benefit";
            System.out.println(way.getName() + ", benefit: " + benefitInfo);
        }



        System.out.println("please choose which way you prefer and push |> button ");

        this.currentPart++;

    }

    // choosing the ways
    public void chooseOne() {
        this.chosenWay = 1;
        System.out.println("you choosed first way\n");
        System.out.println("please push |> button to continue race\n");
    }

    public void chooseTwo() {
        this.chosenWay = 2;
        System.out.println("you choosed second way\n");
        System.out.println("please push |> button to continue race\n");
    }

    public void chooseThree() {
        this.chosenWay = 3;
        System.out.println("you third first way\n");
        System.out.println("please push |> button to continue race\n");
    }



    // int next its going to next part of the track

    public void next() throws InvalidBenefitException {



        if (chosenWay == 0) {
            System.out.println("No way chosen. Please select a way first.");
            return;
        }

        Way way = track.getParts().get(0).getWays().get(chosenWay - 1);

        if (way.hasBenefit()) {
            this.player.addBenefit(way.getBenefit().getName());
            System.out.println("Player got benefit: " + way.getBenefit().getName());

        } else {
            System.out.println("Player did not get any benefit.");
        }

        // Reset the chosen way for the next round
        this.chosenWay = 0;

        // Add random speed increase to each racer for 3 rounds
        Random random = new Random();

        for (int round = 1; round <= 3; round++) {
            int speedIncrease = random.nextInt(11) + 20; // Random speed increase between 20 and 30

            if (player != null) {
                player.setSpeed(player.getSpeed() + speedIncrease);
            }

            for (Opponent opponent : opponents) {
                opponent.setSpeed(opponent.getSpeed() + speedIncrease);
            }


            if(player.getBenefit() != null) {
                if (player.getBenefit().getName() == "turbo") {                     // if benefit is turbo, increasing current speed by 5%
                    int fivePercent = (int) (player.getSpeed() * 0.05);
                    player.setSpeed(player.getSpeed() + fivePercent);
                } else if (player.getBenefit().getName() == "oil") {                // if benefit is turbo, decreasing opponent's current speed by 5%
                    for (Opponent opponent : opponents) {
                        int fivePercent = (int) (opponent.getSpeed() * 0.05);
                        opponent.setSpeed(opponent.getSpeed() - fivePercent);
                    }
                } else if (player.getBenefit().getName() == "health") {             // if its benefit is health, add 3% to plauer and sub 3% from oppoentn speed
                    int threePercentOfPlayer = (int) (player.getSpeed() * 0.03);
                    player.setSpeed(player.getSpeed() + threePercentOfPlayer);
                    for (Opponent opponent : opponents) {
                        int threePercentofOpponent = (int) (opponent.getSpeed() * 0.03);
                        opponent.setSpeed(opponent.getSpeed() - threePercentofOpponent);
                    }
                }
            }





            // Recalculate positions based on the updated speeds
            List<Racer> racers = new ArrayList<>();
            racers.add(player);
            racers.addAll(opponents);
            racers.sort(Comparator.comparingInt(Racer::getSpeed).reversed());
            for (int i = 0; i < racers.size(); i++) {
                racers.get(i).setPlace(i + 1);
            }

            // Print updated racer information for each round
            System.out.println("Updated positions and speeds after round " + round + ":\n");
            for (Racer racer : racers) {
                System.out.println(racer.getName() + ", speed: " + racer.getSpeed() + " km/h, place: " + racer.getPlace());
            }
        }

        if(player.getBenefit() != null) {
            if (player.getBenefit().getName() == "gun") {
                if (!opponents.isEmpty()) {
                    Random opponentRandom = new Random();
                    int index = opponentRandom.nextInt(opponents.size());
                    Opponent removedOpponent = opponents.remove(index);
                    System.out.println("Removed opponent: " + removedOpponent.getName());
                }
            }
        }



        System.out.println("\n\nwe have reached the next part of the track");
        if (currentPart < track.getParts().size()) {
            Part nextPart = track.getParts().get(currentPart);
            List<Way> ways = nextPart.getWays();

            System.out.println("Number of ways in the new part: " + ways.size());

            for (Way iway : ways) {
                String benefitInfo = (iway.getBenefit() != null) ? iway.getBenefit().getName() : "No benefit";
                System.out.println(iway.getName() + ", benefit: " + benefitInfo);
            }

            System.out.println("please choose which way you prefer and push |> button ");

        } else {
            finish();
        }



        currentPart++;




    }

    public void finish() {                  // print information about track
        System.out.println("------------FINISH---------------");
        displayRaceResults();

    }

    public void displayRaceResults() {
        System.out.println("Race Results:");

        // Sort the racers based on their positions
        List<Racer> racers = new ArrayList<>();
        racers.add(player);
        racers.addAll(opponents);
        racers.sort(Comparator.comparingInt(Racer::getPlace));

        // Display information about each racer
        for (Racer racer : racers) {
            System.out.println("Name: " + racer.getName() + ", Speed: " + racer.getSpeed() + " km/h, Place: " + racer.getPlace());
        }

        // Determine the winner
        Racer winner = racers.get(0);
        System.out.println("\nWinner: " + winner.getName());
    }


    public void printTrackInformation() {                  // print information about track
        System.out.println("Track Information:");
        System.out.println("==================");

        List<Part> trackParts = track.getParts();

        for (int partIndex = 0; partIndex < trackParts.size(); partIndex++) {
            Part trackPart = trackParts.get(partIndex);
            System.out.println("Part " + (partIndex + 1) + ":");

            List<Way> ways = trackPart.getWays();
            for (int wayIndex = 0; wayIndex < ways.size(); wayIndex++) {
                Way way = ways.get(wayIndex);
                System.out.println("  Way " + (wayIndex + 1) + ":");

                if (way.hasBenefit()) {
                    Benefit benefit = way.getBenefit();
                    System.out.println("    Benefit: " + benefit.getName());
                } else {
                    System.out.println("    No benefit on this way.");
                }
            }
            System.out.println();
        }

    }




}
