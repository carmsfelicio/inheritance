package com.example.inheritancesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inheritancesample.animals.*
import com.example.inheritancesample.databinding.ActivityMainBinding
import com.example.inheritancesample.species.*

/**
 * Main activity class
 */
class MainActivity : AppCompatActivity() {

	/** Layout binding */
	private var binding: ActivityMainBinding? = null

	// There are two ways to create a derived class.
	// 1) Override the inherited variables in to the class (see Lizard, Tiger, Snake, Dog classes)
	// 2) Or put the overridden variables in the parameters and initialize them upon making a new object (see Tuna and Chicken classes)
	/** Lizard */
	val lizard = Lizard()
	/** Tiger */
	val tiger = Tiger()
	/** Tuna */
	val tuna = Tuna("Tuna", "Blub blub")
	/** Chicken */
	val chicken = Chicken("Chicken", "Bok bok!")
	/** Snake */
	val snake = Snake()
	/** Dog */
	val dog = Dog()
	/** List of animals */
	val animalsList = listOf<Animal>(lizard, tiger, tuna, chicken, snake, dog)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding?.root)

		initializeViews()
	}

	/**
	 * Initialize views
	 */
	private fun initializeViews() {
		binding?.btnLizard?.setOnClickListener {
			showSound(lizard)
		}

		binding?.btnTiger?.setOnClickListener {
			showSound(tiger)
		}

		binding?.btnTuna?.setOnClickListener {
			showSound(tuna)
		}

		binding?.btnChicken?.setOnClickListener {
			showSound(chicken)
		}

		binding?.btnSnake?.setOnClickListener {
			showSound(snake)
		}

		binding?.btnDog?.setOnClickListener {
			showSound(dog)
		}

		binding?.btnMammal?.setOnClickListener {
			showSpeciesList(Mammal::class.java)
		}

		binding?.btnReptile?.setOnClickListener {
			showSpeciesList(Reptile::class.java)
		}

		binding?.btnBird?.setOnClickListener {
			showSpeciesList(Bird::class.java)
		}

		binding?.btnFish?.setOnClickListener {
			showSpeciesList(Fish::class.java)
		}
	}

	/**
	 * Display animal sound in text view
	 *
	 * @param animal Animal
	 */
	private fun showSound(animal: Animal) {
		binding?.textSound?.text = animal.sound
	}

	/**
	 * Display list of animals based from a specie
	 *
	 * @param specie Specie
	 */
	// This accepts a class (or an interface) that is extending the interface Specie
	private fun showSpeciesList(specie: Class<out Specie>) {
		// For long texts, it is better to use StringBuilder
		val builder = StringBuilder()

		// If you're gonna go through the whole list, you can also use forEach.
		// There's also forEachIndexed if you're gonna need the index of the item
		animalsList.forEach { animal ->
			// ↑ You can also not set the name of the value-parameter (animal) for this just 「animalsList.forEach {・・}」
			// and use 'it' when trying to access the item's properties. See commented block of code below

			// You can know if a class is being extended by an interface or implementing a class
			// by doing this ↓
			if (specie.isAssignableFrom(animal.javaClass)) {
				builder.append(animal.name)
				builder.append("\n")
			}
		}

		/*animalsList.forEach {
			// To access item's property
			it.name
			it.sound
		}*/

		binding?.textSpecies?.text = builder.toString()
	}
}