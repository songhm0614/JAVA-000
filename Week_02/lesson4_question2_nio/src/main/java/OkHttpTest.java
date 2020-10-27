import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;

/**
 * @author haomiaosong
 * @date 2020/10/27 3:53 PM
 */
public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        try {
            Request request = new Request.Builder().url("http://localhost:8808/test").build();
            Response response = client.newCall(request).execute();
            byte[] bytes = response.body().bytes();
            System.out.println(new String(bytes, "UTF-8"));
        } finally {
            client.clone();
        }
    }
}
