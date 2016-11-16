package chrono_lux.chrono_lux;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/**
 * Created by Adam on 15/11/2016.
 * This class will deal with interacting with the internet using URLs.
 * With many ways a web call can fail it is a good idea to have error handling in it's own class.
 */

public class WebHandler {

    private static final String TAG = WebHandler.class.getSimpleName();

    public WebHandler() {
    }

    public String makeServiceCall(String reqUrl) {
        //The response string will be used to store the web response.
        String response = null;
        try {
            URL url = new URL(reqUrl);
            // Open the connection to the URL provided.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Receive the response
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());
            // Convert the stream into a usable string
            response = convertStreamToString(inputStream);
            //Handle the various errors from URL connection failure.
        } catch (MalformedURLException e) {
            Log.e(TAG, "Malformed URL: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "Protocol Exception: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IO Exception: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        // Line will store each line of the input stream
        String line;

        // Try used to handle buffered reader exceptions.
        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Finally, once the above loop has completed will try to close down the input stream
            // and will handle any exceptions found.
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
