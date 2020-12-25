package org.dgf.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicSortingAlgm {
    static Logger log = LoggerFactory.getLogger(BasicSortingAlgm.class);


    public static void main(String[] argvs) {
        int[] n2 = {4,3,2,1,10,5,8,6,7,9};
        quick_sort(n2,0,n2.length-1);
        log.info("{}", n2);
        int[] n = {4,3,2,1,10,5,8,6,7,9};
        quickSort(n,0,n.length-1);
        log.info("{}", n);


    }
    //Insert Sort
    public static void insertSort(int[] A)
    {
        int i = 1, j = 0;
        while (i < A.length) {
            int m = A[i];
            j = 0;
            while(j < i && A[j] < m) {
                j++;
            }

            int n = i;
            while (n > j) {
                A[n] = A[n-1];
                n--;
            }
            A[j] = m;
            i++;
        }
    }

    public static void insertSortV2(int[] A)
    {
        int i = 1, j = 0;
        while (i < A.length) {
            int key = A[i];
            j = i-1;
            while(j >= 0 && A[j] > key) {
                A[j + 1] = A[j];
                j--;
            }
            A[j+1]=key;
            i++;
        }
    }

    //Quick Sort
    public static void quickSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start, h = end;
        int pivot = A[(l + h) / 2];
log.info("{},{},{}, {}", l , h , pivot, A);
        while (l <= h) {
            while (l<=h && A[l] < pivot) {
                l++;
            }
            while (l <=h && A[h] > pivot) {
                h--;
            }
            //if(l==h) break;
            if(l <= h)
            {
                int tmp = A[l];
                A[l] = A[h];
                A[h] = tmp;
                l++;
                h--;
            }


        }
        quickSort(A, start, l-1);
        quickSort(A, l, end);
    }
    public static void quick_sort(int[] n, int l, int h)
    {
        if (l >= h) return;
        int pivot = n[(l+h)/2];
        int i = l, j = h;
        log.info("{},{},{}, {}", i , j , pivot, n);
        while(i <= j) {
            if (n[i] < pivot) {
                i++;
                continue;
            }
            if (n[j] > pivot) {
                j--;
                continue;
            }
            //if (i <= j)
            {
                int tmp = n[i];
                n[i] = n[j];
                n[j] = tmp;
                i++;

                j--;
            }
        }
        quick_sort(n, l, i-1);
        quick_sort(n,i, h);
    }
    //Merge Sort
    public static void mergeSort(int[] A) {

    }

    //Heap Sort
    public static void heapSort(int[] A) {

    }
}
