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
        int distinctCarFleets = 0;
        int carCount = position.length;
        CarDetails[] carDetails = new CarDetails[carCount];
        for (int i=0; i<carCount; i++) {
            carDetails[i] = new CarDetails();
            carDetails[i].position = position[i];
            carDetails[i].speed = speed[i];
            carDetails[i].timeToTarget = (double)(target-position[i])/speed[i];
        }

        Arrays.sort(carDetails, (a, b) -> Integer.compare(b.position, a.position));

        double currMax = 0d;
        for (CarDetails carDetail: carDetails) {
            // System.out.println(carDetail);
            if (carDetail.timeToTarget > currMax) {
                currMax = carDetail.timeToTarget;
                distinctCarFleets++;
            }
        }

        return distinctCarFleets;
    }
}
