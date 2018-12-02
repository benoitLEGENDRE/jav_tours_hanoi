

public class hanoi3 {
	    public static void hanoi(MachineTrace m,int n, int col1, int col2, int col3,int [] A,int [] B,int [] C) {
	        int positionHauteur=0;
	       // System.out.println("..reçu.......n= "+n+"  "+col1+"   "+col2+"  "+col3);
	    	if (n == 0) 
	    	{
	    		//System.out.println("FINI"+"  "+col1+"   "+col2+"  "+col3);
	    		return;
	    	}
	    	//System.out.println("...appel........n1= "+(n-1)+"  "+col1+"   "+col3+"  "+col2);
	        hanoi(m,n-1, col1, col3, col2,A,B,C);
	        System.out.println("Bougez le disque " + n + " de " + col1 + " à " + col3);
	        echanger(n,col1,col3,A,B,C);
	        //System.out.println("...appel........n2= "+(n-1)+"  "+col2+"   "+col1+"  "+col3);
	        hanoi(m,n-1, col2, col1, col3,A,B,C);
	        
	       
	    }
	    
	    public static void rectangle(MachineTrace m,int n,int col,int positionHauteur) {
	    	if(n!=0) {
	    		m.lever();
	    		m.placer(-200+(100*col), positionHauteur);
		    	m.baisser();
		    	m.orienter(0);
		    	m.avancer(n*40/2);
		    	m.tournerGauche(90);
		    	m.avancer(10);
		    	m.tournerGauche(90);
		    	m.avancer(n*40);
		    	m.tournerGauche(90);
		    	m.avancer(10);
		    	m.tournerGauche(90);
		    	m.avancer(n*40/2);
		    	m.lever();
	    	}
	    	
	    }
	    public static void afficher(int [] A,int [] B,int [] C) {
	    	for (int i=0;i<A.length;i++) {
	    		System.out.println("i=  "+(i)+"    "+A[i]+" "+B[i]+" "+C[i]);
	    	}
	    }
	    
	    
			
	    public static void echanger(int n,int col1,int col3,int [] T1,int [] T2,int [] T3) {
	    	int i=T2.length-1,j=T1.length-1,k=T3.length-1,mem1=0,mem2=0;
	    	System.out.println("i long"+i);
	    	System.out.println("T1="+T1[i]);
	    	if(col1==1) {
	    		i=T1.length-1;
	    		mem1=i;
	    		while((T1[i]==0)&&(i>0)) {
			    		System.out.print("i1= "+i+"  ");
			    		i--;
			    		mem1=i;
			    		
			    	}
	    		System.out.println("mem1= "+mem1);
	    	}
	    	else if(col1==2){
	    		i=T1.length-1;
	    		mem1=i;
	    		while((T2[i]==0)&&(i>0)) {
			    		System.out.print("i2= "+i+"  ");
			    		i--;
			    		mem1=i;
			    		
			    	}
	    		System.out.println("mem1= "+mem1);
	    	}
	    	else if(col1==3){
	    		i=T1.length-1;
	    		mem1=i;
	    		while((T3[i]==0)&&(i>0)) {
			    		System.out.print("i3= "+i+"  ");
			    		i--;
			    		mem1=i;
			    		
			    	}
	    		System.out.println("mem1= "+mem1);
	    	}
	    	
	    	if(T2[0]!=0) {
		    	while((T2[j]!=0)) {
		    		System.out.println("j="+j);
		    		mem2=j;
		    		j--;
		    	}
	    	}
	    	/*System.out.println("mem1="+mem1);
	    	System.out.println("mem2="+mem2);
	    	int temp=T1[mem1];
	    	T1[mem1]=T2[mem2];
	    	T2[mem2]=temp;*/
	    	
	    }

	    public static void main(String[] args) {
	    	MachineTrace m = new MachineTrace(400,400);
	    	m.attenteAutomatique(100);
	    	m.masquerPointeur();
		    m.lever();
		    m.placer(-200, 0);
			m.baisser();
			m.orienter(0);
	    	String a;
	    	int n=3;
	    	int [] A= new int[n]; 
	        int[] B = new int[n];
	        int[] C = new int[n];
	    	for (int i=0;i<A.length;i++) {
	    		A[i]=i+1;
	    	}
	    	afficher(A,B,C);
	    	double x, y;
	    	rectangle(m,3,1,0);
	    	rectangle(m,2,1,10);
	    	rectangle(m,0,1,20);
	    	//System.out.println("...appel........n1= "+(n)+"  "+1+"   "+2+"  "+3);
	        hanoi(m,n, 1, 2, 3,A,B,C);
	    }
}