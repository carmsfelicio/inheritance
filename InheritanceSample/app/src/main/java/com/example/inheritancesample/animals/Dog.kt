package com.example.inheritancesample.animals

import com.example.inheritancesample.species.Mammal

/**
 * Dog class
 */
class Dog : Animal(), Mammal {
	override val name: String = "Dog"
	override val sound: String = "Bow wow!"
}