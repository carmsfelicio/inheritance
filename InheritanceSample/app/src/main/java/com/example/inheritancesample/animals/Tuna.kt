package com.example.inheritancesample.animals

import com.example.inheritancesample.Animal
import com.example.inheritancesample.species.Fish

/**
 * Tuna class
 */
class Tuna(override val name: String, override val sound: String) : Animal(), Fish