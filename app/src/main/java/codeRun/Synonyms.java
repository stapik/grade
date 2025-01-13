package codeRun;

import java.io.*;
import java.util.*;

public class Synonyms {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> dict = new ArrayList<>();
        int size = Integer.parseInt(reader.readLine());

        for (int i=0; i< size; i++){
            dict.addAll(Arrays.asList(reader.readLine().split(" ")));
        }

        String searchStr = reader.readLine();
        int searchIdx = dict.indexOf(searchStr);
        String result;

        if(searchIdx % 2 == 0){
            result = dict.get(searchIdx + 1);
        } else {
            result = dict.get(searchIdx - 1) ;
        }

        writer.write(result);

        reader.close();
        writer.close();
    }
}
