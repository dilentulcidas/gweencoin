package com.gweencoin.core;

import java.util.UUID;

public class GweenCoin
{
    private final String id;

    public GweenCoin()
    {
        this.id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return String.format("GweenCoin with id [%s]", this.id);
    }
}
