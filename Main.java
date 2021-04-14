package HistoricalMap;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        HistoricalMap hMap = new HistoricalMap();
        hMap.add("VMW", 100);
        TimeUnit.MINUTES.sleep(1);
        hMap.add("VMW", 110);
        TimeUnit.MINUTES.sleep(1);
        hMap.add("VMW", 120);

      // System.out.println(hMap.toString());
        System.out.println(hMap.get("VMW","21:34"));
    }

}
