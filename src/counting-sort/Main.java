public class Main {

    public static void main(String[] args) {
        int[] array = {6, 3, 8, 5, 2, 7, 4, 1};

        System.out.println("Sebelum diurutkan:");
        printArray(array);

        countingSortDesc(array);

        System.out.println("\nSetelah diurutkan (desc):");
        printArray(array);
    }

    public static void countingSortDesc(int[] arr) {
        if (arr.length == 0) return;

        // 1. Temukan nilai maksimum
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        // 2. Buat array count (penyimpanan jumlah kemunculan)
        int[] count = new int[max + 1]; // count[i] = jumlah elemen bernilai i
        for (int num : arr) {
            count[num]++;
        }

        // 3. Bangun kembali array hasil (dari nilai tertinggi ke terendah)
        int index = 0;
        for (int i = max; i >= 0; i--) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
