import java.util.Scanner;

public class hanoi3 {
	    public static void hanoi(MachineTrace m,int n, int col1, int col2, int col3,int [] A,int [] B,int [] C,Rectangle r1,Rectangle r2,Rectangle r3,int timer) {
	        // System.out.println("..reçu.......n= "+n+"  "+col1+"   "+col2+"  "+col3);
	    	if (n == 0) 
	    	{
	    		//System.out.println("FINI"+"  "+col1+"   "+col2+"  "+col3);
	    		return;
	    	}
	    	//System.out.println("...appel........n1= "+(n-1)+"  "+col1+"   "+col3+"  "+col2);
	        hanoi(m,n-1, col1, col3, col2,A,B,C,r1,r2,r3,timer);
	        //System.out.println("Bougez le disque " + n + " de " + col1 + " à " + col3);
	        echangerPosition(n,col1,col3,r1,r2,r3);
	        echanger(n,col1,col3,A,B,C,r1,r2,r3);
	        afficher(A,B,C);
	        m.effacerTout();
	        afficherHanoi(A,B,C,r1);
	        m.attendre(timer);
	        //System.out.println("...appel........n2= "+(n-1)+"  "+col2+"   "+col1+"  "+col3);
	        hanoi(m,n-1, col2, col1, col3,A,B,C,r1,r2,r3,timer);
	        
	       
	    }
	    public static void echangerPosition(int n,int col1,int col3,Rectangle r1,Rectangle r2,Rectangle r3) {
	    	double position1;
	    	//System.out.println("Bougez le disque " + n + " de " + col1 + " à " + col3);
	    	if(n==1) {
	    		position1=r1.getPositiony();
	    		//System.out.println("le disque " + n + " est en position  " + position1);
	    	}
	    	if(n==2) {
	    		position1=r2.getPositiony();
	    		//System.out.println("le disque " + n + " est en position  " + position1);
	    	}
	    	if(n==3) {
	    		position1=r3.getPositiony();
	    		//System.out.println("le disque " + n + " est en position  " + position1);
	    	}
	    	
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
	    	System.out.println();
	    }
	    
