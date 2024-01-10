package com.example.inheritancesample.animals

import com.example.inheritancesample.Animal
import com.example.inheritancesample.species.Mammal

class Dog : Animal(), Mammal {
	override val name: String
		get() = "Dog"
	override val sound: String
		get() = "Bow wow!"
}