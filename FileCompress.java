import java.io.*;
import java.util.*;

 class filecompress {

	 int i;
	 HashMap<Integer,String> m=new HashMap<Integer,String>();
	 HashMap<String,Integer> n=new HashMap<String,Integer>();
	 
	 public int FileCompress(String s) {
		 int a[]=new int[256];
		 try{
			 FileInputStream fin=new FileInputStream(s);
			 i=fin.read();
			 int flag=0;
			 while(i!=-1){
			    a[i]++;
			    i=fin.read();
			    flag=1;
			 }
			 fin.close();
			 if(flag==0)
			 {
				 return 1;
			 }
		 }
		 catch(FileNotFoundException e){
			 return 0;
		 }
		 catch(IOException e)
		 { 
		     return 0;
		 }
		 
		 PriorityQueue p=new PriorityQueue();
		 i=0;
		 while(i<256)
		 {	
			 if(a[i]!=0)
			 {
			     pair q=new pair(i,a[i]);
			     p.insert(q);
			 }
			 i++;
		 }
		p.insert(new pair(-1,1));
		
		treeuse tree=new treeuse();
		pair x,y,ans;
		while(p.size()!=2)
		{
			x=p.removemin();
			y=p.removemin();
			ans=tree.add(x,y);
			p.insert(ans);
		}
		boolean b[]=new boolean[100];
		tree.convert(tree.getroot(p.removemin()),m,n,0,b,false);
		
		try{
			FileInputStream in=new FileInputStream(s);
			FileOutputStream out=new FileOutputStream("Compressed.txt");
			String give;
			BitOutputStream d=new BitOutputStream(out);
			do{
				i=in.read();
				give=m.get(i);
				for(int j=0;j<give.length();j++)
				d.write(give.charAt(j));		
			}while(i!=-1);
			d.close();
			in.close();
		}
		catch(FileNotFoundException e){
			return 0;
		}
		catch(IOException e)
		{ 
		    return 0;
		}
		return 2;
	}
	
	public int FileDecompress(String s)
	{
		try{
			FileInputStream in=new FileInputStream(s);
			FileOutputStream out=new FileOutputStream("Decompressed.txt");
			BitInputStream d=new BitInputStream(out);
			i=in.read();
			int t;
			while(i!=-1)
			{
				d.work+=go(i);
				t=d.write(n,m);
				if(t==1)
					break;
				i=in.read();
			}
			in.close();
		}
		catch(FileNotFoundException e){
			return 0;
		}
		catch(IOException e)
		{ 
		    return 0;
		}
		return 3;
	}
	
	public static String go(int i)
	{
		String x="";
		int d;
		while(i!=0)
		{
			d=i%2;
			i=i/2;
			x=(d==1?1:0)+x;
		}
		while(x.length()<8)
			x='0'+x;
		return x;
	}
}