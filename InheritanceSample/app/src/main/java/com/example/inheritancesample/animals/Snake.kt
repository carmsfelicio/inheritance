package com.example.inheritancesample.animals

import com.example.inheritancesample.species.Reptile

/**
 * Snake class
 */
class Snake : Animal(), Reptile {
	override val name: String = "Snake"
	override val sound: String = "Hiss...."
}