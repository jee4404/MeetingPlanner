package controleurs;

public class ControleurParticipant {

	   private static ControleurParticipant controleurParticipant = new ControleurParticipant( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurParticipant(){ }
	   
	   /* Static 'instance' method */
	   public static ControleurParticipant getInstance( ) {
	      return controleurParticipant;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for ControleurParticipant"); 
	   }
	}
