package br.edu.ifsp.aluno.henrich.petlife
package com.example.petlife

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.aluno.henrich.petlife.databinding.ActivityEditPetBinding

class EditPetActivity : AppCompatActivity() {

    private lateinit var pet: Pet
    private lateinit var binding: ActivityEditPetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pet = intent.getSerializableExtra("pet") as Pet

        // Preencher os campos com os dados atuais do pet
        binding.etPetName.setText(pet.name)
        binding.etPetBirthDate.setText(pet.birthDate)
        binding.etPetType.setText(pet.type)
        binding.etPetColor.setText(pet.color)
        binding.etPetSize.setText(pet.size)

        // Botão salvar
        binding.btnSavePet.setOnClickListener {
            pet.name = binding.etPetName.text.toString()
            pet.birthDate = binding.etPetBirthDate.text.toString()
            pet.type = binding.etPetType.text.toString()
            pet.color = binding.etPetColor.text.toString()
            pet.size = binding.etPetSize.text.toString()

            val resultIntent = intent
            resultIntent.putExtra("pet", pet)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}
