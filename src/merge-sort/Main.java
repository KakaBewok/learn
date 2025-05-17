public class Main {

    public static void main(String[] args) {
        int[] array = {6, 3, 8, 5, 2, 7};

        System.out.println("Sebelum diurutkan:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSetelah diurutkan:");
        printArray(array);
    }

    // Fungsi utama merge sort (rekursif)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Rekursi ke bagian kiri dan kanan
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            // Gabungkan dua bagian
            merge(arr, left, middle, right);
        }
    }

    // Fungsi untuk menggabungkan dua subarray terurut
    public static void merge(int[] arr, int left, int mid, int right) {
        // Panjang subarray kiri dan kanan
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Buat array sementara
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Salin data ke array sementara
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // Gabungkan array sementara ke array asli
        int i = 0, j = 0, k = left;

        // Bandingkan dan salin ke array utama
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Salin sisa elemen (jika ada)
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    // Cetak array ke console
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
