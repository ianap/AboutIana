package com.inc.iana.aboutiana.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inc.iana.aboutiana.ApiService.BloggerApiService
import com.inc.iana.aboutiana.Model.PostList
import com.inc.iana.aboutiana.R
import com.inc.iana.aboutiana.adapters.PostAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import com.inc.iana.aboutiana.ApiService.BloggerApiInterface
import com.inc.iana.aboutiana.Model.Item


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DataScience.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DataScience.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DataScienceFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    private var postListView: RecyclerView? = null
    private val apiServe by lazy {
        BloggerApiInterface.create()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_data_science, container, false)
        val postListView = rootView.findViewById(R.id.rv_data_science_posts) as RecyclerView


        val call = apiServe.getPostList()
        //val call = apiServe.getPostByLabels("Data","Science")
        call.enqueue(object : Callback<PostList> {
            override fun onFailure(call: Call<PostList>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<PostList>?, response: Response<PostList>?) {
                val listPost = response?.body()
                val posts = listPost!!.items

                Log.d("Result", "There are ${posts.size} posts in blogger")
                val adapter = PostAdapter(posts, context)
                postListView.layoutManager=LinearLayoutManager(activity)
                postListView.adapter=adapter
            }
        })
        return rootView
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DataScience.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                DataScienceFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
