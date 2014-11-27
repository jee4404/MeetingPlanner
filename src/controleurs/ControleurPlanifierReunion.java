package controleurs;

public class ControleurPlanifierReunion {

	   private static ControleurPlanifierReunion controleurPlanifierReunion = new ControleurPlanifierReunion( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurPlanifierReunion(){ }
	   
	   /* Static 'instance' method */
	   public static ControleurPlanifierReunion getInstance( ) {
	      return controleurPlanifierReunion;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for ControleurPlanifierReunion"); 
	   }
	}
