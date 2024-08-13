int removeElement(int arr[], int n, int val)
{
    int temp = 0;
    for(int i=0;i<n;i++){
        if(arr[i] != val){
            arr[temp] = arr[i];
            temp+=1;
        }
    }
    return temp;
}
