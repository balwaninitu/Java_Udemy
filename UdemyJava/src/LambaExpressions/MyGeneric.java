package LambaExpressions;

/*make interface more generic so that can use for may lambda 
 * expression which return string, int etc
 */

public interface MyGeneric<T> {
	public T work(T t);

}
