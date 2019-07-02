package com.deltasi.elezioni.state;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessionStateHelper
{
    private Map<String, Object> sums = new HashMap<>();

    public synchronized Object get(String key) {
        return sums.get(key);
    }

    public synchronized void add(String key, Object val) {

        if (!sums.containsKey(key)) {
            sums.put(key, val);
        }
    }
    public  synchronized void remove(String  key)
    {
        if(sums.containsKey(key))
        {
            sums.remove(key);
        }
    }

    public synchronized void removeAll() {
        sums.values();
    }
}
