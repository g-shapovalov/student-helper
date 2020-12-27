package com.example.studenthelper.ui.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.studenthelper.R
import kotlinx.android.synthetic.main.fragment_profile_auth_step_2.*

class ProfileAuthStep2Fragment : Fragment(R.layout.fragment_profile_auth_step_2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnProfileAuthStep2Confirm.setOnClickListener {
            findNavController().navigate(
                R.id.action_profileAuthStep2Fragment_to_semestrsFragment
            )
        }
    }
}