package com.example.blueprintroom

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import androidx.annotation.NonNull

import com.google.android.gms.tasks.OnFailureListener

import com.google.firebase.firestore.DocumentReference

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QueryDocumentSnapshot

import com.google.firebase.firestore.QuerySnapshot

import com.google.android.gms.tasks.OnCompleteListener








class Repository @Inject constructor() {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    init {

    }
    fun addData(first: String, last: String, born: String){
        // Create a new user with a first and last name

        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = first
        user["last"] = last
        user["born"] = born

// Add a new document with a generated ID

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    "TAG",
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e -> Log.w("TAG", "Error adding document", e) }
    }
    fun readData(){
        db.collection("users")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("TAG", document.id + " => " + document.data)
                    }
                } else {
                    Log.w("TAG", "Error getting documents.", task.exception)
                }
            }
    }
}