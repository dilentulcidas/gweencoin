package com.gweencoin.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class GweenCoinDatabase
{
    private final List<GweenCoin> database;

    public GweenCoinDatabase()
    {
        this.database = new ArrayList<>();
    }

    public void add(GweenCoin gweenCoin)
    {
        database.add(gweenCoin);
    }

    public List<GweenCoin> list()
    {
        return database;
    }
}
