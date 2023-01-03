package com.example.app7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class SimpleFragment : Fragment() {

    companion object {
        val messageId = "messageId"
        fun newInstance(message: String) : SimpleFragment {
            // create the fragment
            val fragment = SimpleFragment()
            // create a bundle for message/id
            val bundle = Bundle(1)
            // load up the bundle
            bundle.putString(messageId, message)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // get the ID from the bundle
        val message = requireArguments().getString(messageId)

        // inflate the view as normal
        val view = inflater.inflate(R.layout.fragment_layout_simple, container, false)

        // get a reference to TextView
        val tv = view.findViewById<TextView>(R.id.tvFragmentValue)
        tv.text = message

        // return view
        return view
    }
}