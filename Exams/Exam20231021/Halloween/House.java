package Exams.Exam20231021.Halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final int capacity;
    private final List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        return this.data.removeIf(kid -> kid.getName().equals(name));
    }

    public Kid getKid(String city){
        for (Kid kid : this.data) {
            if (kid.getStreet().equals(city)) {
                return kid;
            }
        }
        return null;
    }

    public int getAllKids() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("Children who visited a house for candy:")
                .append(System.lineSeparator());

        for (Kid kid : this.data) {
            output.append(kid.getName()).append(" from ").append(kid.getStreet()).append(" street")
                    .append(System.lineSeparator());
        }

        return output.toString();
    }
}
