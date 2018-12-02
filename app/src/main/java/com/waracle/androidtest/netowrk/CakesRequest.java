package com.waracle.androidtest.netowrk;

import android.os.AsyncTask;

import com.waracle.androidtest.utils.StreamUtils;
import com.waracle.androidtest.model.Cake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CakesRequest extends AsyncTask<Void, Void, List<Cake>> {
    private static String cakesUrl = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/" +
            "raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json";
    private CakesRequestCallBacks callBacks;

    public CakesRequest(CakesRequestCallBacks callBacks) {
        this.callBacks = callBacks;
    }

    @Override
    protected List<Cake> doInBackground(Void... voids) {
        try {
            JSONArray jsonArray = loadData();
            if (jsonArray != null) {
                return maptToCakesList(jsonArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Cake> cakes) {
        super.onPostExecute(cakes);
        if (cakes != null) {
            callBacks.onSuccess(cakes);
        } else {
            callBacks.onFailure();
        }
    }


    private JSONArray loadData() throws IOException, JSONException {
        URL url = new URL(cakesUrl);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            // Can you think of a way to improve the performance of loading data
            // using HTTP headers???

            // Also, Do you trust any utils thrown your way????

            byte[] bytes = StreamUtils.readUnknownFully(in);

            // Read in charset of HTTP content.
            String charset = parseCharset(urlConnection.getRequestProperty("Content-Type"));

            // Convert byte array to appropriate encoded string.
            String jsonText = new String(bytes, charset);

            // Read string as JSON.
            return new JSONArray(jsonText);
        } finally {
            urlConnection.disconnect();
        }
    }

    /**
     * Returns the charset specified in the Content-Type of this header,
     * or the HTTP default (ISO-8859-1) if none can be found.
     */
    private String parseCharset(String contentType) {
        if (contentType != null) {
            String[] params = contentType.split(",");
            for (int i = 1; i < params.length; i++) {
                String[] pair = params[i].trim().split("=");
                if (pair.length == 2) {
                    if (pair[0].equals("charset")) {
                        return pair[1];
                    }
                }
            }
        }
        return "UTF-8";
    }

    private List<Cake> maptToCakesList(JSONArray response) {
        List<Cake> list = new ArrayList<Cake>();
        for (int i = 0; i < response.length(); i++) {
            try {
                JSONObject object = response.getJSONObject(i);
                Cake cake = new Cake();
                cake.setTitle(object.getString("title"));
                cake.setDesc(object.getString("desc"));
                cake.setImage(object.getString("image"));
                list.add(cake);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return list;

    }

}
