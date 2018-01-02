public class HjelpeMetoder {

    static char TOM_RUTE_TEGN = '.';

  /**
     * Oversetter et tegn (char) til en tallverdi (int)
     *
     * @param tegn      tegnet som skal oversettes
     * @return          verdien som tegnet tilsvarer
     */
    public static int tegnTilVerdi(char tegn) {
        if (tegn == TOM_RUTE_TEGN) {                // tom rute
            return 0;
        } else if ('1' <= tegn && tegn <= '9') {    // tegn er i [1, 9]
            return tegn - '0';
        } else if ('A' <= tegn && tegn <= 'Z') {    // tegn er i [A, Z]
            return tegn - 'A' + 10;
        } else if (tegn == '@') {                   // tegn er @
            return 36;
        } else if (tegn == '#') {                   // tegn er #
            return 37;
        } else if (tegn == '&') {                   // tegn er &
            return 38;
        } else if ('a' <= tegn && tegn <= 'z') {    // tegn er i [a, z]
            return tegn - 'a' + 39;
        } else {                                    // tegn er ugyldig
            return -1;
        }
    } // Avslutter metoden tegnTilVerdi

    /**
     * Oversetter en tallverdi (int) til et tegn (char)
     *
     * @param verdi     verdien som skal oversettes
     * @param tom       tegnet som brukes for Ã¥ representere 0 (tom rute)
     * @return          tegnet som verdien tilsvarer
     */
    public static char verdiTilTegn(int verdi) {
        if (verdi == 0) {                           // tom
            return TOM_RUTE_TEGN;
        } else if (1 <= verdi && verdi <= 9) {      // tegn er i [1, 9]
            return (char) (verdi + '0');
        } else if (10 <= verdi && verdi <= 35) {    // tegn er i [A, Z]
            return (char) (verdi + 'A' - 10);
        } else if (verdi == 36) {                   // tegn er @
            return '@';
        } else if (verdi == 37) {                   // tegn er #
            return '#';
        } else if (verdi == 38) {                   // tegn er &
            return '&';
        } else if (39 <= verdi && verdi <= 64) {    // tegn er i [a, z]
            return (char) (verdi + 'a' - 39);
        } else {                                    // tegn er ugyldig
            throw new IllegalArgumentException ("Ugyldig verdi.");    // HUSK DEFINISJON AV UNNTAKSKLASSE
        }
    } // Avslutter metoden verdiTilTegn


}
