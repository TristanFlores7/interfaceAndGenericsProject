public class HashNumSet <E extends Number> implements NumSet<E>{
    int capacity;
    int index;

    private Number[] numSet;

    public HashNumSet(int initialCapacity){
        this.capacity = initialCapacity;
        numSet = new Number[capacity];
    }

    private int hash(Number element){
        int ele = element.intValue();
        index = ele % capacity;
        return index;
    }

    @Override
    public boolean add(E e) {
        //checks if value is unique to array
        boolean tester = !contains(e);
        //increases capacity of array if number of elements and array length are equal
        numSet[size()] = e;
        if(size() > (capacity * 0.75)){
            capacityIncrease();
        }
        //adds value to end of array otherwise
        return tester;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public boolean contains(E e) {
        boolean tester = false;
        //compares array elements to method parameter
        for(int i = 0; i < numSet.length; i++){
            if(e.equals(numSet[i])){
                tester = true; //changes boolean value if element is found in the array
                break;
            }
        }
        return tester;
    }

    @Override
    public boolean remove(E e) {
        boolean tester = false;
        for (int i = 0; i < size(); i++) {
            //finds index where element that is to be removed exists
            if (e.equals(numSet[i])) {
                //changes boolean value if element is found in the array
                tester = true;
                for (int j = i; j < size(); j++) {
                    //shift all elements after the removed element one index to the "left"
                    numSet[j] = numSet[j + 1];
                }
                break;
            }
        }
        if(e.equals(null)){
            throw new NullPointerException();
        }
        return tester;
    }

    @Override
    public int size() {
        //tracks number of elements counted in array
        int duplicates = 0;
        int counter= 0;
        //loop to search array for elements
        for(int i = 0; i < numSet.length; i++){
            //increments counter as long as elements in array continue to be found
            if(numSet[i] == null){
                break;
            }else{
                counter++;
            }
        }
        for(int i = 0; i < counter; i++){
            for(int j = i + 1; j < counter; j++){
                if(numSet[i] == numSet[j]){
                    duplicates++;
                }
            }
        }
        return (counter - duplicates);
    }

    public void capacityIncrease(){
        capacity = capacity * 2;
        //temporary array with new capacity to hold current array values
        Number[] tempArr = new Number[capacity];
        //loop to copy value in old array to new one
        for(int i = 0; i < capacity/2; i++){
            tempArr[i] = numSet[i];
        }
        //reinitialization of numSet array
        numSet = tempArr;
    }
}
