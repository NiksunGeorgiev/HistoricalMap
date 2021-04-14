package HistoricalMap;

public interface IHistoricalMap {
    public void add(String key, Integer value);
    public Integer get(String key, String... timestamp);
}
