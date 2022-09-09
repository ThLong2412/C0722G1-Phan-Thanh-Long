package ss4_class_and_oop_in_java.exersice.stop_watch;

import java.time.LocalTime;

public class StopWatch {
   private LocalTime startTime, endTime;
   public StopWatch() {
   }
   public StopWatch(LocalTime starTime, LocalTime endTime) {
       this.startTime = starTime;
       this.endTime = endTime;
   }
   public LocalTime getStartTime() {
       startTime = java.time.LocalTime.now();
       return startTime;
   }
   public LocalTime getEndTime () {
       endTime = java.time.LocalTime.now();
       return endTime;
   }
}
