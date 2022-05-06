import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high );

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high], i = low, j = high;
        while(i<j){
            while(arr[i] <= pivot && i < j){
                i++;
            }
            while(arr[j] >= pivot && i < j){
                j--;
            }
            swap(arr, i, j );
        }
        swap(arr, i, high);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for(int i = 0; i< numbers.length; i++){
            numbers[i]  = rand.nextInt(100);
        }

        System.out.println("Before:");
        for(int i = 0; i<numbers.length;i++){
            System.out.print(numbers[i] + " ");

        }
        System.out.println();

        quickSort(numbers, 0, numbers.length-1);

        System.out.println("After:");
        for(int i = 0; i<numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }

    }
}
