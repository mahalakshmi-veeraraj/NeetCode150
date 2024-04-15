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
        int n = position.length;
        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            Car car = new Car(position[i], (double) (target - position[i]) / speed[i]);
            cars[i] = car;
        }
        Arrays.sort(cars, ((car1, car2) -> car2.position - car1.position));
        Stack<Double> stack = new Stack<>();
        stack.add(cars[0].time);
        for (int i = 1; i < n; i++) {
            if (stack.peek() < cars[i].time) {
                stack.push(cars[i].time);
            }
        }
        return stack.size();
    }
}