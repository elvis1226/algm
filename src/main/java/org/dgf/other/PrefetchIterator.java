package org.dgf.other;

import java.util.Iterator;

/**
 * Created by apple on 18/4/8.
 */
public class PrefetchIterator<E> implements Iterator<E> {

    private boolean isGetLastLatestDone;

    private FetchFunc<E> getFunc;

    private E getLatestItem() {
        return null;
    }
    public interface FetchFunc<E> {
        E get();
    }

    public boolean hasNext() {

        return false;
    }

    public E next() {
        return getFunc.get();
    }

    public void remove() {

    }
}
