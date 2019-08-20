package DatabaseLayers;

import java.io.Serializable;

public class Employee implements Serializable {
private int id;
private String name;
private String org;
public Employee() {
	super();
}
public Employee(int id, String name, String org) {
	super();
	this.id = id;
	this.name = name;
	this.org = org;
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
public String getOrg() {
	return org;
}
public void setOrg(String org) {
	this.org = org;
}
}
