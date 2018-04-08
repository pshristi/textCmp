import java.util.ArrayList;
import java.util.HashMap;

class treeuse {
    HashMap<Integer,ArrayList<treenode>> data;
    
    treeuse()
    {
    	data=new HashMap<Integer,ArrayList<treenode>>();
    }
    
    public treenode getroot(pair p)
    {
    	ArrayList<treenode> check= data.get(p.y);
    	return check.get(0);
    }
    
    public void convert(treenode root,HashMap<Integer,String> m,HashMap<String,Integer> n,int i,boolean a[],boolean code)
    {
    	if(root==null)
    		return;
    	a[i]=code;
    	if(root.left==null  && root.right==null)
    	{
    		String s="";
    		for(int j=1;j<=i;j++)
    			s=s+(a[j]?1:0);
    		m.put(root.p.x, s);
    		n.put(s, root.p.x);
    	}
    	convert(root.left,m,n,i+1,a,false);
    	convert(root.right,m,n,i+1,a,true);
    }
    
    public pair add(pair x,pair y)
    {
    	pair ans=new pair(-2,x.y+y.y);
    	treenode parent=new treenode(ans);
    	ArrayList<treenode> check;
    	if(x.x==-2 && y.x==-2)
    	{
    		check=data.get(x.y);
    		parent.left=check.get(0);
    		check.remove(0);
    		check=data.get(y.y);
    		parent.right=check.get(0);
    		check.remove(0);
    	}
    	else if(x.x==-2)
    	{
    		check=data.get(x.y);
    		parent.left=check.get(0);
    		check.remove(0);
    		parent.right=new treenode(y);
    	}
    	else if(y.x==-2)
    	{
    		check=data.get(y.y);
    		parent.left=check.get(0);
    		check.remove(0);
    		parent.right=new treenode(x);
    	}
    	else
    	{
    		parent.left=new treenode(x);
    		parent.right=new treenode(y);	
    	}
    	int t=parent.p.y;
    	if(data.containsKey(t))
    	{
    		check=data.get(t);
    		check.add(parent);
    	}
    	else
    	{
    		check=new ArrayList<treenode>();
    		check.add(parent);
    		data.put(t,check);
    	}
    	return ans;
    }  
}