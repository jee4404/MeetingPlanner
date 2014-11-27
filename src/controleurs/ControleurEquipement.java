package controleurs;

public class ControleurEquipement {

	   private static ControleurEquipement controleurEquipement = new ControleurEquipement( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurEquipement(){ }
	   
	   /* Static 'instance' method */
	   public static ControleurEquipement getInstance( ) {
	      return controleurEquipement;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for ControleurEquipement"); 
	   }
	}
