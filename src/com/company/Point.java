package com.company;

import org.jetbrains.annotations.NotNull;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(@NotNull Point o) {
        if (this.x == o.x && this.y == o.y) return 0;
        if (this.x > o.x && this.y > o.y) return 1;
        else return -1;
    }
}
