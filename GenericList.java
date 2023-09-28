import java.util.ArrayList;

class GenericList<T>{
    private ArrayList<T> elems = new ArrayList<>();

    public void AddToList(T listitem){
        elems.add(listitem);
    }

    public ArrayList<T> getAllItems(){
        return elems;
    }
    public T getItem(int index){
        return elems.get(index);
    }
    public int getSize(){
        return elems.size();
    }
}
