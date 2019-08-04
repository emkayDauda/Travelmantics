package com.emkaydauda.travelmantics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emkaydauda.travelmantics.models.TravelDeals
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_insert.*

class InsertActivity : AppCompatActivity() {

    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var firebaseDatabaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        firebaseDatabase = FirebaseDatabase.getInstance()
        firebaseDatabaseReference  = firebaseDatabase.reference.child("travelDeals")

        saveDeal.setOnClickListener {
            saveDeal(TravelDeals(inputName.text.toString(), inputPrice.text.toString(), inputDescription.text.toString(),""))

        }
    }

    private fun saveDeal(deal: TravelDeals){

        firebaseDatabaseReference.push().setValue(deal)

        clean()
    }

    private fun clean(){
        inputName.setText("")
        inputPrice.setText("")
        inputDescription.setText("")
        inputName.requestFocus()
    }
}
