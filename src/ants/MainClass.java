package ants;

public class MainClass {

	private static int plankLength;
	private static int leftPositionInit;
	private static int rightPositionInit;
	private static boolean hasErrors = false;

	public static void main(String[] args) {

		try {
			plankLength = Integer.valueOf(args[0]);
			leftPositionInit = Integer.valueOf(args[1]);
			rightPositionInit = Integer.valueOf(args[2]);
		} catch (Exception exception) {
			System.out.println(
					"Использование: указать через пробел длину планки и начальные позиции муравьев на ней (первой указывается позиция муравья, идущего влево");
		}

		if (plankLength < 1 || plankLength > Math.pow(10, 4)) {
			System.out.println("Длина планки не может быть меньше 1 и больше 10 000 единиц");
			hasErrors = true;
		}

		if (leftPositionInit < 0 || leftPositionInit > plankLength || rightPositionInit < 0
				|| rightPositionInit > plankLength) {
			System.out.println("Начальные позиции муравьев не могут быть за пределами планки");
			hasErrors = true;
		}

		if (leftPositionInit == rightPositionInit) {
			System.out.println("Начальные позиции муравьев не могут совпадать");
			hasErrors = true;
		}

		if (!hasErrors) {
			AntRace antRace = new AntRace();

			System.out.println(
					"Input: n = " + plankLength + ", left = " + leftPositionInit + ", right = " + rightPositionInit
							+ " Output: " + antRace.startRace(plankLength, leftPositionInit, rightPositionInit));

			plankLength = 4;
			leftPositionInit = 1;
			rightPositionInit = 3;
			System.out.println(
					"Input: n = " + plankLength + ", left = " + leftPositionInit + ", right = " + rightPositionInit
							+ " Output: " + antRace.startRace(plankLength, leftPositionInit, rightPositionInit));

			plankLength = 4;
			leftPositionInit = 4;
			rightPositionInit = 1;
			System.out.println(
					"Input: n = " + plankLength + ", left = " + leftPositionInit + ", right = " + rightPositionInit
							+ " Output: " + antRace.startRace(plankLength, leftPositionInit, rightPositionInit));

			plankLength = 4;
			leftPositionInit = 4;
			rightPositionInit = 3;
			System.out.println(
					"Input: n = " + plankLength + ", left = " + leftPositionInit + ", right = " + rightPositionInit
							+ " Output: " + antRace.startRace(plankLength, leftPositionInit, rightPositionInit));

			plankLength = 3;
			leftPositionInit = 3;
			rightPositionInit = 1;
			System.out.println(
					"Input: n = " + plankLength + ", left = " + leftPositionInit + ", right = " + rightPositionInit
							+ " Output: " + antRace.startRace(plankLength, leftPositionInit, rightPositionInit));
		}
	}
}
