package com.iesam.superheroe.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iesam.superheroe.R

class SuperHeroeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroe_detail)
        Log.d("@dev", "SuperHereoId: " + getSuperHeroeId())
    }

    private fun getSuperHeroeId(): Int = intent.getIntExtra(KEY_SUPERHEROE_ID, 0)

    companion object {

        private val KEY_SUPERHEROE_ID = "key_superheroe_id"

        fun getIntent(context: Context, superHeroeId: Int): Intent {
            val intent = Intent(context, SuperHeroeDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHEROE_ID, superHeroeId)
            return intent
        }
    }
}