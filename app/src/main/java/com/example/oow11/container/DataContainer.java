package com.example.oow11.container;

import androidx.annotation.NonNull;

import com.example.oow11.Iterator.CustomIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataContainer<T> {
    private final List<T> data; // Use List instead of ArrayList

    public DataContainer() {
        this.data = new ArrayList<>();
    }

    public void addData(T element) {
        data.add(element);
    }

    public List<T> getAllItems() { // Return List instead of ArrayList
        return new ArrayList<>(data);
    }
    public DataContainer<T> filter(Predicate<T> predicate) {
        DataContainer<T> filteredContainer = new DataContainer<>();

        // Using stream and lambda to filter items
        List<T> filteredItems = data.stream()
                .filter(predicate) //filter by condition
                .collect(Collectors.toList());

        // Add filtered items to the new container
        filteredItems.forEach(filteredContainer::addData);

        return filteredContainer;
    }

    public Iterator<T> iterator() {
        return data.iterator();
    }

    public class InventoryIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < data.size();
        }

        @Override
        public T next() {
            return data.get(currentIndex++);
        }
    }

    /**
     * Get a custom iterator (optional method showing custom iterator creation)
     * @return custom iterator for this container
     */
    public InventoryIterator getCustomIterator() {
        return new InventoryIterator();
    }
}
