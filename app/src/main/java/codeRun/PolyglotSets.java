package codeRun;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PolyglotSets {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int pupilCount = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();
        Set<String> maxPupilLngSet = new HashSet<>();

        for (int i = 0; i < pupilCount; i++) {
            int lngCount = Integer.parseInt(reader.readLine());
            Set<String> set = new HashSet<>();
            for (int j = 0; j < lngCount; j++) {
                String lng = reader.readLine();
                map.compute(lng, (key, value) -> value == null ? 1 : value + 1);
                set.add(lng);
            }
            if (maxPupilLngSet.size() < set.size()) {
                maxPupilLngSet = new HashSet<>(set);
            }
        }

        StringJoiner sj = getSj(map, pupilCount);

        writer.write(sj.toString());
        reader.close();
        writer.close();
    }

    private static StringJoiner getSj(Map<String, Integer> map, int pupilCount) {
        StringJoiner sj = new StringJoiner("\n");
        Set<String> commonLng = map.entrySet().stream()
                .filter(entry -> entry.getValue() == pupilCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        sj.add(String.valueOf(commonLng.size()));
        commonLng.forEach(sj::add);

        sj.add(String.valueOf(map.size()));
        map.keySet().forEach(sj::add);
        return sj;
    }
}
