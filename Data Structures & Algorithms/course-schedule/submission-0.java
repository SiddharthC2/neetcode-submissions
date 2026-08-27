class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final List<Integer>[] prereqArr = new ArrayList[numCourses];
        final boolean[] visited = new boolean[numCourses];
        final boolean[] isTraversed = new boolean[numCourses];
        for (int course = 0; course < numCourses; course++) {
            prereqArr[course] = new ArrayList<>();
        }

        for (int[] prereq: prerequisites) {
            prereqArr[prereq[1]].add(prereq[0]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == false) {
                if (dfsCycle(course, prereqArr, visited, isTraversed) == true) return false;
            }
        }
        return true;
    }

    private boolean dfsCycle(
        final int course,
        final List<Integer>[] prereqArr,
        final boolean[] visited,
        final boolean[] isTraversed
    ) {
        visited[course] = true;
        isTraversed[course] = true;
        for (Integer prereq: prereqArr[course]) {
            if (visited[prereq] == false) {
                if(dfsCycle(prereq, prereqArr, visited, isTraversed)) return true;
            }
            else if (isTraversed[prereq] == true) {
                return true;
            }
        }
        isTraversed[course] = false;
        return false;
    }
}
