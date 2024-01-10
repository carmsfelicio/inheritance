package com.example.inheritancesample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inheritancesample.animals.*
import com.example.inheritancesample.databinding.ActivityMainBinding
import com.example.inheritancesample.species.Bird
import com.example.inheritancesample.species.Fish
import com.example.inheritancesample.species.Mammal
import com.example.inheritancesample.species.Reptile

/**
 * Main activity class
 */
class MainActivity : AppCompatActivity() {

	/** Layout binding */
	private var binding: ActivityMainBinding? = null

	/**
	 * Enum class of animals
	 *
	 * @param animal Animal object
	 */
	private enum class ANIMAL(val animal: Animal) {
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
	private fun showSpeciesList(specie: Class<out Specie>) {
		val builder = StringBuilder()
		ANIMAL.entries.forEach {
			if (specie.isAssignableFrom(it.animal.javaClass)) {
				builder.append(it.animal.name)
				builder.append("\n")
			}
		}
		val text = builder.toString()
		binding?.textSpecies?.text = text
	}
}