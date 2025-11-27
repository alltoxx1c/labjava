package lab5;

public class lab52 {

    static class Rational {
        private int numerator;
        private int denominator;

        public Rational() {
            this(0, 1); // значение по умолчанию 0/1
        }

        public Rational(int numerator, int denominator) {
            if (denominator == 0) {
                throw new IllegalArgumentException("Знаменатель не может быть нулём!");
            }

            if (denominator < 0) {
                numerator = -numerator;
                denominator = -denominator;
            }

            int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }

        public static Rational add(Rational r1, Rational r2) {
            int num = r1.numerator * r2.denominator + r2.numerator * r1.denominator;
            int den = r1.denominator * r2.denominator;
            return new Rational(num, den);
        }

        public static Rational subtract(Rational r1, Rational r2) {
            int num = r1.numerator * r2.denominator - r2.numerator * r1.denominator;
            int den = r1.denominator * r2.denominator;
            return new Rational(num, den);
        }

        public static Rational multiply(Rational r1, Rational r2) {
            int num = r1.numerator * r2.numerator;
            int den = r1.denominator * r2.denominator;
            return new Rational(num, den);
        }

        public static Rational divide(Rational r1, Rational r2) {
            if (r2.numerator == 0) {
                throw new ArithmeticException("Деление на дробь с числителем 0 невозможно!");
            }
            int num = r1.numerator * r2.denominator;
            int den = r1.denominator * r2.numerator;
            return new Rational(num, den);
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }

        public String toFloat(int digits) {
            double value = (double) numerator / denominator;
            return String.format("%." + digits + "f", value);
        }
    }

    public static void main(String[] args) {

        Rational r1 = new Rational(2, 4);
        Rational r2 = new Rational(3, 9);

        System.out.println("r1 = " + r1 + " = " + r1.toFloat(4));
        System.out.println("r2 = " + r2 + " = " + r2.toFloat(4));

        Rational sum = Rational.add(r1, r2);
        Rational diff = Rational.subtract(r1, r2);
        Rational prod = Rational.multiply(r1, r2);
        Rational quot = Rational.divide(r1, r2);

        System.out.println("\nОперации:");
        System.out.println("Сложение:        " + sum + " = " + sum.toFloat(5));
        System.out.println("Вычитание:       " + diff + " = " + diff.toFloat(5));
        System.out.println("Умножение:       " + prod + " = " + prod.toFloat(5));
        System.out.println("Деление:         " + quot + " = " + quot.toFloat(5));
    }
}
