package utils;

import java.text.DecimalFormat;

public class FormatDoubleVersString {
    /**
     * Methode utilisée pour formater correctement les resultats en String, en evitant d'avoir une décimale si superflue
     * @param valeur
     * @return
     */
    public static String formatResultat(double valeur) {
        DecimalFormat df = new DecimalFormat("0.########");
        // Implementer le formatage pour les nombres trop long pour l'affichage
        return df.format(valeur);
    }
}
