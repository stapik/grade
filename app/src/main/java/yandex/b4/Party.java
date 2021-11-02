package yandex.b4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Party {

    private static final int PARLIAMENT_SEATS = 450;

    public static void main(String[] args) {
        double quotient = 0;
        int totalVotes = 0;
        Map<String, Integer> parties = readParties();

        for (Map.Entry<String, Integer> entry : parties.entrySet()) {
            totalVotes += entry.getValue();
        }
        quotient = (double) totalVotes / PARLIAMENT_SEATS;
        Map<String, PartyParliamentData> partiesParliamentVotes = getPartiesParliamentData(parties, quotient);

        for (Map.Entry<String, PartyParliamentData> item : partiesParliamentVotes.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue().getSeats());
        }
    }

    private static Map<String, Integer> readParties() {
        Map<String, Integer> parties = new LinkedHashMap<>();
        Scanner inp = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<name>.+) (?<value>[0-9]+)$");
        Matcher matcher;

        while (inp.hasNextLine()) {
            matcher = pattern.matcher(inp.nextLine());
            if (matcher.find()) {
                parties.put(matcher.group("name"), Integer.parseInt(matcher.group("value")));
            } else {
                break;
            }
        }
        inp.close();
        return parties;
    }

    private static Map<String, PartyParliamentData> getPartiesParliamentData(Map<String, Integer> parties, double quotient) {
        Map<String, PartyParliamentData> data = new LinkedHashMap<>();
        int totalParliamentSeats = 0, tempSeats;
        // round 1
        for (Map.Entry<String, Integer> entry : parties.entrySet()) {
            tempSeats = (int) Math.floor(entry.getValue() / quotient);
            totalParliamentSeats += tempSeats;
            data.put(entry.getKey(), new PartyParliamentData(tempSeats, (double) entry.getValue() % quotient)); // TODO: find error
        }
        // round 2
        AtomicInteger emptySeats = new AtomicInteger(PARLIAMENT_SEATS - totalParliamentSeats);
        data.entrySet().stream().sorted((o1, o2) -> {
            PartyParliamentData d1 = o1.getValue();
            PartyParliamentData d2 = o2.getValue();
            if (!d1.getDivQuotient().equals(d2.getDivQuotient())) {
                return d2.getDivQuotient().compareTo(d1.getDivQuotient());
            }
            return d1.getSeats().compareTo(d2.getSeats());
        }).forEach(entry -> {
            if (emptySeats.get() == 0) {
                return;
            }
            entry.getValue().addSeats(1);
            emptySeats.getAndDecrement();
        });

        return data;
    }

    private static class PartyParliamentData {
        private Integer seats;
        private final Double divQuotient;

        public PartyParliamentData(Integer seats, Double divQuotient) {
            this.seats = seats;
            this.divQuotient = divQuotient;
        }

        public Integer getSeats() {
            return seats;
        }

        public Double getDivQuotient() {
            return divQuotient;
        }

        public void addSeats(Integer s) {
            seats += s;
        }

        @Override
        public String toString() {
            return "PartyParliamentData{" +
                    "seats=" + seats +
                    ", divQuotient=" + divQuotient +
                    '}';
        }
    }
}