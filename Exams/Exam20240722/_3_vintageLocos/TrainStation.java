package Exams.Exam20240722._3_vintageLocos;

import java.util.ArrayList;
import java.util.List;

public class TrainStation {
    private final String name;
    private final int capacity;
    private final int railGauge;
    List<Locomotive> locomotives;

    public String getName() {
        return name;
    }

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive) {
        if (this.locomotives.size() < this.capacity) {
            if (this.railGauge == locomotive.getGauge()) {
                this.locomotives.add(locomotive);
            } else {
                System.out.printf("The rail gauge of this station does not match the locomotive gauge!" +
                        " Difference %d mm.%n", Math.abs(this.railGauge - locomotive.getGauge()));
            }
        } else {
            System.out.println("This train station is full!");
        }
    }

    public boolean removeLocomotive(String name) {
        return this.locomotives.removeIf(locomotive -> locomotive.getName().equals(name));
    }

    public String getFastestLocomotive() {
        if (this.locomotives.isEmpty()) {
            return "There are no locomotive.";
        } else {
            int fastest = 0;
            for (int i = 0; i < this.locomotives.size(); i++) {
                if (this.locomotives.get(fastest).getMaxSpeed() < this.locomotives.get(i).getMaxSpeed()) {
                    fastest = i;
                }
            }
            Locomotive locomotive = this.locomotives.get(fastest);
            return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.",
                    locomotive.getName(), locomotive.getMaxSpeed());
        }
    }

    public Locomotive getLocomotive(String name) {
        return this.locomotives.stream().filter(l -> l.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.locomotives.size();
    }

    public String getOldestLocomotive() {
        if (this.locomotives.isEmpty()) {
            return "There are no locomotive.";
        } else {
            int oldest = 0;
            for (int i = 0; i < this.locomotives.size(); i++) {
                if (this.locomotives.get(oldest).getBuildDate().isAfter(this.locomotives.get(i).getBuildDate())) {
                    oldest = i;
                }
            }
            return this.locomotives.get(oldest).getName();
        }
    }

    public String getStatistics() {
        if (this.getCount() == 0) {
            return String.format("There are no locomotives departing from %s station.", this.getName());
        }

        StringBuilder output = new StringBuilder("Locomotives departed from ")
                .append(this.getName()).append(":").append(System.lineSeparator());

        int position = 1;
        for (var locomotive : this.locomotives) {
            output.append(String.format("%d. %s", position, locomotive.getName())).append(System.lineSeparator());
            position++;
        }

        return output.toString();
    }
}
