package time;

import util.Pair;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.lang.String.format;
import static java.time.DayOfWeek.FRIDAY;
import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.time.temporal.ChronoField.DAY_OF_WEEK;

public class Solution {
    public static void main(String[] args) {
        timeZonesInAfrica();
        theTimeInEastBrazil();
        differentTimesAcrossBrazil();
        howLongTillChristmas();
        howManyMondaysInThisMonth();
        ifGivenDateIsFri13th();
    }

    private static void timeZonesInAfrica() {
        System.out.println("All the African zones are:");
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.startsWith("Africa"))
                .map(s -> "\t" + s)
                .forEach(System.out::println);
    }

    private static void theTimeInEastBrazil() {
        LocalTime nowInBrazil = LocalTime.now(ZoneId.of("Brazil/East"));
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.ENGLISH);

        System.out.print("The time in East Brazil is:");
        System.out.printf("\t%s\n", dtf.format(nowInBrazil));
    }

    private static void differentTimesAcrossBrazil() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
                .withLocale(Locale.ENGLISH);

        System.out.println("Times across Brazil are:");
        String msg = "\tIn '%s' it is now %s";
        ZoneId.getAvailableZoneIds()
                .stream()
                .filter(s -> s.startsWith("Brazil"))
                .map(s -> new Pair<>(s, LocalTime.now(ZoneId.of(s))))
                .map(p -> format(msg, p.getFirst(), p.getSecond().format(dtf)))
                .forEach(System.out::println);
    }

    private static void howLongTillChristmas() {
        LocalDate now = LocalDate.now();
        LocalDate xmas = LocalDate.of(2017, Month.DECEMBER, 25);

        Period p = Period.between(now, xmas);
        System.out.printf("There are %d months and %d days till Christmas\n", p.getMonths(), p.getDays());
    }

    private static void howManyMondaysInThisMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
                .withLocale(Locale.UK);

        LocalDate now = LocalDate.now();
        LocalDate start = now.withDayOfMonth(1);
        LocalDate finish = now.withDayOfMonth(now.lengthOfMonth());

        List<LocalDate> mondays = new ArrayList<>();
        int count = 0;
        while (true) {
            if (start.getDayOfWeek() == DayOfWeek.MONDAY) {
                mondays.add(start);
                count++;
            }
            if (start.equals(finish)) {
                break;
            }
            start = start.plusDays(1);
        }
        System.out.printf("There are %d Mondays in this month:\n", count);
        mondays.stream()
                .map(dtf::format)
                .map(s -> "\t" + s)
                .forEach(System.out::println);
    }

    private static void ifGivenDateIsFri13th() {
        if (testIfDateIsFri13th(LocalDate.now())) {
            System.out.println("Eeeep! Today is Fri 13th");
        } else {
            System.out.println("Relax. Today is not Fri 13th");
        }
        if (testIfDateIsFri13th(LocalDate.of(2017, 1, 13))) {
            System.out.println("Fri 13th occurred in Jan 2017");
        } else {
            System.out.println("Fri 13th did not occur in Jan 2017");
        }
    }

    private static boolean testIfDateIsFri13th(LocalDate date) {
        TemporalQuery<Boolean> query = qa -> qa.get(DAY_OF_MONTH) == 13
                && qa.get(DAY_OF_WEEK) == FRIDAY.getValue();
        return date.query(query);
    }
}
