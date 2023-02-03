package com.kingtechnician.kingtechnicianmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var emails: List<Email>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView = findViewById<RecyclerView>(R.id.emailsRv)
        var emails = EmailFetcher.getEmails()
        var mailAdapter = EmailAdapter(emails)
        recyclerView.adapter = mailAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        var loadMoreButton = findViewById<Button>(R.id.loadMoreButton)
        loadMoreButton.setOnClickListener{
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            mailAdapter.notifyDataSetChanged()
        }
    }
}