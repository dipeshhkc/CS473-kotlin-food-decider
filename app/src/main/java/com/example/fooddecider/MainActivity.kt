package com.example.fooddecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.example.fooddecider.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foods = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
    //Get the instance of Binding Object
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize the binding object with the given below code
        binding = ActivityMainBinding.inflate(layoutInflater)
//        // Replace this line as mentioned below --> setContentView(R.layout.activity_main)
        setContentView(binding.root) // root is your root layout specified in activity_main.xml
        binding.foodText.text= getRandomFood()

        binding.decidebtn.setOnClickListener {
            binding.foodText.text= getRandomFood()
        }

        binding.addFoodbtn.setOnClickListener {
            foods.add(binding.newFoodText.text.toString().trim())
            binding.newFoodText.text.clear()
            //close the keyboard
            // Close the keyboard
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.newFoodText.windowToken, 0)
        }

    }

    fun getRandomFood():String{
        return foods[Random.nextInt(foods.size)]
    }
}

