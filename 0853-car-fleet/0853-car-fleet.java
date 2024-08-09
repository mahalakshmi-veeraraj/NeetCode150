class Solution {
    class Car implements Comparable<Car> {
        int speed;
        int position;
        public Car (int speed, int position) {
            this.speed = speed;
            this.position = position;
        }
        @Override
        public int compareTo (Car car) {
            
            return this.position - car.position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> listCar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listCar.add(new Car(speed[i], position[i]));
        }
        Collections.sort(listCar);
        
        int carFleet = position.length;
        float[] time = new float[n];
        for (int i = 0; i < n; i++) {
            time[i] = ((float) target - listCar.get(i).position) / listCar.get(i).speed;
        }
        int i = n - 1;
        while (i > 0) {
            float t = time[i];
            i--;
            while (i >= 0 && time[i] <= t) {
                carFleet--;
                i--;
            }
        }
        return carFleet;
    }
}