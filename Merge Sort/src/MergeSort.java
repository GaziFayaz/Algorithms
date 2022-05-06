//package com.company;//package com.company;

class MergeSort {

    public void merge(int arr[], int l, int m, int r) {
        int n1, n2;
        n1 = m-l +1;
        n2 = r-m;

        int lArr[] = new int[n1];
        int rArr[] = new int[n2];

        for(int i = 0 ; i< n1; ++i){
            lArr[i] = arr[l+i];
        }

        for(int j = 0; j<n2; ++j){
            rArr[j] = arr[m+1+j];
        }

        int i = 0, j=0;

        int k = l;

        while(i<n1 && j<n2){
            if(lArr[i] <= rArr[j]){
                arr[k] = lArr[i];
                i++;
            }
            else{
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }
        //if any element of left array remaining
        while(i<n1){
            arr[k] = lArr[i];
            i++;
            k++;
        }

        //if any element of right array remaining
        while(j<n2){
            arr[k] = rArr[j];
            j++;
            k++;
        }

    }

    public void sort(int arr[], int l, int r){

        if(l<r){
            int m = l+ (r-l)/2;

            sort(arr, l, m);
            sort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }

    public static void printArr(int arr[]){
        for(int i= 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
	    int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArr(arr);

        System.out.println("Sorted Array");
        MergeSort m1 = new MergeSort();
        m1.sort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
