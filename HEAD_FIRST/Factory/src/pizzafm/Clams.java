package pizzafm;

public interface Clams {
    String toString();
}


class FreshClams implements Clams {

	public String toString() {
		return "Fresh Clams from Long Island Sound";
	}
}
class FrozenClams implements Clams {

	public String toString() {
		return "Frozen Clams from Chesapeake Bay";
	}
}
