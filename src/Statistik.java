import javax.swing.DefaultListModel;

public class Statistik {

	public enum MittelwertTyp {
		ARITHMETISCH, GEOMETRISCH, HARMONISCH
	}

	public Statistik() {

	}

	public static double berechneMittelwert(double[] numb, MittelwertTyp typ) throws MittelwertException {
		double erg = 0;
		double zwischen = 0;
		double n = numb.length;

		if (typ == MittelwertTyp.ARITHMETISCH) {
			for (double nr : numb) {
				erg += nr;
			}
			if (erg == 0) {
				throw new MittelwertException("Man darf nicht durch null teilen");
			}
			erg = erg / n;
		} else if (typ == MittelwertTyp.GEOMETRISCH) {
			erg = 1;
			for (double nr : numb) {
				if(nr <= 0)
				{
					throw new MittelwertException("Keine Nullen und keine negativen Zahlen");
				}
				erg *= nr;
			}
			n = 1.0 / n;
			erg = Math.pow(erg, n);
		} else if (typ == MittelwertTyp.HARMONISCH) {
			for (double nr : numb) {
				if (nr == 0) {
					throw new MittelwertException("Es dürfen keine nullen vorkommen!");
				}
				nr = 1.0 / nr;
				;
				erg += nr;
			}
			erg = n / erg;
		}
		return erg;

	}
}
