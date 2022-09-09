package ss4_class_and_oop_in_java.exersice.stop_watch;


public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public StopWatch(long starTime, long endTime) {
        this.startTime = starTime;
        this.endTime = endTime;
    }

    public long start() {
        this.startTime = System.currentTimeMillis();
        return startTime;
    }

    public long stop() {
        this.endTime = System.currentTimeMillis();
        return endTime;
    }

    public long getElapsedTime() {
        long pastTime = endTime - startTime;
        return pastTime;
    }
}
