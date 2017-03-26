package edu.keith.demo;

/**
 * Created by keith on 2017/3/25.
 */
public class PrintLikeClock {
	private int pos;
	private  Position min;
	private Position max;
	private int[][] ints;

	public PrintLikeClock(int[][] ints) {
		this.ints = ints;
		pos = 0;
		min = new Position(0, 0);
		max = new Position(ints[0].length-1, ints.length-1);
	}

	private Integer getVal(Position position) {
		if (position == null) {
			return null;
		}
		return ints[position.getX()][position.getY()];
	}

	private Position getNext(Position position) {
		if ((pos & 1) == 1) {
			position.setX(position.getX() + (2 - pos ));
			if (position.getX() > max.getX()) {//1
				position.setX(max.getX());
				pos = pos + 1;
				int maxY = max.getY() - 1;
				if (maxY < min.getY()) {
					return null;
				}
				max.setY(maxY);
				return getNext(position);
			} else if (position.getX() < min.getX()) {//3
				position.setX(min.getX());
				pos = (pos + 1) & 3;
				int minY = min.getY() + 1;
				if (minY > max.getY()) {
					return null;
				}
				min.setY(minY);
				return getNext(position);
			}
			return position;
		} else {
			position.setY(position.getY() + (1 - pos));
			if (position.getY() > max.getY()) {//0
				position.setY(max.getY());
				pos = pos + 1;
				int minX = min.getX() + 1;
				if (minX > max.getX()) {
					return null;
				}
				min.setX(minX);
				return getNext(position);
			} else if (position.getY() < min.getY()) {//2
				position.setY(min.getY());
				pos = pos + 1;
				int maxX = max.getX() - 1;
				if (maxX < min.getX()) {
					return null;
				}
				max.setX(maxX);
				return getNext(position);
			}
			return position;
		}
	}

	public static void main(String[] args) {
		int[][] ints = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		PrintLikeClock clock = new PrintLikeClock(ints);
		Position position = new Position(0, 0);
		System.out.println(clock.getVal(position));
		while ((position = clock.getNext(position)) != null) {
			System.out.println(clock.getVal(position));
		}
	}
}
class Position {
	int x,y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}