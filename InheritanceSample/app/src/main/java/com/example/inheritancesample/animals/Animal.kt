package com.example.inheritancesample.animals

/**
 * Animal base class
 */
abstract class Animal {
	/** animal name */
	abstract val name: String
	/** animal sound */
	abstract val sound: String
}

// You can actually also use open modifier [syntax: open class Animal { ・・・ }] in this one since it has almost the same properties as an abstract class
// Note the difference here: https://stackoverflow.com/questions/65657155/what-is-the-difference-between-open-class-and-abstract-class