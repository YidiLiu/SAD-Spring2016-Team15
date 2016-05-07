package util;
public class ValidState implements State {

	public void validate(Context context) {
		System.out.println("User has logged in");
		context.setState(this);
	}

	public String toString() {
		return "#######Login State";
	}
}
