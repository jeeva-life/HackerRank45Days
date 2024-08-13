void moveZeroes(int arr[], int n)
{
    int start = 0;
    int end = n-1;
    
    while(start < end){
        if(arr[start] == 1 && arr[end] == 0){
            start++;
            end--;
        }
        else if(arr[start]==0 && arr[end] == 1){
            arr[start] = 1;
            arr[end] = 0;
            start++;
            end--;
        }
        else if(arr[start] == 0){
            end--;
        }else start++;
    }
}
