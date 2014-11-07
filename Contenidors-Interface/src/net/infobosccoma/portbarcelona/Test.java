package net.infobosccoma.portbarcelona;


public class Test {

    public static void main(String[] args) {
//      OPCIÓ 1	
		Contenidor[] contenidors = new Contenidor[5];
    	
//		OPCIÓ 2
//		Inspeccionable[] contenidors = new Inspeccionable[5];
			
		
		DryVan dv = new DryVan("EUR1234434", 100000, "negre");
		Mercaderia[] mercaderies = new Mercaderia[] {
				new Mercaderia("PATATES", 234546, dv),
				new Mercaderia("MONIATOS", 12356, dv),
				new Mercaderia("BANANES", 45656, dv) };
		dv.add(mercaderies);
		contenidors[0] = dv;
		
		DryVan dv2 = new DryVan("EUR223344", 200000, "red");
		Mercaderia[] mercaderies2 = new Mercaderia[] {
				new Mercaderia("TABLETS", 234546, dv2),
				new Mercaderia("SMARTPHONES", 12356, dv2),
				new Mercaderia("SMARTWATCH", 45656, dv2) };
		dv2.add(mercaderies2);
		contenidors[1] = dv2;
		
		Refrigerat ref = new Refrigerat("AUS998785", 700000.0, -15.0f);
		Mercaderia[] mercaderiesRef = new Mercaderia[] {
				new Mercaderia("RAP", 222, ref),
				new Mercaderia("GAMBES", 333, ref) };
		ref.add(mercaderiesRef);
		contenidors[2] = ref;

		Refrigerat ref2 = new Refrigerat("EUR998785", 400000.0, -5.0f);
		Mercaderia[] mercaderiesRef2 = new Mercaderia[] {
				new Mercaderia("RAP", 444, ref2),
				new Mercaderia("GAMBES", 444, ref2) };
		ref2.add(mercaderiesRef2);
		contenidors[3] = ref2;

		Refrigerat ref3 = new Refrigerat("USA998785", 300000.0, -8.0f);
		Mercaderia[] mercaderiesRef3 = new Mercaderia[] {
				new Mercaderia("RAP", 444, ref3),
				new Mercaderia("GAMBES", 333, ref3) };
		ref3.add(mercaderiesRef3);
		contenidors[4] = ref3;
		
//		OPCIÓ 1
		for (Contenidor c : contenidors) {
			if(c instanceof Inspeccionable && ((Inspeccionable) c).esPotCarregar()) {		
				System.out.println(c.getNumSerie());
			}
		}
	
//		OPCIÓ 2
//		for (Inspeccionable c : contenidors) {
//			if(c.esPotCarregar()) {		
//				System.out.println(((Contenidor)c).getNumSerie());
//			}
//		}
	
    }

}



