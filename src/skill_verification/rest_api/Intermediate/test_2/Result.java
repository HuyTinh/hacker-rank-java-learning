package skill_verification.rest_api.Intermediate.test_2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class Result {
    /*
     * Complete the 'getWinnerTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING competition
     *  2. INTEGER year
     */

    public static String getWinningTeamOfCompetition(String competition, int year) {
        HttpClient client = HttpClient.newHttpClient(); // Move outside the loop

        try {
            String url = "https://jsonmock.hackerrank.com/api/football_competitions?name="+competition+"&year=" + year;

            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create(url))
                                             .GET()
                                             .build();

            // ✅ Use send() to avoid creating too many threads
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            JSONArray data = json.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {
                JSONObject match = data.getJSONObject(i);
                return match.getString("winner");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getTeamGoals(String competition, String team, int year, int numberOfTeam, int page) {
        int totalGoals = 0;
        int totalPages = 1;

        HttpClient client = HttpClient.newHttpClient(); // Move outside the loop

        do {
            try {
                String url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + year
                             + "&team" + numberOfTeam + "=" + team
                             + "&page=" + page;

                HttpRequest request = HttpRequest.newBuilder()
                                                 .uri(URI.create(url))
                                                 .GET()
                                                 .build();

                // ✅ Use send() to avoid creating too many threads
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                JSONObject json = new JSONObject(response.body());
                totalPages = json.getInt("total_pages");

                if (totalPages == 0) {
                    return totalGoals;
                }

                JSONArray data = json.getJSONArray("data");
                if (data.isEmpty()) {
                    return totalGoals;
                }

                for (int i = 0; i < data.length(); i++) {
                    JSONObject match = data.getJSONObject(i);
                    String goalsStr = match.getString("team" + numberOfTeam + "goals");
                    String compeString = match.getString("competition");
                    if(compeString.equals(competition)) {
                        totalGoals += Integer.parseInt(goalsStr);
                    }
                }

                page++;
            } catch (Exception e) {
                e.printStackTrace();
                break; // hoặc return totalGoals nếu muốn dừng ngay khi lỗi
            }
        } while (page <= totalPages);

        return totalGoals;
    }

    public static int getWinnerTotalGoals(String competition, int year) {
        String encodedCompetition = URLEncoder.encode(competition, StandardCharsets.UTF_8);
        String encodedTeam = URLEncoder.encode(getWinningTeamOfCompetition(encodedCompetition, year), StandardCharsets.UTF_8);
        return getTeamGoals(competition, encodedTeam, year, 1, 1) + getTeamGoals(competition, encodedTeam, year, 2, 1);
    }

}
