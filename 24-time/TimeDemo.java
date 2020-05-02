import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeDemo {

    public static void main(String... args){

        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        LocalDateTime nowDateTime = LocalDateTime.of(nowDate,nowTime);

        System.out.println(nowDateTime);

        nowDateTime = LocalDateTime.now();

        LocalDate someDate = LocalDate.of(2020, 4 , 1);
        someDate = LocalDate.parse("2020-02-01"); // iso-8601
        
    }
}
