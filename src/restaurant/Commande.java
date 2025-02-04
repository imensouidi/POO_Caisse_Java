package restaurant;
import java.time.LocalDate ;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class Commande {
 private int CodeCmd;
 private int NumTab ;
 private LocalDate Date ;
 private LocalTime heure;
 private ArrayList<LigneCmd> list;
 private String ModeDePaiement;
 private boolean  cloturee ;
 public int getCodeCmd() {
	return CodeCmd;
}
public void setCodeCmd(int codeCmd) {
	CodeCmd = codeCmd;
}

public int getNumTab() {
	return NumTab;
}
public void setNumTab(int numTab) {
	NumTab = numTab;
}

public LocalDate getDate() {
	return Date;
}
public void setDate(LocalDate date) {
	Date = date;
}

public LocalTime getHeure() {
	return heure;
}
public void setHeure(LocalTime heure) {
	this.heure = heure;
}
public ArrayList<LigneCmd> getList() {
	return list;
}
public void setList(ArrayList<LigneCmd> list) {
	this.list = list;
}
public String getModeDePaiement() {
	return ModeDePaiement;
}
public void setModeDePaiement(String modeDePaiement) {
	ModeDePaiement = modeDePaiement;
}
public boolean isCloturee() {
	return cloturee;
}
public void setCloturee(boolean cloturee) {
	this.cloturee = cloturee;
}
public Commande(int codeCmd, int numTab, ArrayList<LigneCmd> list,
		String modeDePaiement) {
	this.Date=LocalDate.now();
	this.heure = LocalTime.now();
	this.list=list;
	this.NumTab = numTab;
	this.ModeDePaiement = modeDePaiement;
	this.cloturee=false;
}
public String afficher_list_ligneC()
{
    String liste="";
    for(int i=0;i<list.size();i++)
    {
        liste=liste+("le produit num�ro"+i+list.get(i).toString());
    }
    return liste;
}

@Override
public String toString() {
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Corrected format
    String formattedDate = Date.format(myFormatObj);

    DateTimeFormatter myFormatH = DateTimeFormatter.ofPattern("HH:mm:ss"); // Corrected and used
    String formattedH = heure.format(myFormatH);

    return "Commande [CodeCmd=" + CodeCmd + ", NumTab=" + NumTab + ", Date=" + formattedDate 
            + ", heure=" + formattedH + ", list=" + afficher_list_ligneC() 
            + ", ModeDePaiement=" + ModeDePaiement + ", cloturee=" + cloturee 
            + ", Le total de la commande = " + Total() + "]";
}

public double Total() {
	double S= 0 ;
	for(int i = 0;i<list.size();i++)
	{
	S=S+(list.get(i).getQuantite()*list.get(i).getPlat().getPrix())	;
	}
	return S;
}
}