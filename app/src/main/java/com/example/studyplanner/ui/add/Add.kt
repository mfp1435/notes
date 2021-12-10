package com.example.studyplanner.ui.add
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.studyplanner.R
import com.example.studyplanner.database.PlanInput
import com.example.studyplanner.databinding.FragmentAddBinding
import com.example.studyplanner.viewmodel.PlanViewModel

class Add : Fragment() {
    private val viewModel: PlanViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAddBinding.inflate(inflater)
        binding.apply {
            btnAdd.setOnClickListener{
                if(TextUtils.isEmpty((edtTitle.text))){
                    Toast.makeText(requireContext(), "Please Fill The Blank!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val titlePlan = edtTitle.text.toString()
                val descriptionPlan = edtDescription.text.toString()

                val planInput = PlanInput (
                    0,
                    titlePlan,descriptionPlan)

                viewModel.insert(planInput)
                Toast.makeText(requireContext(), "Successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_add_to_plan)
            }
        }
        return binding.root
    }
}