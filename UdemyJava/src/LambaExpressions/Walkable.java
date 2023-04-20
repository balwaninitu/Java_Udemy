package LambaExpressions;

/*its a good practice to annotate like below, because no other
person should add any method below bcoz its functional interface and
it should have only one method*/
@FunctionalInterface
public interface Walkable {
	public void walk();
	/*
	 * if more than one method then it is not functional interface
	 */
	//public void run();

}
