public class Main {
    public static void main(String[] args) {
        String input = "0000111101001001"; //error at 10

        Hamming(input);
    }

    public static void Hamming(String input) {
        int parity0 = valueAt(input, 0);
        int parity1 = valueAt(input, 1);
        int parity2 = valueAt(input, 2);
        int parity4 = valueAt(input, 4);
        int parity8 = valueAt(input, 8);

        boolean p0, p1, p2, p4, p8;

        int sum0 = 0, sum1 = 0, sum2 = 0, sum4 = 0, sum8 = 0;
        for (int i=1; i<16; i++) {
            int num = valueAt(input, i);
            sum0 += num;
            if (i%2 == 1 && i!=1) sum1 += num;
            if (i%4 >= 2 && i!=2) sum2 += num;
            if ((i/4)%2 == 1 && i!=4) sum4 += num;
            if ((i/4) >= 2 && i!=8) sum8 += num;
        }
        if (sum0%2 == parity0) {
            System.out.println("Parity 0 is correct");
            p0 = true;
        } else {
            System.out.println("Parity 0 is incorrect");
            p0 = false;
        }

        if (sum1%2 == parity1) {
            System.out.println("Parity 1 is correct");
            p1 = true;
        } else {
            System.out.println("Parity 1 is incorrect");
            p1 = false;
        }

        if (sum2%2 == parity2) {
            System.out.println("Parity 2 is correct");
            p2 = true;
        } else {
            System.out.println("Parity 2 is incorrect");
            p2 = false;
        }

        if (sum4%2 == parity4) {
            System.out.println("Parity 4 is correct");
            p4 = true;
        } else {
            System.out.println("Parity 4 is incorrect");
            p4 = false;
        }

        if (sum8%2 == parity8) {
            System.out.println("Parity 8 is correct");
            p8 = true;
        } else {
            System.out.println("Parity 8 is incorrect");
            p8 = false;
        }

        int incorrectParities = 0;
        if (!p1) incorrectParities++;
        if (!p2) incorrectParities++;
        if (!p4) incorrectParities++;
        if (!p8) incorrectParities++;

        int position = 0;
        if (!p0 && incorrectParities == 1) {
            if (!p1) position = 1;
            if (!p2) position = 2;
            if (!p4) position = 4;
            if (!p8) position = 8;
        } else {
            int row = 0, column = 0;
            if (p1 && p2) column = 0;
            if (!p1 && p2) column = 1;
            if (p1 && !p2) column = 2;
            if (!p1 && !p2) column = 3;

            if (p4 && p8) row = 0;
            if (!p4 && p8) row = 1;
            if (p4 && !p8) row = 2;
            if (!p4 && !p8) row = 3;

            position = row*4 + column;
        }

        System.out.println("Error at position " + position + ".");

        if (p0) {
            System.out.println("no errors, or an even number.");
        } else {
            System.out.println("There was 1 or an odd number of errors");
        }
        System.out.println("\n----------\n\n");
    }

    public static void Hamming2(String input) {

    }

    public static int valueAt (String input, int index) {
        return Integer.parseInt(input.substring(index,index+1));
    }
}
