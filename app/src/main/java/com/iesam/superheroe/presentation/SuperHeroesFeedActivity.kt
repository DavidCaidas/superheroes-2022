package com.iesam.superheroe.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.iesam.superheroe.R
import com.iesam.superheroe.data.superheroe.SuperHeroeDataRepository
import com.iesam.superheroe.domain.GetSuperHeroeFeedUseCase
import kotlin.concurrent.thread

class SuperHeroesFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superheroe_feed)
        test()
    }

    private fun test() {
        val useCase = SuperHeroeFactory().getSuperHeroeUseCase()
        thread {
            val model = useCase.execute()
            Log.d("@dev", "Modelo: $model")
        }
    }
}