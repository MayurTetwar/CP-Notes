package Concepts;

import java.util.*;

class Item implements Comparable<Item>{
    int rate;
    String name;

    Item(int rate, String name){
        this.rate = rate;
        this.name = name;
    }

    void display(){
        System.out.println("rate " + rate);
        System.out.println("name " + name);
    }

    @Override
    public int compareTo(Item o) {
        return rate - o.rate; // Sort in ascending order by default
    }
}

public class Sortcompare {
    public static void main(String args[]) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(7,"Mayur"));
        items.add(new Item(5,"Priya"));
        items.add(new Item(6,"Neha"));

        for(Item i : items) {
            i.display();
        }
        System.out.println();

        Collections.sort(items);
        for(Item i : items) {
            i.display();
        }
        System.out.println();

        Collections.sort(items, new SortByRate());
        for(Item i : items) {
            i.display();
        }
        System.out.println();

        Collections.sort(items, new SortByName());
        for(Item i : items) {
            i.display();
        }
        System.out.println();
    }
}

class SortByRate implements Comparator<Item> {
    public int compare(Item ob1, Item ob2) {
        return ob1.rate - ob2.rate;
    }
}

class SortByName implements Comparator<Item> {
    public int compare(Item ob1, Item ob2) {
        return ob1.name.compareTo(ob2.name);
    }
}