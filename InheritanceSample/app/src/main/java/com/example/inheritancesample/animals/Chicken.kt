package com.example.inheritancesample.animals

import com.example.inheritancesample.species.Bird

/**
 * Chicken class
 */
class Chicken(override val name: String, override val sound: String) : Animal(), Bird