	    public static void afficherHanoi(int [] A,int [] B,int [] C,Rectangle r1) {
	    	//r1.placer(0,0);
	    	int posX,posY;
	    	//r1.dessiner();
	    	
	    	for (int k=0;k<3;k++) {
	    		if(k==0) {
	    			for(int i=0;(i<A.length);i++) {
		    			posX=-120-(5*A[i]);
		    			posY=-10*i;
		    			r1.setPosition(posX,posY);
		    			r1.setDimension(A[i]*10,10);
		    			r1.placer();
		    			r1.dessiner();
	    		}
	    		}
	    			if(k==1) {
		    			for(int i=0;(i<B.length);i++) {
			    			posX=0-(5*B[i]);
			    			posY=-10*i;
			    			r1.setPosition(posX,posY);
			    			r1.setDimension(B[i]*10,10);
			    			r1.placer();
			    			r1.dessiner();
		    		}
	    		}
	    			if(k==2) {
		    			for(int i=0;(i<C.length);i++) {
			    			posX=120-(5*C[i]);
			    			posY=-10*i;
			    			r1.setPosition(posX,posY);
			    			r1.setDimension(C[i]*10,10);
			    			r1.placer();
			    			r1.dessiner();
		    		}
	    		}
	    	}
	    		
	    			
	    	
	    }
	    
			
	    public static void echanger(int n,int col1,int col3,int [] T1,int [] T2,int [] T3,Rectangle r1,Rectangle r2,Rectangle r3) {
	    	int i=T2.length-1,departmem1=0,departmem2=0,departmem3=0,arrivmem1;
	    	//System.out.println("i long"+i);
	    	//System.out.println("T1="+T1[i]);
	    	if(col1==1) {
	    		i=T1.length-1;
	    		departmem1=T1.length-1;
	    		arrivmem1=T1.length-1;
	    		
	    		while((T1[i]!=n)&&(i>0)) {
	    				i--;
			    		departmem1=i;
			    		
			    	}
	    		//System.out.println("col1 disque "+n+" en "+departmem1);
	    		T1[departmem1]=0;
	    		//System.out.println("on met 0 en T1 rang "+departmem1);
	    		if(col3==2) {
	    			i=T1.length-1;
	    			arrivmem1=T1.length-1;
		    		while((T2[i]!=0)&&(i>0)) {
		    			i--;
		    			arrivmem1=i;
		    		}
		    		//System.out.println("col2 arrivée disque "+n+" en "+arrivmem1);
		    		T2[arrivmem1]=n;
	    		}
	    		if(col3==3) {
	    			i=T1.length-1;
	    			arrivmem1=T1.length-1;
		    		while((T3[i]!=0)&&(i>0)) {
		    			i--;
		    			arrivmem1=i;
		    		}
		    		//System.out.println("col3 arrivée disque "+n+" en "+arrivmem1);
		    		T3[arrivmem1]=n;

	    		}
	    		
	    	}
	    	else if(col1==2){
	    		i=T1.length-1;
	    		departmem2=T1.length-1;
	    		while((T2[i]!=n)&&(i>0)) {
			    		i--;
			    		departmem2=i;
			    		
			    	}
	    		//System.out.println("disque "+n+" en "+departmem2);
	    		T2[departmem2]=0;
	    		//System.out.println("on met 0 en T2 rang "+departmem2);
	    		if(col3==1) {
	    			i=T1.length-1;
	    			arrivmem1=T1.length-1;
		    		while((T1[i]!=0)&&(i>0)) {
		    			i--;
		    			arrivmem1=i;
		    		}
		    		//System.out.println("col2 arrivée disque "+n+" en "+arrivmem1);
		    		T1[arrivmem1]=n;
	    		}
	    		if(col3==3) {
	    			i=T1.length-1;
	    			arrivmem1=T1.length-1;
		    		while((T3[i]!=0)&&(i>0)) {
		    			i--;
		    			arrivmem1=i;
		    		}
		    		//System.out.println("col3 arrivée disque "+n+" en "+arrivmem1);
		    		T3[arrivmem1]=n;
	    		}
	    	}
	    	else if(col1==3){
	    		i=T1.length-1;
	    		departmem3=T1.length-1;
	    		while((T3[i]!=n)&&(i>0)) {
			    		i--;
			    		departmem3=i;
			    		
			    	}
	    		//System.out.println("disque "+n+" en "+departmem3);
	    		T3[departmem3]=0;
	    		//System.out.println("on met 0 en T3 rang "+departmem3);
	    		if(col3==2) {
	    			i=T1.length-1;
	    			arrivmem1=T1.length-1;
		    		while((T2[i]!=0)&&(i>0)) {
		    			i--;
		    			arrivmem1=i;
		    		}
		    		//System.out.println("col2 arrivée disque "+n+" en "+arrivmem1);
		    		T2[arrivmem1]=n;
	    		}
	    		if(col3==1) {
	    			i=T1.length-1;
	    			arrivmem1=T1.length-1;
		    		while((T1[i]!=0)&&(i>0)) {
		    			i--;
		    			arrivmem1=i;
		    		}
		    		//System.out.println("col3 arrivée disque "+n+" en "+arrivmem1);
		    		T1[arrivmem1]=n;
	    		}
	    	}
	    	
	    	
	    	
	    }
	

	    public static void main(String[] args) {
	    	MachineTrace m = new MachineTrace(400,400);
	    	Rectangle r [];
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Saisissez un entier pour déterminer le nombre de tours : ");
	    	int nombre = sc.nextInt();
	    	System.out.println("Saisissez un entier pour déterminer le timing : ");
	    	int timer = sc.nextInt();
	    	
	    	 r = new Rectangle[nombre+1];
	    	 for(int j=1;j<nombre+1;j++) {
	    		 r[j]=new Rectangle(m,10+20*j,10 ); 
	    		 r[j].setPosition(100-(nombre*20)-(10*j),-10*j);
	    		 
	    	 }
	    	
	    	/*Rectangle r[2] = new Rectangle(m,40,10);
	    	Rectangle r[3] = new Rectangle(m,60,10);*/
	    	//m.attenteAutomatique(100);
	    	m.masquerPointeur();
		    m.lever();
		    m.placer(-200, 0);
			m.baisser();
			m.orienter(0);
	    	int n=nombre;
	    	int [] A= new int[n]; 
	        int[] B = new int[n];
	        int[] C = new int[n];
	    	for (int i=0;i<A.length;i++) {
	    		A[i]=i+1;
	    	}
	    	afficher(A,B,C);
	    	/*r[1].setPosition(-80,20);
	    	r[2].setPosition(-90,10);
	    	r[3].setPosition(-100,0);*/
	    	//r[2].placer();
	    	afficherHanoi(A,B,C,r[2]);
	    	//r[1].placer();
	    	afficherHanoi(A,B,C,r[1]);
	    	//r[3].placer();
	    	afficherHanoi(A,B,C,r[3]);
	    	//r[1].dessiner();
	    	m.rafraichir();
	    	//System.out.println("...appel........n1= "+(n)+"  "+1+"   "+2+"  "+3);
	        hanoi(m,n, 1, 2, 3,A,B,C,r[1],r[2],r[3],timer);
	    }
		
}