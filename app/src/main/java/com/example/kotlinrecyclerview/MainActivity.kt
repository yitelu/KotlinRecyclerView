package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// Step2: Define a model class to use as the data source -> data class Person, DONE
data class Person(val name: String, val pos: Int)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvContacts = findViewById<RecyclerView>(R.id.rvContacts)

        // the 6 steps of implementing recyclerView
        //
        // 1. Add RecyclerView AndroidX Library to the Gradle build file -> DONE
        // 2. Define a model class to use as the data source -> data class Person, DONE
        // 3. Add a RecyclerView to your activity to display the items -> dragging RV into activity_main.XML, DONE
        // 4. Create a custom row layout XML file to visualize the item -> created new layout XML: item_person.xml, DONE
        // 5. Create a RecyclerView.Adapter and ViewHolder to render the item -> created both adapter and custom ViewHolder in ContactsAdapter.kt, DONE
        // 6. Bind the adapter to the data source to populate the RecyclerView ->


        // list of people for the contact data source
        val contacts: List<Person> = createContacts()

        // step 5: Create a RecyclerView.Adapter and ViewHolder to render the item ->
        rvContacts.adapter = ContactsAdapter(this, contacts)

        // step 6. Bind the adapter to the data source to populate the RecyclerView ->
        rvContacts.layoutManager = LinearLayoutManager(this)

    }

    //use data class Person to create a list of 100 person data
    private fun createContacts(): List<Person>{
        val contacts: MutableList<Person> = mutableListOf<Person>()

        for (i: Int in 1..100){
            contacts.add(Person("Person $i", i))
        }
        return contacts
    }
}