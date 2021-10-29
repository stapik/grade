package yandex.b1;

import java.io.*;

public class Interactor {

    private static StreamTokenizer readFile() throws IOException {
        return new StreamTokenizer(
                new BufferedInputStream(
                        new FileInputStream("input.txt")));
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = readFile();
        in.nextToken();
        int taskCode = (int) in.nval;
        in.nextToken();
        int interactVerdict = (int) in.nval;
        in.nextToken();
        int checkerVerdict = (int) in.nval;
        int result = interactVerdict;

        if (interactVerdict == 0) {
            result = taskCode == 0 ? checkerVerdict : 3;
        }

        if (interactVerdict == 1) {
            result = checkerVerdict;
        }

        if (interactVerdict == 4) {
            result = taskCode == 0 ? 4 : 3;
        }

        if(interactVerdict == 6){
            result = 0;
        }

        if(interactVerdict == 7){
            result = 1;
        }

        System.out.println(result);
    }
}
