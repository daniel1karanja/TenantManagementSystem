package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.content.Intent
import android.net.Uri
import android.widget.Button


class ViewTenantsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_view_tenants,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tenantsText =
            view.findViewById<TextView>(R.id.allTenantsTextView)

        @Suppress("DEPRECATION")
        val newlyAddedTenant =
            arguments?.getSerializable("newTenant") as? Tenant

        val tenants = TenantRepository.tenants

        tenantsText.text = buildString {
            if (newlyAddedTenant != null) {
                appendLine("JUST ADDED:")
                appendLine(newlyAddedTenant.summary())
                appendLine()
                appendLine("------------------------")
                appendLine()
            }


            val callButton =
                view.findViewById<Button>(R.id.callTenantButton)

            val tenantToCall =
                newlyAddedTenant ?: tenants.lastOrNull()

            callButton.isEnabled = tenantToCall != null

            callButton.setOnClickListener {
                tenantToCall?.let { tenant ->
                    val intent = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel:${tenant.phone}")
                    )
                    startActivity(intent)
                }
            }


            appendLine("ALL TENANTS:")

            if (tenants.isEmpty()) {
                appendLine("No tenants yet.")
            } else {
                append(
                    tenants.joinToString("\n\n") {
                        it.summary()
                    }
                )
            }
        }
    }
}
