package com.pymxb;

import org.influxdb.dto.QueryResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 模拟生成influxdb 数据
 */
public class MockWeatherData {
    public static void main(String[] args) {
        InfluxDBConnection influxDBConnection = new InfluxDBConnection("admin", "123456", "192.168.1.52:8086", "influxdb", "");
        QueryResult results = influxDBConnection
                .query("SELECT * FROM weather ;");
        //results.getResults()是同时查询多条SQL语句的返回值，此处我们只有一条SQL，所以只取第一个结果集即可。
        QueryResult.Result oneResult = results.getResults().get(0);
        if (oneResult.getSeries() != null) {
            List<List<Object>> valueList = oneResult.getSeries().stream().map(QueryResult.Series::getValues)
                    .collect(Collectors.toList()).get(0);
            if (valueList != null && valueList.size() > 0) {
                for (List<Object> value : valueList) {
                    Map<String, String> map = new HashMap<String, String>();
                    // 数据库中字段1取值
                    String field1 = value.get(0) == null ? null : value.get(0).toString();
                    // 数据库中字段2取值
                    String field2 = value.get(1) == null ? null : value.get(1).toString();
                    // TODO 用取出的字段做你自己的业务逻辑……
                }
            }
        }
    }
}
