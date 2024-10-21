package br.edu.ifsp.aluno.henrich.petlife

import android.os.Bundle
import br.edu.ifsp.aluno.henrich.petlife.databinding.ResultProfileBinding

private lateinit var binding: ResultProfileBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ResultProfileBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
}