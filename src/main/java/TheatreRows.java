import java.util.LinkedHashMap;
import java.util.Map;

public class TheatreRows {
    private static Map<String, Long> seats;

    static {
        String[] letterArray = "abcdefghijklmnopqrstuvwxyz".split("");
        seats = new LinkedHashMap<>();
        for (int i = 1; i <= 30; i++) {
            for (int y = 0; y < letterArray.length; y++) {
                seats.put(i + letterArray[y], null);
            }
        }
    }

    private static void reserveSeats(int numberOfSeats) throws InterruptedException {
        for (int i = 1; i <= numberOfSeats; i++) {
            boolean reserved = false;
            for (Map.Entry<String, Long> entry : seats.entrySet()) {
                if (entry.getValue() == null) {
                    entry.setValue(System.currentTimeMillis());
                    reserved = true;
                    Thread.sleep(2000L);
                    break;
                }
            }
            if (!reserved) {
                System.out.println("Could not reserve for " + i + ". customer!");
            }
        }
    }

    private static long getReservedSeatsInTimeFrame(long startTime, long endTime) {
        return seats.values().stream().filter(v -> v != null && v >= startTime && v <= endTime).count();
    }

    public static void main(String[] args) throws InterruptedException {
        reserveSeats(5);
        System.out.println(seats);
        Thread.sleep(3000L);
        long startDate = System.currentTimeMillis()-6000L;
        long endDate = System.currentTimeMillis();
        System.out.println("StartDate "+startDate+", endDate: "+endDate);
        System.out.println(getReservedSeatsInTimeFrame(startDate,endDate));
    }

}
