package br.edu.ifsp.aluno.henrich.petlife

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.aluno.henrich.petlife.databinding.ActivityEditVaccinationBinding

class EditVaccinationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditVaccinationBinding
    private var lastVaccination: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditVaccinationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lastVaccination = intent.getStringExtra("lastVaccination") ?: ""

        // Preencher o campo com a última data
        binding.etLastVaccination.setText(lastVaccination)

        // Botão salvar
        binding.btnSaveVaccination.setOnClickListener {
            val newLastVaccination = binding.etLastVaccination.text.toString()

            val resultIntent = intent
            resultIntent.putExtra("lastVaccination", newLastVaccination)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
