import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String language = "ru";

        try {
            String key = "pdct.1.1.20240202T142145Z.1fea54a067da038b.a62f58867981c423f054e2c4ae6817a9b4484e8c";

            String u = "https://predictor.yandex.net/api/v1/predict.json/complete?key=" + key + "&q=" + word + "&lang=" + language + "&limit=5";
            URL url = new URL(u);

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                Scanner s = new Scanner(connection.getInputStream());
                while (s.hasNextLine()) {
                    System.out.println(s.nextLine());
                }
            } else {
                System.out.println("Даже Яндекс не жклает с тобой говорить... Задумайся.");
            }

            connection.disconnect();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}