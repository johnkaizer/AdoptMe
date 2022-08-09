package com.project.adoptpet.Data

import com.project.adoptpet.R

data class PetsData(
    val id:Int,
    val name:String,
    val gender:String,
    val age:Int,
    val weight:Double,
    val imagePath:Int
)

var PetList = mutableListOf<PetsData>(
    PetsData(0,"Kitty","Male",3,3.0, R.drawable.cat01),
    PetsData(1,"Bobby","Female",2,20.0, R.drawable.dog01),
    PetsData(2,"Bundy","Female",3,5.0, R.drawable.bunny01),
    PetsData(3,"Salmoh","Male",1,0.3, R.drawable.fish01),
    PetsData(4,"Cathy","Female",4,4.0, R.drawable.cat02),
    PetsData(5,"Keano","Female",2,4.5, R.drawable.cat03),
    PetsData(6,"Bravy","Male",6,5.4, R.drawable.bunny02),
    PetsData(7,"King","Female",5,25.6, R.drawable.dog02),
    PetsData(8,"Spike","Female",2,17.6, R.drawable.dog04),
    PetsData(9,"Benz","Female",1,5.4, R.drawable.bunny03),
    PetsData(10,"Simo","Male",1,0.1, R.drawable.fish02),
    PetsData(11,"Loyal","Male",2,0.2, R.drawable.fish03),
    PetsData(12,"Simba","Female",6,33.4, R.drawable.dog05),
    PetsData(13,"Salvador","Female",5,24.0, R.drawable.dog06),
    PetsData(14,"Kimpy","Male",3,10.5, R.drawable.cat04),

)