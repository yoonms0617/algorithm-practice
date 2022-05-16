import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ParkingLot {

    private static final String LAST_TIME = "23:59";

    private final Map<String, String> entranceTimeMap = new HashMap<>();
    private final Map<String, Integer> cumulativeTimeMap = new HashMap<>();
    private final int[] fees;

    public ParkingLot(int[] fees) {
        this.fees = fees;
    }

    private void inCar(String inTime, String carNumber) {
        entranceTimeMap.put(carNumber, inTime);
    }

    private void outCar(String outTime, String carNumber) {
        String inTime = entranceTimeMap.get(carNumber);
        int cumulativeTime = calcCumulativeTime(inTime, outTime);
        updateCumulativeTime(carNumber, cumulativeTime);
        entranceTimeMap.remove(carNumber);
    }

    private int calcCumulativeTime(String in, String out) {
        String[] inTime = in.split(":");
        String[] outTime = out.split(":");
        int inTimeMin = (Integer.parseInt(inTime[0]) * 60) + Integer.parseInt(inTime[1]);
        int outTimeMin = (Integer.parseInt(outTime[0]) * 60) + Integer.parseInt(outTime[1]);
        return outTimeMin - inTimeMin;
    }

    private void updateCumulativeTime(String carNumber, int cumulativeTime) {
        if (cumulativeTimeMap.containsKey(carNumber)) {
            cumulativeTime = cumulativeTime + cumulativeTimeMap.get(carNumber);
            cumulativeTimeMap.put(carNumber, cumulativeTime);
        } else {
            cumulativeTimeMap.put(carNumber, cumulativeTime);
        }
    
    }

    public void record(String[] info) {
        String time = info[0];
        String carNumber = info[1];
        String status = info[2];
        if (status.equals("IN")) {
            inCar(time, carNumber);
        } else {
            outCar(time, carNumber);
        }
    }

    private int calcParkingFee(int cumulativeTime) {
        return (int) (fees[1] + Math.ceil((double) (cumulativeTime - fees[0]) / fees[2]) * fees[3]);
    }

    public int[] print() {
        for (String carNumber : entranceTimeMap.keySet()) {
            String inTime = entranceTimeMap.get(carNumber);
            int cumulativeTime = calcCumulativeTime(inTime, LAST_TIME);
            updateCumulativeTime(carNumber, cumulativeTime);
        }
        int size = cumulativeTimeMap.size();
        String[] keys = cumulativeTimeMap.keySet().toArray(new String[size]);
        Arrays.sort(keys);
        int[] answer = new int[size];
        int idx = 0;
        for (String key : keys) {
            int cumulativeTime = cumulativeTimeMap.get(key);
            if (cumulativeTime < fees[0]) {
                answer[idx] = fees[1];
            } else {
                answer[idx] = calcParkingFee(cumulativeTime);
            }
            idx = idx + 1;
        }
        return answer;
    }

}

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        ParkingLot parkingLot = new ParkingLot(fees);
        for (String value : records) {
            String[] info = value.split(" ");
            parkingLot.record(info);
        }
        return parkingLot.print();
    }
    
}
