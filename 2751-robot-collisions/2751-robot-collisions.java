class Solution {
    class Robot implements Comparable<Robot> {
        int position;
        int health;
        char direction;
        int index;
        public Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
        @Override
        public int compareTo(Robot robot) {
            return this.position - robot.position;
        }
    }
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> listRobot = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            listRobot.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        Collections.sort(listRobot);
        Stack<Robot> stack = new Stack<>();
        for (Robot robot : listRobot) {
            if (robot.direction == 'R') stack.push(robot);
            else {
                while (!stack.empty() && stack.peek().direction == 'R' && healths[robot.index] > 0) {
                    Robot topRobot = stack.pop();
                    if (healths[robot.index] > healths[topRobot.index]) {
                        healths[robot.index] -= 1;
                        healths[topRobot.index] = 0;
                    }
                    else if (healths[topRobot.index] > healths[robot.index]) {
                        healths[topRobot.index] -= 1;
                        healths[robot.index] = 0;
                        stack.push(topRobot);
                    }
                    else {
                        healths[topRobot.index] = 0;
                        healths[robot.index] = 0;
                    }
                }
                if (healths[robot.index] > 0) stack.push(robot);
            }
        }
        List<Integer> listAnswer = new ArrayList<>();
        for (int i = 0; i < healths.length; i++) {
            if (healths[i] > 0) listAnswer.add(healths[i]);
        }
        return listAnswer;
    }
}