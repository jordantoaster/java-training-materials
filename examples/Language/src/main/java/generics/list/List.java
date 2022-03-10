package generics.list;

public interface List<T> {
	int size();
	void clear();
	void add(T value);
	void remove(T value) throws ListEmptyException, ItemNotInListException;
	T get(int index) throws ListEmptyException, ItemNotInListException;
}