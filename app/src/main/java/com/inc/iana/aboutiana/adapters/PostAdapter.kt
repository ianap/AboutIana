package com.inc.iana.aboutiana.adapters

import android.support.v7.widget.RecyclerView
import android.view.*
import com.inc.iana.aboutiana.R
import android.widget.ImageView
import android.widget.TextView
import com.inc.iana.aboutiana.Model.Item
import android.content.Context


class PostAdapter(val items:List<Item>, val context: Context): RecyclerView.Adapter<ViewHolder>() {


    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        val item =  items.get(position)
        p0?.postTitle?.text = item.title
        p0?.postDescr?.text = item.content

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val postImage = view.findViewById(R.id.postImage) as ImageView
    val postTitle = view.findViewById(R.id.post_title) as TextView
    val postDescr = view.findViewById(R.id.post_description) as TextView

}