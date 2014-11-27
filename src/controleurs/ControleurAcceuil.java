package controleurs;

public class ControleurAcceuil {

	   private static ControleurAcceuil controleurAcceuil = new ControleurAcceuil( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurAcceuil(){ }
	   
	   /* Static 'instance' method */
	   public static ControleurAcceuil getInstance( ) {
	      return controleurAcceuil;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for ControleurAccueil"); 
	   }
	}
