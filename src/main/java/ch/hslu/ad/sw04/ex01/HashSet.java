package ch.hslu.ad.sw04.ex01;

import java.util.Arrays;

public class HashSet implements Set<Integer> {

    private Object[] items;
    private int itemCount;

    public HashSet(int size) {
        items = new Object[size];
        itemCount = 0;

    }

    public HashSet() {
        this(10);
    }

    @Override
    public boolean add(Integer newItem) {
        int hash = newItem.hashCode();
        int index = Math.abs(hash % items.length);

        if (items[index] == null || items[index] instanceof Tombstone) {
            items[index] = newItem;
            itemCount++;
            return true;
        } else {
            int currentIndex = index + 1;
            while (currentIndex != index) {
                if (currentIndex < items.length) {
                    if (items[currentIndex] == null || items[currentIndex] instanceof Tombstone) {
                        items[currentIndex] = newItem;
                        itemCount++;
                        return true;
                    } else {
                        currentIndex++;
                    }
                } else {
                    currentIndex = 0;
                    continue;

                }
            }
            return false;
        }

    }

    @Override
    public boolean contains(Integer item) {
        int hash = item.hashCode();
        int index = Math.abs(hash % items.length);
        if (item instanceof Integer) {
            if (!(items[index] instanceof Tombstone)) {
                if (items[index].equals(item)) {
                    return true;
                }
            } else {

                int currentIndex = index + 1;
                while (currentIndex != index) {
                    if (items[currentIndex] instanceof Tombstone) {
                        currentIndex++;
                        continue;
                    } else {
                        if (currentIndex < items.length) {
                            if (items[currentIndex].equals(item)) {
                                return true;
                            } else {
                                currentIndex++;
                            }
                        } else {
                            currentIndex = 0;
                            continue;

                        }
                    }
                }

                return false;
            }
        } else {
            throw new IllegalArgumentException("Only searching for Integer values allowed.");
        }


        return false;
    }

    @Override
    public boolean remove(Integer item) {
        int hash = item.hashCode();
        int index = Math.abs(hash % items.length);
        if (item instanceof Integer) {
            if (!(items[index] instanceof Tombstone)) {
                if (items[index].equals(item)) {
                    items[index] = new Tombstone();
                    itemCount--;
                    return true;
                }

            } else {
                int currentIndex = index + 1;
                while (currentIndex != index) {
                    if (items[currentIndex] instanceof Tombstone) {
                        currentIndex++;
                        continue;
                    } else {
                        if (currentIndex < items.length) {
                            if (items[currentIndex].equals(item)) {
                                items[currentIndex] = new Tombstone();
                                itemCount--;
                                return true;
                            } else {
                                currentIndex++;
                            }
                        } else {
                            currentIndex = 0;
                            continue;

                        }
                    }
                }
                return false;
            }
        } else {
            throw new IllegalArgumentException("Only Integer values allowed to be removed.");
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return this.itemCount == 0;
    }

    @Override
    public boolean isFull() {
        if (itemCount == items.length) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.itemCount;
    }

    @Override
    public String toString() {
        return "HashSet{" +
                "items=" + Arrays.toString(items) +
                ", itemCount=" + itemCount +
                '}';
    }

    public void getElements() {
        int index = 0;
        while (index < items.length) {
            if (items[index] instanceof Integer) {
                System.out.println(this.items[index]);
            }
            index++;

        }

    }

    public class Tombstone {

    }

}