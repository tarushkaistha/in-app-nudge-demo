package com.example.inappdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.inappdemo.databinding.FragmentOneBinding
import com.moengage.inapp.MoEInAppHelper

class FragmentOne : Fragment() {
    private lateinit var binding: FragmentOneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            this.f2Btn.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo)
            }
        }


    }

    override fun onStart() {
        super.onStart()
        MoEInAppHelper.getInstance().setInAppContext(setOf("home"))
    }

    override fun onStop() {
        super.onStop()

        MoEInAppHelper.getInstance().resetInAppContext()
    }

    override fun onResume() {
        super.onResume()

        MoEInAppHelper.getInstance().showNudge(requireActivity())
    }

    override fun onPause() {
        super.onPause()
        MoEInAppHelper.getInstance().resetInAppContext()
    }

}