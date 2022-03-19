package array;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class JsonObject {
    public static void main(String[] args) {
        String metricsUrl = "http://192.168.1.61:9090/api/v1/query";
        String deviceId = "{deviceId=\"05ZMKN55C45RNDPY\"}";
        deviceId = deviceId.replace("=", ":");
        JSONObject object = JSON.parseObject(deviceId);
        deviceId = (String)object.get("deviceId");
        String query = "elasticsearch_cluster_health_initializing_shards{deviceId=\"id\"}";
                query = query.replace("id",deviceId);
        String queryUrl = metricsUrl + "?query={deviceId}";
        Map<String, String> newVars = new HashMap<String, String>();
        newVars.put("deviceId",query);
        RestTemplate restTemplate = new RestTemplate();
        JSONArray result = restTemplate.getForObject(queryUrl, JSONObject.class, newVars).getJSONObject("data").getJSONArray("result");
    }
}
