package Lab2;

class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public int getMonth() { return month; }
    public void setMonth(int month) {
        if (month >= 1 && month <= 12)
            this.month = month;
        else {
            this.month = 1; // по умолчанию
            System.out.println("Некорректный месяц. Установлен месяц по умолчанию: 1");
        }
    }

    public int getDay() { return day; }
    public void setDay(int day) {
        if (day >= 1 && day <= 31)
            this.day = day;
        else {
            this.day = 1;
            System.out.println("Некорректный день. Установлен день по умолчанию: 1");
        }
    }

    public int getYear() { return year; }
    public void setYear(int year) {
        if (year >= 0)
            this.year = year;
        else {
            this.year = 2000;
            System.out.println("Некорректный год. Установлен год по умолчанию: 2000");
        }
    }

    public void displayDate() {
        System.out.println(month + "/" + day + "/" + year);
    }
}

public class lab23 {
    public static void main(String[] args) {
        Date date1 = new Date(3, 15, 2025);
        Date date2 = new Date(13, 32, -5); // некорректные значения

        System.out.print("Дата 1: ");
        date1.displayDate();

        System.out.print("Дата 2: ");
        date2.displayDate();

        date2.setMonth(12);
        date2.setDay(25);
        date2.setYear(2023);

        System.out.print("Дата 2 после исправления: ");
        date2.displayDate();
    }
}

