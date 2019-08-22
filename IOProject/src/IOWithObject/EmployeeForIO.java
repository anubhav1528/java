package IOWithObject;

import java.io.Serializable;

public class EmployeeForIO implements Serializable {

	private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private transient String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "EmployeeForIO [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public EmployeeForIO(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public EmployeeForIO() {
		super();
	}
	
    
}
