package Line_Model;

public class Line extends Model {
	private int startPoint;
	private int endPoint;
	
	public Line() {
		
	}
	public Line(int startPoint,int endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	public int calculateLength() {
		return (endPoint-startPoint);
	}

	@Override
	public boolean isGreater(Object obj1) {
		Line line = (Line)obj1;
		return(this.calculateLength()>line.calculateLength());
	}

	@Override
	public boolean isLesser(Object obj1) {
		Line line = (Line)obj1;
		return(this.calculateLength()<line.calculateLength());
		
	}

	@Override
	public boolean isEqual(Object obj1) {
		Line line = (Line)obj1;
		return(this.calculateLength()==line.calculateLength());
		
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

}
