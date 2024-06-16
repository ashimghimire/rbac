package com.example.demo.dto;

public class SortingDto<T> {
    private String sortBy;
    private T sortByType;

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public T getSortByType() {
        return sortByType;
    }

    public void setSortByType(T sortByType) {
        this.sortByType = sortByType;
    }
}
