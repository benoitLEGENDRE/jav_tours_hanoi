
public class Rectangle {
	MachineTrace m;
	private double x,  y;
	int largeur,  hauteur;
	Rectangle(MachineTrace m,int largeur, int hauteur){
		this.m=m;
		
		this.largeur=largeur;
		this.hauteur=hauteur;
	}
	void dessiner(){
		
			m.orienter(0);
			m.baisser();
			m.avancer(largeur);
			m.tournerGauche(90);
			m.avancer(hauteur);
			m.tournerGauche(90);
			m.avancer(largeur);
			m.tournerGauche(90);
			m.avancer(hauteur);
			m.lever();
			//System.out.print("trait "+i+" " );
		
	}
	public void setPosition(double x,double  y)
	  {
		this.x=x;
		this.y=y;
	  }
	public double getPositiony()  {  
	    return y;
	  }
	void placer(){
		
		m.lever();
		m.placer(x, y);
	}
}
