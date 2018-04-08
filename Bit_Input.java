import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

class BitInputStream {
	private FileOutputStream out;
    String work;

    public BitInputStream(FileOutputStream out) {
        this.out = out;
        work="";
    }

    public int write(HashMap<String,Integer> n,HashMap<Integer,String> m) throws IOException {
        String found;
        int index=0,num;
        for (index = 1; index < work.length(); index++)
        {
            found=work.substring(0,index);
            if(n.containsKey(found))
            {	
            	num=n.get(found);
            	if(num!=-1)
            	{
            		out.write(num);
            	    work=work.substring(index);
            	    index=0;
            	}
            	else
            	{
            		out.close();
            		return 1;
            	}
            }
       }
       return -1;
    }
}