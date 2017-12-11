package facture;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {
    Client client;
    Date emission;
    int numero;
    private List<LigneFacture> ligne;

    public Facture(Client destinataire, Date emission, int numero) {
       client=destinataire;
       this.emission=emission;
       this.numero=numero;
       ligne=new ArrayList<LigneFacture>();
    }

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
         return this.numero;
    }

    /**
     * Get the value of emission
     *
     * @return the value of emission
     */
    public Date getEmission() {
        return this.emission;
    }

    /**
     * Get the value of destinataire
     *
     * @return the value of destinataire
     */
    public Client getDestinataire() {
        return this.client;
    }


    
    public void ajouteLigne(Article a, int nombre, float remise) {
        ligne.add(new LigneFacture(nombre,this,a,remise));
   }
    
   public float montantTTC(float tauxTVA) {
       float res=0;
       for (LigneFacture l :ligne){
           res+=l.montantLigne();
       }
       return res*(1+tauxTVA);

   }
   
   public void print(PrintStream out, float tva) {
        for (LigneFacture l :ligne){
           out.println(ligne.toString());
       }
        out .println("TVA : "+ tva);
   }
   
}
