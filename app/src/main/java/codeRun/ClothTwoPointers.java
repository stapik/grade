package codeRun;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ClothTwoPointers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] nArr = reader.readLine().split(" ");
        int m = Integer.parseInt(reader.readLine());
        String[] mArr = reader.readLine().split(" ");

        int nIdx = 0, mIdx = 0, diff = Integer.MAX_VALUE, resultN = 0, resultM = 0, temp, nNum, mNum;

        while (nIdx < nArr.length && mIdx < mArr.length) {
            nNum = Integer.parseInt(nArr[nIdx]);
            mNum = Integer.parseInt(mArr[mIdx]);
            temp = Math.abs(mNum - nNum);

            if (temp < diff) {
                diff = temp;
                resultN = Integer.parseInt(nArr[nIdx]);
                resultM = Integer.parseInt(mArr[mIdx]);
            }

            if (nNum < mNum) {
                nIdx++;
            } else {
                mIdx++;
            }
        }

        writer.write(resultN + " " + resultM);

        reader.close();
        writer.close();
    }
}
