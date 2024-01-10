package com.example.inheritancesample.animals

import com.example.inheritancesample.species.Mammal

/**
 * Dog class
 */
class Dog : Animal(), Mammal {
	override val name: String
		get() = "Dog"
	override val sound: String
		get() = "Bow wow!"
}