class Solution {
    class Person implements Comparable<Person> {
        String name;
        int height;
        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
        public String getName() {
            return this.name;
        }
        public int getHeight() {
            return this.height;
        }
        @Override
        public int compareTo(Person p) {
            return Integer.compare(p.height, height);
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Person[] person = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            person[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(person);
        String[] answer = new String[names.length];
        for (int i = 0; i < person.length; i++) {
            answer[i] = person[i].name;
        }
        return answer;
    }
}