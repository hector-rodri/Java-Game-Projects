package com.example;

public interface playerUtils { //Interfaz para definir los métodos que deben implementar los personajes
    int WALK = 1; 
	int PUNCH = 2;
	int FALL = 3;
	int KICK = 4;
	int DEFENCE = 5;
	int POWER = 6;
	int JUMP = 7;

	boolean isCanDealDamage();
}
