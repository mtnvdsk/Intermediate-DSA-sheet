class HelloWorld {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -4, -1, 4};
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && arr[i] > 0) {
                int j = i + 1;
                while (j < n) {
                    if (arr[j] < 0) {
                        rotate(arr, n, i, j);
                        break;
                    }
                    j++;
                }
            }
            else if(i%2!=0 && arr[i]<0){
                int j = i + 1;
                while (j < n) {
                    if (arr[j] > 0) {
                        rotate(arr, n, i, j);
                        break;
                    }
                    j++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void rotate(int arr[], int n, int outofplace, int cur) {
        int tmp = arr[cur];
        for (int i = cur; i > outofplace; i--) {
            arr[i] = arr[i - 1];
        }
        arr[outofplace] = tmp;
    }
}
