package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public  class Poste {
private int num;
private String tv;
private String console;
private String[] games;
private ArrayList<Jeu> times;

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
int day = Integer.parseInt(LocalDate.now().format(formatter));

public  boolean get() {
   
	 for(Jeu fruit:times) {		 
		 System.out.println(fruit);    
	 }
	return true;	  
}

public void setGames(String[] games) {
	this.games = games;
}
public String[] getGames() {
	return this.games;
}

public void setNum(int num) {
	this.num = num;
}
public int getNum() {
	return this.num;
}

public void setTv(int tv) {
	this.num = tv;
}
public String getTv() {
	return this.tv;
}
public void setConsole(int console) {
	this.num = console;
}
public String getConsole() {
	return this.console;
}
public Poste(int num, String tv, String console,String[] games) {
	this.num = num;
	this.tv = tv;
	this.console = console;
	this.games=games;	
    times = new ArrayList<Jeu>();
}
public ArrayList<Jeu> getTimes(){
    return times;
}
public boolean reserver(double debut,double fin) {
	boolean res=true;
	 for(Jeu j : times) {			 
		 if( (debut >= j.getDebut() && debut < j.getFin()) || (fin > j.getDebut() && fin < j.getFin())) {
			 res=false;
			 break;
		 }
		 else
		 {
			 res=true;
		 }
	 }
	 if(res) {
		 times.add(new Jeu(debut,fin) );
		 System.out.println("Bien Reserver !!");
	 }
	 else {
		 System.out.println("Poste Occupé !! Poste : "+ num);
	 }
		 
	 return true;
}


public boolean add(double debut , double fin){
	times.add(new Jeu(debut,fin));
	return true;
}

public void revenue(int tarif) {
	int dailytarif=0;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	int dnow = Integer.parseInt(LocalDate.now().format(formatter));
	if(day == dnow) {
		dailytarif=dailytarif+tarif;
	}
	else
	{
		dailytarif=0;
		this.day = Integer.parseInt(LocalDate.now().format(formatter));
	}
	System.out.printf("les revenu du jour : %t",dailytarif);
}


}
