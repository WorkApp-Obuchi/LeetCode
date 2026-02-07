package LeetCode.DFS;

import java.util.List;
import java.util.ArrayList;

public class ReReadBinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {

        List<String> result = new ArrayList<>();

        for(int hour = 0; hour < 12; hour++) {
            for(int minute = 0; minute < 60; minute++) {
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    String time = hour + ":" + String.format("%02d", minute);
                    result.add(time);
                }
            }
        }
        return result;
    }
}
