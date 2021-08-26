package pizzafm;

public interface Dough {
    @Override
    String toString();

}
class ThickCrustDough implements Dough {
	public String toString() {
		return "ThickCrust style extra thick crust dough";
	}
}
class ThinCrustDough implements Dough {
	public String toString() {
		return "Thin Crust Dough";
	}
}
