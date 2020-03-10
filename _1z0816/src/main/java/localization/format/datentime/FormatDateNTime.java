package localization.format.datentime;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormatDateNTime {
   public static void main(String[] args) {
      LocalDate date0 = LocalDate.of(2020, Month.JANUARY, 20);
      System.out.println(date0.getDayOfWeek()); // MONDAY
      System.out.println(date0.getMonth()); // JANUARY
      System.out.println(date0.getYear()); // 2020
      System.out.println(date0.getDayOfYear()); // 20

      System.out.println("----------------------- DateTimeFormatter ENUM");

      LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
      LocalTime time = LocalTime.of(11, 12, 34);
      LocalDateTime dateTime = LocalDateTime.of(date, time);
      System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // 2020-01-20
      System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME)); // 11:12:34
      System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)); // 2020-01-20T11:12:34

      System.out.println("-----------------------DateTimeFormatter ofLocalizedDate through formatter");

      DateTimeFormatter shortDateTime0 =
              DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
      System.out.println(shortDateTime0.format(dateTime)); // 1/20/20
      System.out.println(shortDateTime0.format(date)); // 1/20/20
      // System.out.println(shortDateTime0.format(time)); // UnsupportedTemporalTypeException

      // same as above (all formats)

      System.out.println("-----------------------DateTimeFormatter ofLocalizedDate through values");

      DateTimeFormatter shortDateTime =
              DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
      System.out.println(dateTime.format(shortDateTime));
      System.out.println(date.format(shortDateTime));
      // System.out.println(time.format(shortDateTime)); // UnsupportedTemporalTypeException

      System.out.println("-----------------------FormatStyle SHORT or MEDIUM");

      DateTimeFormatter shortF = DateTimeFormatter
              .ofLocalizedDateTime(FormatStyle.SHORT);
      DateTimeFormatter mediumF = DateTimeFormatter
              .ofLocalizedDateTime(FormatStyle.MEDIUM);
      System.out.println(shortF.format(dateTime)); // 1/20/20 11:12 AM
      System.out.println(mediumF.format(dateTime)); // Jan 20, 2020 11:12:34 AM

      System.out.println("-----------------------DateTimeFormatter.ofPattern 'XXXXX' ");

      DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MMMM-dd, , hh:mm"); // pattern of you need :)
      System.out.println(dateTime.format(f)); // January 20, 2020, 11:12


      System.out.println("-----------------------DateTimeFormatter.ofPattern hh:mm");
      DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh:mm", new Locale("", ""));  // locale
      System.out.println(f2.format(dateTime));
      //System.out.printf(f2.format(date)); // Runtime  UnsupportedTemporalTypeException: Unsupported field: ClockHourOfAmPm
      System.out.println(f2.format(time));

      System.out.println("-----------------------DateTimeFormatter as a parse parameter");

      DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MM dd yyyy");
      LocalDate date1 = LocalDate.parse("01 02 2015", f1);
      LocalTime time1 = LocalTime.parse("11:22");
      System.out.println(date1); // 2015–01–02
      System.out.println(time1); // 11:22

      System.out.println("------------------------------------");

//      LocalDate d = LocalDate.now();
//      DateFormat df = new DateFormat(DateFormat.LONG);
//      System.out.println(df.format(d))
   }
}
