package com.example.studyplanner.ui.update
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
import com.example.studyplanner.databinding.FragmentUpdateBinding
import com.example.studyplanner.viewmodel.PlanViewModel

class Update : Fragment() {

    private val viewModel: PlanViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentUpdateBinding.inflate(inflater)

        val args = UpdateArgs.fromBundle(requireArguments())

        binding.apply {
            updTitle.setText(args.planInput.title)
            updDescription.setText(args.planInput.description)

            btnUpdate.setOnClickListener {
                if(TextUtils.isEmpty(updTitle.text)){
                    Toast.makeText(requireContext(), "It's empty!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val plan = updTitle.text
                val description = updDescription.text

                val planInput = PlanInput(
                    args.planInput.id,
                    plan.toString(),
                    description.toString()
                )

                viewModel.update(planInput)
                Toast.makeText(requireContext(), "Updated!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_update_to_plan)
            }
        }

        return binding.root
    }

}