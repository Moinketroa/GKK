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
import plic.tds.TDS;

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
            sb.append(".data\nnewline :\t.asciiz \"\\n\"\n");
            sb.append(".text\nmain :\n");
            
            sb.append("\t #Zone mémoire des variables\n"
            		+ "\t move $s7, $sp\n"
            		+ "\t addi $sp, $sp, " + TDS.getInstance().getTailleZoneDesVariables() + "\n");
            
            if (arbre.toMips() != null){
            	sb.append(arbre.toMips());
            	System.out.println(arbre.toString());
            }
            
            sb.append("end :\n"
            		+ "\t #Fin du programme\n"
            		+ "\t li $v0, 10      # retour au système\n"
            		+ "\t syscall\n");
            
            if (fichier.endsWith(".plic")){
            	fichier = fichier.substring(0, fichier.length() - 5);
            }
            fichier += ".asm";
            
            File f = new File(fichier);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(sb.toString());
            bf.flush();
            bf.close();
            fw.close();
            
            System.out.println("Compilation OK");
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
