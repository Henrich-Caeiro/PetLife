package br.edu.ifsp.aluno.henrich.petlife

data class Pet(
    var name: String,
    var birthDate: String,
    var type: String, // "Cão" ou "Gato"
    var color: String,
    var size: String, // "Pequeno", "Médio" ou "Grande"
    var lastVetVisit: String,
    var lastVaccination: String,
    var lastPetshopVisit: String
)
