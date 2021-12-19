package myspring.di.xml;

public class StringPrinter implements Printer{
	//�ش�Ǵ� string���� �����ؾ���
	private StringBuffer buf = new StringBuffer();
	
	@Override
	public void print(String msg) {
		this.buf.append(msg);
	}
	
	public String toString() {
		return buf.toString();
	}

	
}
