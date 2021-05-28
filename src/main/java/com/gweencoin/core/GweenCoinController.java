package com.gweencoin.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/gweencoin")
public class GweenCoinController
{
    private final GweenCoinDatabase database;

    GweenCoinController(GweenCoinDatabase database)
    {
        this.database = database;
    }

    @PostMapping("/mine")
    @ResponseBody
    GweenCoin mine()
    {
        GweenCoin gweenCoin = new GweenCoin();
        database.add(gweenCoin);
        return gweenCoin;
    }

    @GetMapping("/list")
    List<GweenCoin> list()
    {
        return database.list();
    }
}