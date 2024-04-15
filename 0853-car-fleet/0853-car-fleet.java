class Solution {
    class Car {
        int position;
        double time;
        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int answer = 0;
        int n = position.length;
        if (n <= 1) return n;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            Car car = new Car(position[i], (double) (target - position[i]) / speed[i]);
            cars[i] = car;
        }
        Arrays.sort(cars, ((car1, car2) -> car2.position - car1.position));
        double previousTime = 0;
        double currentTime = 0;
        for (int i = 0; i < n; i++) {
            currentTime = cars[i].time;
            if (currentTime > previousTime) {
                ++answer;
            }
            previousTime = Math.max(previousTime, currentTime);
        }
        return answer;
    }
}



// target = 12
    
// Position    10 8 0  5 3
// Speed       2  4 1  1 3
// Time        1  1 12 7 3
    

// target = 100
// Position    0,2,4
// Speed       4,2,1

// After sorting the position  4,   2,  0
//                   Speed     1,   2,  4
//                   Time      96,  49, 25

// target = 10
// Position                         6, 8
// Speed                            3, 2
// After sorting the position       8, 6
// Time                             0, 2