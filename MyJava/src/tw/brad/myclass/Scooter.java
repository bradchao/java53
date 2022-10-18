package tw.brad.myclass;

public class Scooter extends Bike{
	private int gear;	// 0
	
	public void upSpeed() {
		speed = speed < 1 ? 1 : speed + speed*gear;
	}
	
	public void upSpeed(boolean isTurbo) {
		if (isTurbo) {
			speed = speed < 1 ? 1 : speed + speed*gear*1.2;
		}else {
			upSpeed();
		}
	}
	
	public int changeGear(int gear) {
		if (gear >=0 && gear <=5) {
			this.gear = gear;
		}
		return this.gear;
	}
	public int getGear() {
		return gear;
	}
}
