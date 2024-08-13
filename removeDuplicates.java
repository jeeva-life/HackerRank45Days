int rmDuplicates(int arr[], int n)
{
    int i;
    int count=1;
    if(n==1 || n==0){
        return n;
    }
    for(i=0;i<=n-2;i++){
        if(arr[i]!=arr[i+1]){
            count+=1;
        }
    }
    return count;

}