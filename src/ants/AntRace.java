package ants;

import ants.Ant.Direction;

public class AntRace {

	public static final int MAX_PLANK_TO_BE_SHOWN = 16;
	Ant[] ants = new Ant[2];

	private int turn = 0;
	private int plankLength = 0;

	public int startRace(int n, int left, int right) {
		init(n, left, right);
		return race();
	}

	private void init(int n, int leftPositionInit, int rightPositionInit) {
		ants[0] = new Ant(leftPositionInit, Direction.TO_THE_LEFT);
		ants[1] = new Ant(rightPositionInit, Direction.TO_THE_RIGHT);
		plankLength = n;
		turn = 0;
	}

	private int race() {
		show();
		while (true) {
			if (hasFallenOfPlank()) {
				break;
			}

			Ant firstAnt = ants[0].getDirection() == Direction.TO_THE_LEFT ? ants[0] : ants[1];
			Ant secondAnt = ants[0].getDirection() == Direction.TO_THE_RIGHT ? ants[0] : ants[1];

			if (firstAnt.willCollide(secondAnt)) {
				cangeDirections();
			}
			firstAnt.move();
			if (secondAnt.willCollide(firstAnt)) {
				cangeDirections();
			}
			secondAnt.move();
			turn++;
			show();
		}
		return turn;

	}

	private void show() {
		if (plankLength > MAX_PLANK_TO_BE_SHOWN)
			return;
		System.out.print(turn + ": ");
		for (int i = 0; i < plankLength + 1; i++) {
			System.out.print(getSymbol(i));

		}

		System.out.println();

	}

	private String getSymbol(int position) {
		for (Ant ant : ants) {
			if (ant.getPosition() == position) {
				return ant.getDirection() == Direction.TO_THE_LEFT ? "[<]" : "[>]";
			}
		}
		return "[ ]";
	}

	private void cangeDirections() {
		for (Ant ant : ants) {
			ant.changeDirection();
		}

	}

	private boolean hasFallenOfPlank() {
		for (Ant ant : ants) {
			if (ant.getPosition() <= -1 || ant.getPosition() >= plankLength + 1) {
				return true;
			}
		}
		return false;
	}

}
