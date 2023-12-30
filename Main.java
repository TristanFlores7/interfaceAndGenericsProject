public class Main {
    public static void main(String[] args){
        NumSet<Integer> numSet = new HashNumSet<>(10);
        numSet.add(7);
        numSet.add(3);
        numSet.add(17);
        numSet.remove(22);
        System.out.println(numSet.capacity());
        System.out.println(numSet.size());

    }
}
