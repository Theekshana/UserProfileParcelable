package com.example.parcelable

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Adding reference for UI
        val saveImage = findViewById<ImageView>(R.id.saveProfilePicture)
        val showName = findViewById<TextView>(R.id.txtName)
        val showEmail = findViewById<TextView>(R.id.txtEmail)
        val showAge = findViewById<TextView>(R.id.txtAge)
        val showNumber = findViewById<TextView>(R.id.txtNumber)

        //Get data from RegisterInfoActivity
        val user = intent.getParcelableExtra<Parcelable>("USER") as User
        saveImage.setImageURI(Uri.parse(user.profileImage))
        showName.text = user.name
        showEmail.text = user.email
        showAge.text = user.age
        showNumber.text = user.number

        showEmail.setOnClickListener {
            sendEmail(arrayOf(user.email))
        }

        showNumber.setOnClickListener {
            callUser(user.number)

        }

    }

    //Compose Email
    private fun sendEmail(addresses: Array<String>) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {

            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)

        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

    }

    //Call user
    private fun callUser(number: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$number")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
