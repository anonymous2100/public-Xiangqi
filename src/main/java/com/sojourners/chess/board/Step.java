package com.sojourners.chess.board;

public class Step
{
	Point first;
	Point second;

	public Step(Point first, Point second)
	{
		this.first = first;
		this.second = second;
	}

	public Point getFirst()
	{
		return first;
	}

	public void setFirst(Point first)
	{
		this.first = first;
	}

	public Point getSecond()
	{
		return second;
	}

	public void setSecond(Point second)
	{
		this.second = second;
	}
}
