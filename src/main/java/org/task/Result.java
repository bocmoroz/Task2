package org.task;

import com.google.gson.Gson;
import org.task.model.MedicalMainResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Result {
    private static List<Float> allDiagnosisTemperatures = new ArrayList<>();

    public static List<Integer> bodyTemperature(String doctorName, int diagnosisId) {
        String url1 = generateUrl(1);
        MedicalMainResponse medicalMainResponse = sendGetRequest(url1);
        processResponse(medicalMainResponse, doctorName, diagnosisId);

        int totalPages = medicalMainResponse.getTotal_pages();

        //async way
        List<CompletableFuture<MedicalMainResponse>> futures = new ArrayList<>();
        for (int i = 2; i <= totalPages; i++) {
            String currUrl = generateUrl(i);
            CompletableFuture<MedicalMainResponse> future = CompletableFuture.supplyAsync(() -> sendGetRequest(currUrl));
            futures.add(future);
        }

        for (CompletableFuture<MedicalMainResponse> future : futures) {
            MedicalMainResponse response = future.join();
            if (response != null) {
                processResponse(response, doctorName, diagnosisId);
            }
        }

        //sync way
//        for (int i = 2; i <= totalPages; i++) {
//            String currUrl = generateUrl(i);
//            MedicalMainResponse currentResponse = sendGetRequest(currUrl);
//            processResponse(currentResponse, doctorName, diagnosisId);
//        }

        List<Integer> sortedAndMappedTemperature = allDiagnosisTemperatures.stream().sorted().map(Float::intValue).collect(Collectors.toList());
        return Arrays.asList(sortedAndMappedTemperature.get(0), sortedAndMappedTemperature.get(sortedAndMappedTemperature.size() - 1));

    }

    private static void processResponse(MedicalMainResponse medicalMainResponse, String doctorName, int diagnosisId) {
        medicalMainResponse.getData().stream()
                .filter(data -> doctorName.equals(data.getDoctor().getName()))
                .filter(data -> data.getDiagnosis().getId() == diagnosisId)
                .forEach(data -> allDiagnosisTemperatures.add(data.getVitals().getBodyTemperature()));
    }

    private static String generateUrl(int page) {
        return String.format(
                "https://jsonmock.hackerrank.com/api/medical_records?page=%d",
                page);
    }

    private static MedicalMainResponse sendGetRequest(String urlString) {
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                connection.disconnect();

                Gson gson = new Gson();
                return gson.fromJson(response.toString(), MedicalMainResponse.class);
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }
}
