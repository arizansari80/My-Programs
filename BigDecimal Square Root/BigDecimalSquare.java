import java.io.DataInputStream;
import java.io.IOException;
import java.math.*;
import java.lang.*;

class FastReader{
	private final int SIZE=1<<16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer,bytesRead;

	public FastReader(){
		din=new DataInputStream(System.in);
		buffer=new byte[SIZE];
		bufferPointer=bytesRead=0;
	}

	private void fillBuffer() throws IOException{
		bytesRead=din.read(buffer,bufferPointer=0,SIZE);
		if(bytesRead==-1)
			buffer[0]=-1;
	}

	private byte read() throws IOException{
		if(bufferPointer==bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public BigDecimal getBigDecimal() throws IOException{
		BigDecimal bd=new BigDecimal("0");
		byte c=read();
		while(c<45)
			c=read();
		while(c>=48&&c<=57)
		{	
			bd=bd.multiply(BigDecimal.valueOf(10));
			bd=bd.add(BigDecimal.valueOf(c-48));
			c=read();
		}
		return bd;
	}

	public int getInt() throws IOException{
		int ret=0;
		byte c=read();
		while(c<45)
			c=read();
		while(c>=48&&c<=57){
			ret=ret*10+c-48;
			c=read();
		}
		return ret;
	}
}

public class BigDecimalSquare{
	public static void main(String[] args) throws IOException{
		BigDecimal bd=new BigDecimal("0");
		FastReader fr=new FastReader();
		bd=fr.getBigDecimal();
		int p=fr.getInt();
		BigDecimal sqrbd=new BigDecimal("0");
		sqrbd=sqrt_bd(bd,p);
		System.out.println(sqrbd);
	}

	static BigDecimal sqrt_bd(BigDecimal bd,int p){
		BigDecimal xn=new BigDecimal("0");
		BigDecimal xn1=new BigDecimal("0");
		BigDecimal diff=new BigDecimal("0");
		BigDecimal mxn1=new BigDecimal("0");
		int i=0;
		xn=bd.divide(BigDecimal.valueOf(2));
		xn1=funct(xn,bd,p);
		mxn1=xn1.negate();
		diff=xn.add(xn1);
		int j=0;
		double d=1/Math.pow(10.0,(double)p);
		while(diff.compareTo(BigDecimal.valueOf(d))>0){
			xn=xn1;
			xn1=funct(xn,bd,p);
			mxn1=xn1.negate();
			diff=xn.add(mxn1);
			i++;
		}
		System.out.println("The Number Of Iteration is " + i);	
		return xn1;
	}

	static BigDecimal funct(BigDecimal xn,BigDecimal bd,int p){
		BigDecimal num=new BigDecimal("0");
		BigDecimal den=new BigDecimal("0");
		num=xn.multiply(xn);
		bd=bd.negate();
		num=num.add(bd);
		den=xn.multiply(BigDecimal.valueOf(2));
		num=num.divide(den,p,RoundingMode.CEILING);
		num=num.negate();
		return xn.add(num);
	}
}