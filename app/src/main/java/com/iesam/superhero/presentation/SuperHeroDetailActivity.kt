package com.iesam.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.iesam.app.extensions.loadUrl
import com.iesam.superhero.domain.GetSuperHeroDetailUseCase
import com.iesam.superhero.presentation.adapter.SuperHeroDetailsAdapter
import com.iesam.superheroe.R
import com.iesam.superheroe.databinding.ActivitySuperHeroeDetailBinding

class SuperHeroDetailActivity : AppCompatActivity() {

    private var viewModel: SuperHeroDetailViewModel? = null
    private var binding: ActivitySuperHeroeDetailBinding? = null
    private val superHeroDetailAdapter = SuperHeroDetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = SuperHeroFactory().getSuperHeroDetailViewModel(
            applicationContext
        )
        setupBinding()
        setupView()
        setupObservers()
        viewModel?.loadSuperHeroDetails(getSuperHeroId())
    }

    private fun setupBinding() {
        binding = ActivitySuperHeroeDetailBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }

    private fun setupView() {
        binding?.apply {
            viewIntelligence.labelPower.text = getText(R.string.label_intelligence)
            viewSpeed.labelPower.text = getText(R.string.label_speed)
            viewCombat.labelPower.text = getText(R.string.label_combat)
            viewCombat.verticalSeparator.visibility = View.GONE
            listImages.adapter = superHeroDetailAdapter
            listImages.layoutManager =
                LinearLayoutManager(
                    this@SuperHeroDetailActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }

    private fun setupObservers() {
        // Create the observer which updates the UI.
        val superHeroDetailsSubscriber =
            Observer<GetSuperHeroDetailUseCase.SuperHeroDetail> { superHeroDetail ->
                bind(superHeroDetail)
            }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel?.superHeroDetailPublisher?.observe(this, superHeroDetailsSubscriber)
    }


    private fun getSuperHeroId(): Int = intent.getIntExtra(KEY_SUPERHEROE_ID, 0)

    private fun bind(model: GetSuperHeroDetailUseCase.SuperHeroDetail) {
        binding?.apply {
            imageMain.loadUrl(model.mainImageUrl)
            labelNameSuperheroe.text = model.nameSuperHero
            labelRealname.text = model.realName
            bindAlignment(model.alignment)
            labelGroupAffiliation.text = model.groupAffiliation
            viewIntelligence.labelPowerValue.text = model.intelligence
            viewSpeed.labelPowerValue.text = model.speed
            viewCombat.labelPowerValue.text = model.combat
            superHeroDetailAdapter.setDataItems(model.urlImages)
        }
    }

    private fun bindAlignment(alignment: String) {
        binding?.labelAlignment?.apply {
            text = alignment
            if (alignment.lowercase() == "good") {
                setTextColor(ContextCompat.getColor(context, R.color.teal_700))
            } else {
                setTextColor(ContextCompat.getColor(context, R.color.red))
            }
        }
    }

    companion object {
        private val KEY_SUPERHEROE_ID = "key_superheroe_id"

        fun getIntent(context: Context, superHeroId: Int): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHEROE_ID, superHeroId)
            return intent
        }
    }
}