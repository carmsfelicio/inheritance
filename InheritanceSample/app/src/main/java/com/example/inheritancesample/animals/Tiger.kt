package com.example.inheritancesample.animals

import com.example.inheritancesample.species.Mammal

/**
 * Tiger class
 */
class Tiger : Animal(), Mammal {
	override val name: String = "Tiger"
	override val sound: String = "Roar!"
}