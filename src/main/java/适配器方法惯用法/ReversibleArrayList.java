package 适配器方法惯用法;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReversibleArrayList<T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){
        super(c);
    }
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return   new Iterator<T>() {
                    int current=size()-1;
                    @Override
                    public boolean hasNext() {
                        return  current>-1;
                    }
                    @Override
                    public T next() {
                        return get(current--);
                    }
                    public void  remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
