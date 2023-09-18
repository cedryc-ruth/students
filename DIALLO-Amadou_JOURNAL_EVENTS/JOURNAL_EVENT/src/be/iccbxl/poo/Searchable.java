package be.iccbxl.poo;

import java.util.List;

public interface Searchable {

    List<Artist> findBy(String style) ;
}
