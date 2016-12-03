package bean;

public class Modelt {
	private String resultName;
	private Object value;
	
	
	public Modelt(String resultName, Object value) {
		super();
		this.resultName = resultName;
		this.value = value;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
