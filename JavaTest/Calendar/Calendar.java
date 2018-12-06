package calendar;

import java.util.Scanner;

public class Calendar
{
    private static int numDays = 0;
    private static int h = 0;
    public static boolean leap(int year)
    {
        if(((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void firstDayOfYear(int year)
    {
        int month = 13;
        year--;
        h = (1 + (int)(((month + 1) * 26) / 10.0) + year + (int)(year / 4.0) + 6 * (int)(year / 100.0) + (int)(year / 400.0)) % 7;
        String dayName = "";
        switch(h)
        {
            case 0: dayName = "土曜日"; break;
            case 1: dayName = "日曜日"; break;
            case 2: dayName = "月曜日"; break;
            case 3: dayName = "火曜日"; break;
            case 4: dayName = "水曜日"; break;
            case 5: dayName = "木曜日"; break;
            default: dayName = "金曜日"; break;
        }
        System.out.println("今年の最初の日は： " + dayName);
    }
    public static void firstDayOfMonth(int month, int year)
    {
        if(month == 1 || month == 2)
        {
            month += 12;
            year--;
        }
        h = (1 + (int)(((month + 1) * 26) / 10.0) + year + (int)(year / 4.0) + 6 * (int)(year / 100.0) + (int)(year / 400.0)) % 7;
        String dayName = "";
        switch(h)
        {
            case 0: dayName = "土曜日"; break;
            case 1: dayName = "日曜日"; break;
            case 2: dayName = "月曜日"; break;
            case 3: dayName = "火曜日"; break;
            case 4: dayName = "水曜日"; break;
            case 5: dayName = "木曜日"; break;
            default: dayName = "金曜日"; break;
        }
        System.out.println("今月の最初の日は： " + dayName);
    }
    public static void numDaysInMonth(int month, int year)
    {
        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (month == 2 && leap(year)) days[month] = 29;
        numDays = days[month];
        System.out.println("その月の日数は： " + numDays);
    }
    public static void printCal(int month, int year)
    {
        String[] monthNames = {"","一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};

        System.out.println("    " + monthNames[month] + " " + year);
        System.out.println("日 月 火 水 木 金 土");
        for (int i = 0; i < h - 1; i++)
            System.out.print("   ");
        for (int i = 1; i <= numDays; i++)
        {
            System.out.printf("%2d ", i);
            if (((i + h - 1) % 7 == 0) || (i == numDays)) System.out.println();
        }
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("月を入力してください (1-12): ");
        int month = input.nextInt();
        if(month < 1 || month > 12)
        {
            System.out.println("月が無効です。有効な入力は1-12です。");
            System.exit(0);
        }
        System.out.print("年を入力してください： ");
        int year = input.nextInt();
        if(year < 1753)
        {
            System.out.println("無効な年です。有効な入力は1753以降です。");
            System.exit(0);
        }
        if(leap(year))
        {
            System.out.println(year + " はうるう年です。");
        }
        else
        {
            System.out.println(year + " はうるう年じゃありません。");
        }
        firstDayOfYear(year);
        firstDayOfMonth(month, year);
        numDaysInMonth(month, year);
        printCal(month, year);
    }    
}