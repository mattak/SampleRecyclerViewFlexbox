package me.mattak.samplerecyclerviewflow

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import android.os.Bundle
import me.mattak.samplerecyclerviewflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(
                binding.container.id,
                SampleFragment.newInstance()
            )
        }
    }
}