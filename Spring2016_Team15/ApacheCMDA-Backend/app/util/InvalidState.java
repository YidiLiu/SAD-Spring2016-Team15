package util;

public class InvalidState implements State{

	public void validate(Context context) {
		System.out.println("User is not login");
		context.setState(this);
	}

	public String toString() {
		return "#########Invalid State";
	}
}
