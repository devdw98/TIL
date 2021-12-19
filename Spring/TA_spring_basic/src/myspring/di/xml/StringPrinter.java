package myspring.di.xml;

public class StringPrinter implements Printer{
	//해당되는 string들을 저장해야함
	private StringBuffer buf = new StringBuffer();
	
	@Override
	public void print(String msg) {
		this.buf.append(msg);
	}
	
	public String toString() {
		return buf.toString();
	}

	
}
