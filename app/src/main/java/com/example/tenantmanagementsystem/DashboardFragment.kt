
package com.example.tenantmanagementsystem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DashboardFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        android.util.Log.d("FragmentLifecycle", "Dashboard onCreate")
    }

    override fun onStart() {
        super.onStart()
        android.util.Log.d("FragmentLifecycle", "Dashboard onStart")
    }

    override fun onPause() {
        super.onPause()
        android.util.Log.d("FragmentLifecycle", "Dashboard onPause")
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.d("FragmentLifecycle", "Dashboard onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.d("FragmentLifecycle", "Dashboard onDestroy")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            R.layout.fragment_dashboard,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.addTenantButton)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_dashboardFragment_to_addTenantFragment
                )
            }

        view.findViewById<Button>(R.id.viewTenantsButton)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.action_dashboardFragment_to_viewTenantsFragment
                )
            }
    }

    override fun onResume() {
        super.onResume()

        view?.findViewById<TextView>(R.id.tenantCountText)?.text =
            "Total Tenants: ${TenantRepository.tenants.size}"

        view?.findViewById<TextView>(R.id.totalRentText)?.text =
            "Total Rent: KSh ${TenantRepository.totalRent()}"
    }
}
