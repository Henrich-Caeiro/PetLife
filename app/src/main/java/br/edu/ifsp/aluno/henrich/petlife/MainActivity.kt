package br.edu.ifsp.aluno.henrich.petlife

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.aluno.henrich.petlife.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Instância do pet (armazenada em memória)
    private var pet = Pet(
        "Rex",
        "01/01/2020",
        "Cão",
        "Marrom",
        "Médio",
        "10/10/2023",
        "20/09/2023",
        "05/10/2023"
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Atualizar a tela principal com os dados do pet
//        updateDashboard()


        binding.btnEditPet.setOnClickListener {
            val intent = Intent(this, EditPetActivity::class.java)
            intent.putExtra("pet", pet)
            startActivityForResult(intent, 1)
        }

        // Botão para editar última ida ao veterinário
//        binding.btnEditVetVisit.setOnClickListener {
//            val intent = Intent(this, EditVetVisitActivity::class.java)
//            intent.putExtra("lastVetVisit", pet.lastVetVisit)
//            startActivityForResult(intent, 2)
//        }

        // Botão para editar última vacinação
//        binding.btnEditVaccination.setOnClickListener {
//            val intent = Intent(this, EditVaccinationActivity::class.java)
//            intent.putExtra("lastVaccination", pet.lastVaccination)
//            startActivityForResult(intent, 3)
//        }
    }

    fun updateDashboard() {
        binding.tvPetName.text = pet.name
        binding.tvPetBirthDate.text = pet.birthDate
//        binding.tvPetType.text = pet.type
//        binding.tvPetColor.text = pet.color
//        binding.tvPetSize.text = pet.size
//        binding.tvLastVetVisit.text = pet.lastVetVisit
//        binding.tvLastVaccination.text = pet.lastVaccination
//        binding.tvLastPetshopVisit.text = pet.lastPetshopVisit
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                1 -> { // Edição do pet
                    pet = data?.getSerializableExtra("pet") as Pet
                    updateDashboard()
                }
                2 -> { // Edição da última ida ao veterinário
                    pet.lastVetVisit = data?.getStringExtra("lastVetVisit") ?: pet.lastVetVisit
                    updateDashboard()
                }
                3 -> { // Edição da última vacinação
                    pet.lastVaccination = data?.getStringExtra("lastVaccination") ?: pet.lastVaccination
                    updateDashboard()
                }
            }
        }
    }
}
