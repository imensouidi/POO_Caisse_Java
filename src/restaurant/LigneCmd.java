package restaurant;

	public class LigneCmd {
		private Plat plat;
		private int quantite ;
		
		public Plat getPlat() {
			return plat;
		}
		public void setPlat(Plat plat) {
			this.plat = plat;
		}
		public int getQuantite() {
			return quantite;
		}
		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
		public LigneCmd(Plat plat, int quantite) {
			this.plat = plat;
			this.quantite = quantite;
		}
		@Override
		public String toString() {
			return "LigneCmd [plat=" + plat.toString() + ", quantite=" + quantite + "]";
		}
		

	}

