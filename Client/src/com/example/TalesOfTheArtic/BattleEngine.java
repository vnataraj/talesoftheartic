package com.example.TalesOfTheArtic;

public class BattleEngine()
{
	private BattleGUI bgui;
	private Board board;
	private AI ai;
	public BattleEngine(GameView gv)
	{
		this.bgui= new BattleGUI();
		this.board= new Board();
		this.ai=new AI();
	}
	public static void main(String[] args)
	{
		
	}
}
