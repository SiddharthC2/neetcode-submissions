class Solution {

    private class CarDetails {
        int position;
        int speed;
        double timeToTarget;

        public String toString() {
            return position + " : " + speed + " : " + timeToTarget;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int carCount = position.length;
        CarDetails[] carDetails = new CarDetails[carCount];
        for (int i=0; i<carCount; i++) {
            carDetails[i] = new CarDetails();
            carDetails[i].position = position[i];
            carDetails[i].speed = speed[i];
            carDetails[i].timeToTarget = (double)(target-position[i])/speed[i];
        }

        Arrays.sort(carDetails, (a, b) -> Integer.compare(b.position, a.position));

        Deque<Double> stack = new ArrayDeque<>();
        double currMax;
        for (CarDetails carDetail: carDetails) {
            // System.out.println(carDetail);
            if (stack.isEmpty() || carDetail.timeToTarget > stack.peek()) {
                stack.push(carDetail.timeToTarget);
            }
        }

        return stack.size();
    }
}
