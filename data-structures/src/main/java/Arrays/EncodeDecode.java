import java.util.ArrayList;
import java.util.Stack;

/**
 * Write two static methods in Java to encode and decode a list of postings using VarInt.

 1. byte[] encode(int[] values)

 2. int[] decode(byte[] codes)

 Please provide a main with test data to demonstrate the correctness of your methods.

 Please submit code and the output produced by the test run.

 OUTPUT
 ===========

 ===================== Input =========================
 100 8 150 7 300 24 500 36
 ===================== After dGap =========================
 100 8 50 7 150 24 200 36
 ===================== After encode =========================
 11100100 10001000 10110010 10000111 00000001 10010110 10011000 00000001 11001000 10100100
 ===================== After decode =========================
 100 8 50 7 150 24 200 36
 ===================== After reverseGap =========================
 100 8 150 7 300 24 500 36

 * @author prayagupd
 */

public class EncodeDecode {
	
	public static int byteRequiredForInt(int n){
		int size = 1;
		if ((n >>> 28) != 0) size = 5;
		else if ((n >>> 21) != 0) size = 4;
		else if ((n >>> 14) != 0) size = 3;
		else if ((n >>> 7) != 0) size = 2;
		
		return size;
	}
	
	public static byte[] encodeInt(int n){
		int size = byteRequiredForInt(n);
	
		byte[] code = new byte[size];
		
		for (int i = 0; i < size; i++){
			code[i] = (byte) (n & 0x0000007F);
			n = n >>> 7;
		}
		byte mask = (byte) 0x80;
		code[0] = (byte) (code[0] | mask);
		
		return code;
	}
	
	public static int decodeInt(byte[] code){
		byte mask = (byte) 0x7F;
		code[0] = (byte) (code[0] & mask);
	
		int n = 0;		
		for (int i = code.length -1; i >= 0;  i--){
			n = n << 7;
			n =  ( n | code[i]);
		}
		return n;
	}
	
	public static byte[] encode(int[] a){
		Stack<byte[]> stack = new Stack<byte[]>();
		int size = 0;
		for (int i = 0; i < a.length; i++) {
			byte[] b = encodeInt(a[i]);
			size += b.length;
			stack.push(b);
		}
		byte[] result = new byte[size];
		int index = result.length - 1;
		while(!stack.isEmpty())
		{
			byte[] b = stack.pop();
			for (int i = 0; i < b.length; i++) {
				result[index] = b[i];
				index--;
			}
		}
		return result;
	}
	
	public static int[] decode(byte[] code){
		ArrayList<Integer> array = new ArrayList<Integer>();
		Stack<Byte> stack = new Stack<Byte>();
		for (int i = 0; i < code.length; i++) {
			if((code[i] & (1<<8) ) != 0) {
				byte[] b = new byte[stack.size() + 1];
				b[0] = code[i];
				int index = 1;
				while(!stack.isEmpty()) {
					b[index] = stack.pop();
					index ++;
				}
				array.add(decodeInt(b));
			}
			else stack.push(code[i]);
		}
		int[] t = new int[array.size()];
		for (int i = 0; i < t.length; i++) {
			t[i] = array.get(i);
		}
		return t;
	}
	 
	public static String toStringByte(byte b){
		String str ="";
		for (int i = 0; i < 8; i++){
			str += (b < 0) ? "1" : "0";
			b = (byte) (b << 1);
		}
		return str;
	}

	public static void dgap(int[] tab) {
		int last = 0;
		for (int i = 0; i < tab.length; i+=2) {
			int a = tab[i];
			tab[i] = tab[i] - last;
			last = a;
		}
	}
	public static void reverseDgap(int[] tab) {
		for (int i = 2; i < tab.length; i+=2) {
			tab[i] = tab[i-2]+tab[i];
		}
	}

	public static void main(String[] args) {
		int[] plist = {100, 8, 150, 7, 300, 24, 500, 36};
		// you can add whatever you want
    test(plist);
	}

  private static void test(int[] postingList) {
    System.out.println("===================== Input =========================");
    display(postingList);

    System.out.println("===================== After dGap =========================");
    dgap(postingList); display(postingList);

    System.out.println("===================== After encode =========================");

    byte[]  b = encode(postingList);
    for (int i = 0; i < b.length; i++) {
      System.out.print(toStringByte(b[i])+" ");
    }
    System.out.println();

    System.out.println("===================== After decode =========================");
    int[] a = decode(b);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i]+" ");
    }
    System.out.println();
    System.out.println("===================== After reverseGap =========================");
    reverseDgap(postingList);
    for (int i = 0; i < postingList.length; i++) {
      System.out.print(postingList[i]+" ");
    }
    System.out.println();
  }

  private static void display(int[] plist) {
    for (int i = 0; i < plist.length; i++) {
      System.out.print(plist[i]+" ");
    }
    System.out.println();
  }
}