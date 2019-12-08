package hello.JsonParsing;
import com.google.gson.Gson;
import org.json.*;


public class JsonTempGetterVar1 {
    public String info;

    public JsonTempGetterVar1(String info) {
        this.info = info;
    }

    public String getTemperature() throws JSONException {
        JSONObject json = new JSONObject(info);
        String hourly = json.getString("hourly");
        JSONArray data = new JSONObject(hourly).getJSONArray("data");
        String temp = new JSONObject(data.get(0).toString()).getString("temperature");

        return temp;
    }
}
