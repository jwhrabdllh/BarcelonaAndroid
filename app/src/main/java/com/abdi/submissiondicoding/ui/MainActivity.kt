package com.abdi.submissiondicoding.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdi.submissiondicoding.R
import com.abdi.submissiondicoding.adapter.ClubAdapter
import com.abdi.submissiondicoding.data.Club
import com.abdi.submissiondicoding.data.ClubData

class MainActivity : AppCompatActivity() {
    private lateinit var rvBarcelona: RecyclerView
    private var list: ArrayList<Club> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Barcelona"

        rvBarcelona = findViewById(R.id.rv_barcelona)
        rvBarcelona.setHasFixedSize(true)

        list.addAll(ClubData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvBarcelona.layoutManager = LinearLayoutManager(this)
        val clubAdapter = ClubAdapter(list)
        rvBarcelona.adapter = clubAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about_page -> {
                val aboutMe = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutMe)
            }
        }
    }
}