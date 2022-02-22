package com.example.kotlinrecyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "ContactsAdapter"
class ContactsAdapter(val context: Context, val contacts: List<Person>) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    // Step 5. Create a RecyclerView.Adapter and ViewHolder to render the item -> created both adapter and custom ViewHolder in ContactsAdapter.kt, DONE
    // need to auto generate and override following mandatory functions:

    // Create a new view -> EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    // Bind the data at position into the viewHolder -> INEXPENSIVE
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder: $position")
        val contact: Person = contacts[position]
        holder.bind(contact)
    }

    // return how many items are in the data set
    override fun getItemCount(): Int {
        return contacts.size
    }

    //Creating own ViewHolder for RV
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //from the item_person.xml view
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvPos = itemView.findViewById<TextView>(R.id.tvPos)

        //Create member function for the function in the onBindViewHolder
        fun bind(contact: Person) {
            // Bind the data in the contact into the views!
            tvName.text = contact.name
            tvPos.text = "Position: ${contact.pos}"
        }
    }

}
