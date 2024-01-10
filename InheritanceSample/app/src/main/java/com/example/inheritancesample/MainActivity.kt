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

	// In this example I created an enum of Animals so that it can be reused throughout this app.
	// You can actually use a list for this but it would only be beneficial for the displaying of animals
	// under the species text box.
	/**
	 * Enum class of animals
	 *
	 * @param animal Animal object
	 */
	private enum class ANIMAL(val animal: Animal) {
		// There are two ways to declare a derived class.
		// 1) Override the inherited variables in to the class (see Lizard, Tiger, Snake, Dog classes)
		// 2) Or put the overridden variables in the parameters and initialize them upon making a new object (see Tuna and Chicken classes)
		/** Lizard */
		LIZARD(Lizard()),
		/** Tiger */
		TIGER(Tiger()),
		/** Tuna */
		TUNA(Tuna("Tuna", "Blub blub")),
		/** Chicken */
		CHICKEN(Chicken("Chicken", "Bok bok!")),
		/** Snake */
		SNAKE(Snake()),
		/** Dog */
		DOG(Dog())
	}

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
			// In the case that the enum of Animals is non-existent, you can actually just do
			// showSound(Lizard())
			// but it would create a new object everytime you click the button thus using more memory
			showSound(ANIMAL.LIZARD)
		}

		binding?.btnTiger?.setOnClickListener {
			showSound(ANIMAL.TIGER)
		}

		binding?.btnTuna?.setOnClickListener {
			showSound(ANIMAL.TUNA)
		}

		binding?.btnChicken?.setOnClickListener {
			showSound(ANIMAL.CHICKEN)
		}

		binding?.btnSnake?.setOnClickListener {
			showSound(ANIMAL.SNAKE)
		}

		binding?.btnDog?.setOnClickListener {
			showSound(ANIMAL.DOG)
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
	private fun showSound(animal: ANIMAL) {
		binding?.textSound?.text = animal.animal.sound
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
		ANIMAL.entries.forEach {
			// You can know if a class is being extended by an interface or implementing a class
			// by doing this ↓
			if (specie.isAssignableFrom(it.animal.javaClass)) {
				builder.append(it.animal.name)
				builder.append("\n")
			}
		}
		val text = builder.toString()
		binding?.textSpecies?.text = text
	}
}