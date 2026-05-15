class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] drives=new double[n][2];
        for(int i=0;i<n;i++){
            drives[i][0]=position[i];
            drives[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(drives,(a,b)->Double.compare(b[0],a[0]));
        int count=0;
        double prevTime=0;
        for(double[] car:drives){
            if(car[1]>prevTime){
                count++;
                prevTime=car[1];
            }

        }
        return count;
        
    }
}
