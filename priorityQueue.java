import java.util.ArrayList;

 class PriorityQueue {
	 ArrayList<pair> data;
	 
	    PriorityQueue()
	    {
	    	data=new ArrayList<pair>();
	    	data.add(null);
	    }
	    
	    public int size()
	    {
	    	return data.size();
	    }
	    
	    public void insert(pair p)
	    {
	    	data.add(p);
	    	int childindex=data.size()-1;
	    	while(childindex>1)
	    	{
	    		int parentindex=childindex/2;
	    		if(data.get(parentindex).y<p.y)
	    			return;
	    		pair temp=data.get(parentindex);
	    		data.set(parentindex, p);
	    		data.set(childindex, temp);
	    		childindex=parentindex;
	    	}
	    }
	    
	    public pair getmin()
	    {
	    	if(data.size()==1)
	    		return null;
	    	return data.get(1);
	    }
	    
	    public pair removemin()
	    {
	       if(data.size()==1)
	    	   return null;
	       pair ans=data.get(1);
	       data.set(1, data.get(data.size()-1));
	       data.remove(data.size()-1);
	       int parentindex=1;
	       while(true)
	       {
	    	   int minindex=parentindex;
	    	   int leftindex=2*parentindex;
	    	   int rightindex=leftindex+1;
	    	   if(leftindex<data.size() && data.get(minindex).y>data.get(leftindex).y)
	    		   minindex=leftindex;
	    	   if(rightindex<data.size() && data.get(minindex).y>data.get(rightindex).y)
	    		   minindex=rightindex;
	    	   if(minindex==parentindex)
	    		   break;
	    	   pair temp=data.get(parentindex);
	    	   data.set(parentindex, data.get(minindex));
	    	   data.set(minindex, temp);
	    	   parentindex=minindex;
	       }
	       return ans;
	    }
}