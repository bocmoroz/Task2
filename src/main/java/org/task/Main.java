package org.task;

import java.io.*;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String doctorName = bufferedReader.readLine();

        int diagnosisId = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.bodyTemperature(doctorName, diagnosisId);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
