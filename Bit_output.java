import java.io.*;

class BitOutputStream {
    
	private FileOutputStream out;
	private boolean[] buffer = new boolean[8];
	private int count = 0;

	public BitOutputStream(FileOutputStream out) {
	    this.out = out;
	}

	public void write(char x) throws IOException {
	    buffer[count] = (x=='1');
	    count++;
	    if (count == 8)
	    {
	        int num = 0;
	        for (int index = 0; index < 8; index++){
	            num = 2*num + (buffer[index] ? 1 : 0);
	        }
	        out.write(num);
	        count = 0;
	    }
    }

	public void close() throws IOException {
	    int num = 0;
	    for (int index = 0; index < 8; index++){
	        num = 2*num + (this.buffer[index] ? 1 : 0);
	    }
	    this.out.write(num);
	    this.out.close();
	}
}