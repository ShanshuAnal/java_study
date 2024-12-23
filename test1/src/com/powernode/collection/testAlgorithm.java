package com.powernode.collection;

import java.util.*;

/**
 * @Author: RG
 * @Package: com.powernode.set
 * @name: testAlgorithm
 * @Date: 2024/10/16 17:08
 */
public class testAlgorithm {
    List<String> res = new ArrayList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(list.get(0))) {
                temp = map.get(list.get(0));
                temp.put(list.get(1), temp.getOrDefault(list.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(list.get(1) , 1);
            }
            map.put(list.get(0), temp);
        }

        res.add("JFK");
        backTracking(tickets.size());

        return res;
    }

    private boolean backTracking(int ticketsNum) {
        if (res.size() == ticketsNum + 1) {
            return true;
        }

        String takeOffAirport = res.getLast();

        if (map.containsKey(takeOffAirport)) {
            for (Map.Entry<String, Integer> target : map.get(takeOffAirport).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    target.setValue(count - 1);
                    res.add(target.getKey());
                    if (backTracking(ticketsNum)) {
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }

        return false;
    }
}

















