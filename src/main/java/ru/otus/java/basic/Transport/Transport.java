package ru.otus.java.basic.Transport;

import ru.otus.java.basic.TerrainType;

public interface Transport {

    boolean move(int distance, TerrainType terrain);

    String getName();

}
