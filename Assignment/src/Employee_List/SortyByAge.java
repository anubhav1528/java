package Employee_List;

import java.util.Comparator;

public class SortyByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.getAge()==o2.getAge()) {
			if (o1.getDateOfJoining().after(o2.getDateOfJoining())) { 
				  
	            // When Date o1.getdateOfJoining > Date o2.getdateOfJoining 
	           return 1;
	        } 
	  
	        else if (o1.getDateOfJoining().before(o2.getDateOfJoining())) { 
	  
	            // When Date o1.getdateOfJoining < Date o2.getdateOfJoining 
	            return -1; 
	        } 
	  
	        else { 
	  
	            // When Date o1.getdateOfJoining = Date o2.getdateOfJoining 
	            return 0; 
	        } 
		}
		else
		{
			 return o1.getAge()-o2.getAge();
			 }
	
	
	}
}
