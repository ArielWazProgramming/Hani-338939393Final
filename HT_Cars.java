import java.util.ArrayList;

class Car {
    private String m_made;
    private int m_year;

    public Car(String made, int year){
        m_made = made;
        m_year = year;
    }

    public String getM_made(){
        return m_made;
    }

    public int getM_year(){
        return m_year;
    }
}

class Node {
    int key;
    Car value;
    Node next;

    public Node(int key, Car value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable{
    private ArrayList<Node> bucketArray;
    private int numBuckets = 10;

    public HashTable()
    {
        bucketArray = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++){
            bucketArray.add(null);
        }
    }

    private int getBucketIndex(int key)
    {
        int index = key % numBuckets;
        return index;
    }

    public void add(int key, Car value){
        int bucketIndex = getBucketIndex(key);
        Node head = bucketArray.get(bucketIndex); //not get method but get method from ArrayList
        Node newNode = new Node (key, value);

        while (head != null){
            if (head.key == key){
                head.value = value; 
            }
            head = head.next;
        }

        head = bucketArray.get(bucketIndex);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
    }

    public Car get(int key){
        int bucketIndex = getBucketIndex(key);
        Node head = bucketArray.get(bucketIndex);

        while (head != null){
            if(head.key == key){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void remove(int key){
        int bucketIndex = getBucketIndex(key);
        Node head = bucketArray.get(bucketIndex);
        Node prev = null;

        while (head != null) {
            if (head.key == key){
                if (prev == null){
                    bucketArray.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void printHashTable(){
        for (int i = 0; i < numBuckets; i++){
            Node head = bucketArray.get(i);
            while (head != null){
                Car car = head.value;
                System.out.println("car make: " + car.getM_made() + " and year is: " + car.getM_year());
                head = head.next;
            }
        }
    }
}

public class HT_Cars {

    public static void main(String[] args) {
        HashTable hashCars = new HashTable(); 
        Car car1 = new Car ("Camry", 2023);
        //add and print
        hashCars.add(0,  car1);
        hashCars.add(2,  new Car("BMW", 2000));
        hashCars.add(3,  new Car("Subaru", 2010));
        hashCars.add(10,  new Car("Kia", 2018));
        hashCars.printHashTable();
        
        //remove and print
        hashCars.remove(3);
        System.out.println("\nNew list:");
        hashCars.printHashTable();
        
        //search 
        System.out.println("\nSearch for car with key 10");
        Car carSearch  = hashCars.get(10); 
        if (carSearch !=null)
            System.out.println("car found:\nmake: "+carSearch.getM_made()+" and year is: "+carSearch.getM_year());
        else
            System.out.println("Couldn't find the car");
        
         System.out.println("\nSearch for car with key 20");
        Car carSearch2  = hashCars.get(20); 
        if (carSearch2 !=null)
            System.out.println("car found:\nmake: "+carSearch2.getM_made()+" and year is: "+carSearch2.getM_year());
        else
            System.out.println("Couldn't find the car");
    }
    
}
