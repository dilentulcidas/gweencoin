package com.gweencoin.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class GweenCoinControllerTests
{
	private GweenCoinDatabase database;
	private List<GweenCoin> minedCoins;
	private GweenCoinController subjectUnderTest;

	@BeforeEach
	public void setup()
	{
		this.database = new GweenCoinDatabase();
		this.minedCoins = new ArrayList<>();
		this.subjectUnderTest = new GweenCoinController(database);
	}

	@Test
	void mine_addsGweenCoinToDatabase()
	{
		whenMine();
		thenAssertDatabaseListSizeIs(1);
		thenAssertDatabaseListMatchesMinedGweenCoins();
	}

	@Test
	void list_showsListOfCoinsInDatabase()
	{
		thenAssertDatabaseListSizeIs(0);

		whenMine();
		whenMine();
		whenMine();

		thenAssertDatabaseListSizeIs(3);
		thenAssertDatabaseListMatchesMinedGweenCoins();
	}

	private void whenMine()
	{
		this.minedCoins.add(subjectUnderTest.mine());
	}

	private void thenAssertDatabaseListSizeIs(int expectedSize)
	{
		assertEquals(database.list().size(), expectedSize);
	}

	private void thenAssertDatabaseListMatchesMinedGweenCoins()
	{
		assertEquals(database.list(), minedCoins);
	}
}
