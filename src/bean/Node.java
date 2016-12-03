package bean;

public class Node {
	private String numType;
	private String key;
	private Object value;
	private String beanTpye;
	
	public Node(String numType,String key,Object value,String beanTpye) {
		// TODO Auto-generated method stub
		this.numType = numType;
		this.key = key;
		this.value = value;
		this.beanTpye = beanTpye;
	}
	
	public String getNumType() {
		return numType;
	}
	public void setNumType(String numType) {
		this.numType = numType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getBeanTpye() {
		return beanTpye;
	}
	public void setBeanTpye(String beanTpye) {
		this.beanTpye = beanTpye;
	}
	@Override
	public String toString() {
		return "(" + numType + "," + key + "," + value + "," + beanTpye + ")";
	}
	
	
	

	
	
}
