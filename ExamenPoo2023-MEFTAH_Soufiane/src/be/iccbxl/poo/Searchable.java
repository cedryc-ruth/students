package be.iccbxl.poo;

import java.util.List;

public interface Searchable {
	
	List<Artiste> findBy(String s);
}
