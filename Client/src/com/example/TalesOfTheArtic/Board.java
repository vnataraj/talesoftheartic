package com.example.TalesOfTheArtic;

public class Board()
{
	private Tile[] t;
	private Veggie[] v;
	private VeggieData[] vd;
	private VeggieData[] comp;
	public Board(Tile[] tile, Veggie[] veg, VeggieData[] data, VeggieData[] ai)
	{
		this.t=tile;
		this.v=veg;
		this.vd=data;
		this.comp=ai;
	}
	public void create(Tile[] t)
	{
		return;
	}
}