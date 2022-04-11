package test.techgig;

import java.util.Scanner;

public class WorldArmyVsAliens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Integer launchTimeInHr = sc.nextInt();
			Integer launchTimeInMin = sc.nextInt();
			Integer travelTimeInHr = sc.nextInt();
			Integer travelTimeInMin = sc.nextInt();

			float totalMinInTravel = (travelTimeInHr * 60) + travelTimeInMin;

			for (float i = 1F; i <= totalMinInTravel; i++) {
				launchTimeInMin += 1;
				if (launchTimeInMin > 59) {
					launchTimeInMin = 0;
					launchTimeInHr += 1;
					if (launchTimeInHr > 23) {
						launchTimeInHr = 0;
					}
				}
			}
			System.out.println(String.format("%02d", launchTimeInHr) + " "
					+ String.format("%02d", launchTimeInMin));
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
