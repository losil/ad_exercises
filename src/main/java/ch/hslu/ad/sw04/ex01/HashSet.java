package ch.hslu.ad.sw04.ex01;

public class HashSet implements HashSetInterface<Integer> {
    private int[] elements;
    private int size;

    public HashSet(int size) {
        this.elements = new int[size];
        this.size = 0;
    }


    @Override
    public boolean add(Integer i) {
        if (this.size == (this.elements.length) || !contains(i)) {
            return false;
        } else {
            this.elements[this.size] = i;
            this.size++;
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        } else {
            int index = search((Integer) o);
            this.elements[index] = 0;
            this.size--;
            return true;

        }
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Integer) || this.size == 0) {
            return false;
        }

        for (int i : elements) {
            if (i == (int) o) {
                return true;
            }
        }
        return false;
    }

    private int search(Integer hash) {
        int index = 0;
        for (int h : this.elements) {
            if (h == hash) {
                return index;
            }
            index++;
        }
        return 0;
    }

}
