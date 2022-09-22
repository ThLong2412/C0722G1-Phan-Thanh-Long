package ss13_search.practice;

public class BinarySearch {
    static int [] arr = {2,4,7,9,15,18,20,26,28,35,39,40,55,60,68,74,79};

    public static int binarySearch(int [] arr, int keyFind) {
        int left = 0;
        int right = arr.length -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (keyFind == arr[mid]) {
                return mid;
            } else if (keyFind > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(arr,28));
    }
}
