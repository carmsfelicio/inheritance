package com.example.inheritancesample.animals

import com.example.inheritancesample.Animal
import com.example.inheritancesample.species.Reptile

class Snake : Animal(), Reptile {
	override val name: String
		get() = "Snake"

	override val sound: String
		get() = "Hiss...."
}