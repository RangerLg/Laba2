package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.Course
import kotlinx.android.synthetic.main.fragment_profile.Fac
import kotlinx.android.synthetic.main.fragment_profile.Name
import kotlinx.android.synthetic.main.fragment_profile.NameU
import kotlinx.android.synthetic.main.fragment_profile.Pant
import kotlinx.android.synthetic.main.fragment_profile.Sur
import java.sql.Date
import java.time.LocalDate


class EditF : Fragment() {

    private var person: PersonModel? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Name.text = person!!.name;

        Sur.text = person!!.surname;

        Pant.text = person!!.patronymic;

        NameU.text = person!!.nameUniversity;


        Fac.text = person!!.faculty;

        Course.text = person!!.course.toString()
        Editbtn.setOnClickListener {
            Edit();
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun Edit() {
        person!!.name = Name.text.toString();

        person!!.surname = Sur.text.toString();

        person!!.patronymic = Pant.text.toString();

        person!!.nameUniversity = NameU.text.toString();

        person!!.faculty = Fac.text.toString();

        var s = Course.text.toString();
        person!!.course = s.toInt();

        if(editTextDate.text.toString()!="") {
            val date = LocalDate.parse(editTextDate.text.toString());
            if(date>LocalDate.now()){
                Toast.makeText(activity,"TestDate", Toast.LENGTH_LONG).show();
            }
        }


        (activity as MainActivity).ChangeFragment(Profile.newInstance(person!!));
    }

    companion object {
        @JvmStatic
        fun newInstance(model: PersonModel) =
            EditF().apply {
                person = model;
            }
    }
}