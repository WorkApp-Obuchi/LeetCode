package LeetCode.DFS;

import java.util.ArrayList;
import java.util.List;

public class ReadBinaryWatch {
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
