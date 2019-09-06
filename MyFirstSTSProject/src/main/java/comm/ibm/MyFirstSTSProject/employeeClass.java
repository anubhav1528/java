package comm.ibm.MyFirstSTSProject;

public class employeeClass {
private int id;
private String name;
public employeeClass() {
	super();
}
@Override
public String toString() {
	return "employeeClass [id=" + id + ", name=" + name + "]";
}
public employeeClass(int id, String name) {
	super();
	this.id = id;
	this.name = name;
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getEmpDetails() {
return toString();
}}
