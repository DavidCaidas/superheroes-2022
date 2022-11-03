package com.iesam.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.iesam.superheroe.R
import kotlin.concurrent.thread

class SuperHeroDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_heroe_detail)
        Log.d("@dev", "SuperHereoId: " + getSuperHeroId())
    }

    private fun getSuperHeroId(): Int = intent.getIntExtra(KEY_SUPERHEROE_ID, 0)

    companion object {

        private val KEY_SUPERHEROE_ID = "key_superheroe_id"

        fun getIntent(context: Context, superHeroId: Int): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHEROE_ID, superHeroId)
            return intent
        }
    }
}