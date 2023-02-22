package com.example.parcijalniispit

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment: Fragment(R.layout.fragment) {

    private val listaPodaci: ArrayList<Podaci> = ArrayList()

    private lateinit var newRecycleview : RecyclerView

    private lateinit var etPodsjetnik : EditText
    private lateinit var etDetalji    : EditText
    private lateinit var bPodsjetnik  : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment, container, false)

        etPodsjetnik = v.findViewById(R.id.etPodsjetnik)
        etDetalji = v.findViewById(R.id.etDetalji)
        bPodsjetnik = v.findViewById(R.id.bPodsjetnik)

        bPodsjetnik.setOnClickListener{
            if(etPodsjetnik.text.toString().isEmpty() && etDetalji.text.toString().isEmpty())
            {
                Toast.makeText(getActivity(),"Nisu ispunjeni podsjetnik i detalji!",Toast.LENGTH_SHORT).show();
            }
            else if(etPodsjetnik.text.toString().isEmpty() && etDetalji.text.toString().isNotEmpty())
            {
                Toast.makeText(getActivity(),"Nije ispunjen podsjetnik!",Toast.LENGTH_SHORT).show();
            }
            else if(etPodsjetnik.text.toString().isNotEmpty() && etDetalji.text.toString().isEmpty())
            {
                Toast.makeText(getActivity(),"Nije ispunjen detalj",Toast.LENGTH_SHORT).show();
            }
            else
            {
                addPodaci()

                newRecycleview = v.findViewById(R.id.myRecyclerView)
                newRecycleview.layoutManager = LinearLayoutManager(getActivity())

                newRecycleview.adapter = PodaciAdapter(listaPodaci)

                ClearData()
            }
        }
        
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }




    private fun addPodaci() {
        listaPodaci.add(Podaci(etPodsjetnik.text.toString(), etDetalji.text.toString()))
    }

    private fun ClearData()
    {
        etPodsjetnik.text.clear()
        etDetalji.text.clear()
    }

    data class Podaci(val pdosjetnik:String, val detalji:String){

    }
}