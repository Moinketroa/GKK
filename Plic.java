package plic ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import plic.analyse.AnalyseurLexical;
import plic.analyse.AnalyseurSyntaxique;
import plic.arbre.ArbreAbstrait;
import plic.exceptions.AnalyseException;

/**
 * 24 mars 2015 
 * 
 * @author brigitte wrobel-dautcourt
 */

public class Plic {
    
    public Plic(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            
            StringBuilder sb = new StringBuilder();
            sb.append(".text\nmain :\n");
            sb.append(arbre.toMips());
            sb.append("end :\n");
            sb.append("\t# fin du programme\n");
            sb.append("\tmove $v1, $v0   # copie de v0 dans v1 pour permettre les tests de plic0\n");
            sb.append("\tli $v0, 10      # retour au système\n");
            sb.append("\tsyscall\n");
           
            File f = new File("Dateizusammenstellung.asm");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(sb.toString());
            bf.flush();
            bf.close();
            fw.close();
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Plic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar plic.jar <fichierSource.plic>") ;
            System.exit(1) ;
        }
        new Plic(args[0]) ;
    }
    
}
