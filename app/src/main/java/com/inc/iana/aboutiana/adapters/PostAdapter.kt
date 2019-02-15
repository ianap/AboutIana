package com.inc.iana.aboutiana.adapters

import android.support.v7.widget.RecyclerView
import android.view.*
import com.inc.iana.aboutiana.R
import android.widget.ImageView
import android.widget.TextView
import com.inc.iana.aboutiana.Model.Item
import android.content.Context
import com.inc.iana.aboutiana.utils.*
import com.bumptech.glide.Glide


class PostAdapter(val items:List<Item>, val context: Context?): RecyclerView.Adapter<ViewHolder>() {


    // Gets the number of posts in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false))
    }

    //
    override fun onBindViewHolder(p0: ViewHolder, position: Int) {
        val item =  items.get(position)
        val utils = HTMLUtils()

        val jsoupText = utils.jsoupUtilText(item.content)
        val jsoupElements = utils.jsoupUtilImage(item.content)

        p0?.postTitle?.text = item.title
        p0?.postDescr?.text = jsoupText


        Glide.with(context!!).load(jsoupElements.get(0).attr("src")).into(p0?.postImage)

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val postImage = view.findViewById(R.id.postImage) as ImageView
    val postTitle = view.findViewById(R.id.post_title) as TextView
    val postDescr = view.findViewById(R.id.post_description) as TextView

}