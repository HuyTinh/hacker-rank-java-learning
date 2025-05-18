package skill_verification.rest_api.Intermediate.test_1;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.json.JSONArray;
import org.json.JSONObject;

public class Result {
    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     */

    public static int getTeamGoal(String team, int year, int numberOfTeam, int page) {
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
                    return 0;
                }

                JSONArray data = json.getJSONArray("data");
                if (data.isEmpty()) {
                    return 0;
                }

                for (int i = 0; i < data.length(); i++) {
                    JSONObject match = data.getJSONObject(i);
                    String goalsStr = match.getString("team" + numberOfTeam + "goals");
                    totalGoals += Integer.parseInt(goalsStr);
                }

                page++;
            } catch (Exception e) {
                e.printStackTrace();
                break; // hoặc return totalGoals nếu muốn dừng ngay khi lỗi
            }
        } while (page <= totalPages);

        return totalGoals;
    }


    public static int getTotalGoals(String team, int year) {
        team = URLEncoder.encode(team, StandardCharsets.UTF_8);
        return getTeamGoal(team, year, 1, 1) + getTeamGoal(team, year, 2, 1);
    }

}
