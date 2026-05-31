class Solution {
    public boolean asteroidsDestroyed(int amass, int[] asteroids) {
        
        Arrays.sort(asteroids);
        long mass = amass;

        for(int x:asteroids){
            if(mass<x){
                return false;
            }
            mass+=x;
        }
        return true;
    }
}