package yandex.b4;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParliamentSeats {

    public static void main(String[] args) {
        Map<String, Integer> partiesVotes = readPartiesVotes();
        Map<String, PartyParliamentData> partiesParliamentSeats = calcPartiesParliamentSeats(partiesVotes);

        partiesParliamentSeats.forEach((key, value) -> System.out.println(key + " " + value.getSeats()));
    }

    private static Map<String, Integer> readPartiesVotes() {
        Map<String, Integer> parties = new LinkedHashMap<>();
        Scanner inp = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<party>.+) (?<votes>[0-9]+)$");
        Matcher matcher;

        while (inp.hasNextLine()) {
            matcher = pattern.matcher(inp.nextLine());
            if (matcher.find()) {
                parties.put(matcher.group("party"), Integer.parseInt(matcher.group("votes")));
            } else {
                break;
            }
        }
        inp.close();
        return parties;
    }

    private static Map<String, PartyParliamentData> calcPartiesParliamentSeats(Map<String, Integer> partiesVotes) {
        final int PARLIAMENT_SEATS = 450;
        int totalVotes = partiesVotes.values().stream().reduce(Integer::sum).orElse(0);
        double quotient = (double) totalVotes / PARLIAMENT_SEATS;

        Map<String, PartyParliamentData> data = new LinkedHashMap<>();
        int sumPartySeats = 0, partySeats;
        // round 1
        for (Map.Entry<String, Integer> entry : partiesVotes.entrySet()) {
            partySeats = (int) Math.floor(entry.getValue() / quotient);
            sumPartySeats += partySeats;
            data.put(entry.getKey(), new PartyParliamentData(partySeats, quotient != 0 ? (double) entry.getValue() % quotient : 0));
        }
        // round 2
        AtomicInteger emptySeats = new AtomicInteger(PARLIAMENT_SEATS - sumPartySeats);
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