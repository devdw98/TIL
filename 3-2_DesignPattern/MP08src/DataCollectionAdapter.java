import java.util.ArrayList;
import java.util.Iterator;

public class DataCollectionAdapter<T> implements DataCollection<T>{
    private ArrayList<T> arr;

    public DataCollectionAdapter() {
        this.arr = new ArrayList<>();
    }

    @Override
    public boolean put(T t) {
        if(arr.add(t))
            return true;
        else
            return false;
    }

    @Override
    public T elemAt(int index) {
        return arr.get(index);
    }

    @Override
    public int length() {
        return arr.size();
    }

    @Override
    public Iterator createIterator() {
        return arr.iterator();
    }
}
