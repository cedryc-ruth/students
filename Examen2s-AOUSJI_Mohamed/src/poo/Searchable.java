package poo;

import java.util.List;

public interface Searchable <T> {
	
	  List<T> findBy(String s);

}
