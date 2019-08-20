package CRUD_LIST;

import java.util.Comparator;

public class SortbyId implements Comparator<Users> {

	@Override
	public int compare(Users o1, Users o2) {
		// TODO Auto-generated method stub
		return o1.id-o2.id;
	}

}
