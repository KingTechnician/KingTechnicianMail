package com.kingtechnician.kingtechnicianmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView

class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView
        init
        {
            senderTextView = itemView.findViewById(R.id.senderTv)
            titleTextView = itemView.findViewById(R.id.titleTv)
            summaryTextView = itemView.findViewById(R.id.summaryTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.email_item,parent,false)

        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)

        holder.senderTextView.text = email.sender
        holder.titleTextView.text= email.title
        holder.summaryTextView.text = email.summary

    }
}