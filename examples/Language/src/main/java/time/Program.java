package time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Program {
    public static void main(String [] args) {
        demoTimes();
        printDivider();
        demoDates();
        printDivider();
        demoCreatingDates();
        printDivider();
        demoPeriods();
    }
	private static void printDivider() {
        System.out.println("-----------");
    }
    private static void demoCreatingDates() {
        LocalDateTime pointInTime = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        printDate(pointInTime);    
        pointInTime = pointInTime.plusSeconds(1);
        printDate(pointInTime); 
    }
    private static void printDate(LocalDateTime pointInTime) {
        String message = "%s %d of %s %d";
        System.out.println(String.format(message,
						                pointInTime.getDayOfWeek(),
						                pointInTime.getDayOfMonth(),
						                pointInTime.getMonth(),
						                pointInTime.getYear()));
    }
    private static void demoDates() {
        DateTimeFormatter dtf = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.LONG)
                .withLocale(Locale.ENGLISH);
        
        LocalDate todayInParis = LocalDate.now(ZoneId.of("Europe/Paris"));
        LocalDate todayInMoscow = LocalDate.now(ZoneId.of("Europe/Moscow"));
        LocalDate todayInTokyo = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        LocalDate todayInSydney = LocalDate.now(ZoneId.of("Australia/Sydney"));
        LocalDate todayOnEasterIsland = LocalDate.now(ZoneId.of("Pacific/Easter"));
        LocalDate todayInMichigan = LocalDate.now(ZoneId.of("US/Michigan"));
          
        System.out.println(dtf.format(todayInParis));        
        System.out.println(dtf.format(todayInMoscow));
        System.out.println(dtf.format(todayInTokyo));
        System.out.println(dtf.format(todayOnEasterIsland));
        System.out.println(dtf.format(todayInSydney));
        System.out.println(dtf.format(todayInMichigan));
    }
    private static void demoTimes() {
        DateTimeFormatter dtf = DateTimeFormatter
					                .ofLocalizedTime(FormatStyle.SHORT)
					                .withLocale(Locale.ENGLISH);
        
        LocalTime nowInParis = LocalTime.now(ZoneId.of("Europe/Paris"));
        LocalTime nowInBahrain = LocalTime.now(ZoneId.of("Asia/Bahrain"));
        LocalTime nowInLondon = LocalTime.now(ZoneId.of("Europe/London"));
        LocalTime nowInMoscow = LocalTime.now(ZoneId.of("Europe/Moscow"));
        LocalTime nowInTokyo = LocalTime.now(ZoneId.of("Asia/Tokyo"));
          
        System.out.println(dtf.format(nowInLondon));
        System.out.println(dtf.format(nowInParis));
        System.out.println(dtf.format(nowInBahrain));
        System.out.println(dtf.format(nowInMoscow));
        System.out.println(dtf.format(nowInTokyo));
    }
    private static void demoPeriods() {
		LocalDate now = LocalDate.now();
		LocalDate endOfYear = now.withDayOfMonth(31).withMonth(12);
		Period nowTillThen = Period.between(now, endOfYear);
		
		String msg = "There are %d months and %d days remaining this year\n";
		System.out.printf(msg, nowTillThen.getMonths(), nowTillThen.getDays());
	}
}
