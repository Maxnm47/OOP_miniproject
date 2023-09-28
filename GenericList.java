import java.util.ArrayList;

class GenericList<T>{
    private ArrayList<T> elems = new ArrayList<>();

    public void AddToList(T listitem){
        elems.add(listitem);
    }

    public void printList(){
        for(T item : elems) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
