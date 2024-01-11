package com.example.inheritancesample.animals

import com.example.inheritancesample.species.Reptile

/**
 * Lizard class
 */
class Lizard : Animal(), Reptile {
	override val name: String = "Lizard"
	override val sound: String = "Blep blep..."
}