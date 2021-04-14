package HistoricalMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HistoricalMap implements IHistoricalMap {
    private HashMap<String, TreeMap<String, Integer>> repository = new HashMap<String, TreeMap<String, Integer>>();

    public void add(String key, Integer value) {
        String timestamp = this.getCurrentLocalDateTimeStamp();

        if(this.repository.containsKey(key)){
            this.repository.get(key).put(timestamp, value);
        } else {
            TreeMap<String, Integer> valueMap = new TreeMap<String, Integer>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                    int res = 0;
                    try {
                        res = format.parse(o1).compareTo(format.parse(o2));
                    } catch (ParseException e) {
                        return res;
                    }
                    return res;
                }
            });
            this.repository.put(key, valueMap);
        }
    }

    public Integer get(String key, String... timestamp){
        if(timestamp[0] != null && timestamp[0].isEmpty()){
            return this.repository.get(key).get(timestamp[0]);
        }

        return this.repository.get(key).lastEntry().getValue();
    }

    private String getCurrentLocalDateTimeStamp() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
