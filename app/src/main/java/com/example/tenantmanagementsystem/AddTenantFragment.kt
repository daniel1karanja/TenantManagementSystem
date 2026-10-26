
package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class AddTenantFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_add_tenant,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput =
            view.findViewById<EditText>(R.id.tenantNameEditText)

        val phoneInput =
            view.findViewById<EditText>(R.id.phoneEditText)

        val rentInput =
            view.findViewById<EditText>(R.id.rentEditText)

        val saveButton =
            view.findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val phone = phoneInput.text.toString().trim()
            val rent = rentInput.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || rent.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val tenant = Tenant(name, phone, rent)
            TenantRepository.addTenant(tenant)

            val bundle = Bundle().apply {
                putSerializable("newTenant", tenant)
            }

            findNavController().navigate(
                R.id.action_addTenantFragment_to_viewTenantsFragment,
                bundle
            )
        }
    }
}
