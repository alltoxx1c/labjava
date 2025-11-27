package lab5;

public class lab51 {

    static class IntegerSet {
        private boolean[] a; // множество (0–100)

        public IntegerSet() {
            a = new boolean[101]; // всё false
        }

        public void insertElement(int k) {
            if (k >= 0 && k <= 100) a[k] = true;
        }

        public void deleteElement(int m) {
            if (m >= 0 && m <= 100) a[m] = false;
        }

        public static IntegerSet union(IntegerSet s1, IntegerSet s2) {
            IntegerSet result = new IntegerSet();
            for (int i = 0; i <= 100; i++) {
                result.a[i] = s1.a[i] || s2.a[i];
            }
            return result;
        }

        public static IntegerSet intersection(IntegerSet s1, IntegerSet s2) {
            IntegerSet result = new IntegerSet();
            for (int i = 0; i <= 100; i++) {
                result.a[i] = s1.a[i] && s2.a[i];
            }
            return result;
        }

        public boolean isEqualTo(IntegerSet other) {
            for (int i = 0; i <= 100; i++) {
                if (this.a[i] != other.a[i]) return false;
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            boolean empty = true;

            for (int i = 0; i <= 100; i++) {
                if (a[i]) {
                    sb.append(i).append(" ");
                    empty = false;
                }
            }

            return empty ? "---" : sb.toString();
        }
    }

    public static void main(String[] args) {

        IntegerSet s1 = new IntegerSet();
        IntegerSet s2 = new IntegerSet();

        s1.insertElement(1);
        s1.insertElement(3);
        s1.insertElement(5);

        s2.insertElement(3);
        s2.insertElement(4);
        s2.insertElement(5);
        s2.insertElement(10);

        System.out.println("Множество S1: " + s1);
        System.out.println("Множество S2: " + s2);

        IntegerSet union = IntegerSet.union(s1, s2);
        System.out.println("Объединение: " + union);

        IntegerSet inter = IntegerSet.intersection(s1, s2);
        System.out.println("Пересечение: " + inter);

        System.out.println("S1 равно S2? → " + s1.isEqualTo(s2));

        s1.deleteElement(3);
        System.out.println("S1 после удаления 3: " + s1);

        System.out.println("S1 равно S2? → " + s1.isEqualTo(s2));
    }
}
