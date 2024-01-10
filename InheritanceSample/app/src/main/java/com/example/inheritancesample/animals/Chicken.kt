package com.example.inheritancesample.animals

import com.example.inheritancesample.Animal
import com.example.inheritancesample.species.Bird

class Chicken(override val name: String, override val sound: String) : Animal(), Bird