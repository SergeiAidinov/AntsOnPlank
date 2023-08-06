package ants;

public class Ant {

	private int position;
	private Direction direction;

	public enum Direction {
		TO_THE_RIGHT, TO_THE_LEFT
	}

	public Ant(int position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public int getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void move() {
		if (direction == Direction.TO_THE_RIGHT) {
			position++;
		} else {
			position--;

		}
	}

	private int calculateNextPosition() {
		return direction == Direction.TO_THE_RIGHT ? position + 1 : position - 1;

	}

	public void changeDirection() {
		if (direction == Direction.TO_THE_LEFT) {
			direction = Direction.TO_THE_RIGHT;
		} else {
			direction = Direction.TO_THE_LEFT;
		}

	}

	public boolean willCollide(Ant secondAnt) {
		return calculateNextPosition() == secondAnt.position ? true : false;
	}
}
