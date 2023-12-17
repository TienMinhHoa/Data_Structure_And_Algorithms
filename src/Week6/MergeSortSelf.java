package Week6;

public class MergeSortSelf {
    public static int[] arr = new int[20];
    public static void merge(int l, int r, int m){
        int n1 = m+1-l;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++){
            R[i] = arr[m+i+1];
        }
        int i = 0,j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
            } else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int l, int r){
        if(l < r){
            int mid = l+(r-l)/2;
            sort(l,mid);
            sort(mid+1,r);
            merge(l,r,mid);
        } else return;
    }
    public static void main(String[] args){
        for(int i = 10; i >=0; i--){
            arr[10-i] = i;
        }
        sort(0,10);
        for(int i = 0; i <= 10; i++){
            System.out.println(arr[i]);
        }
    }
}
