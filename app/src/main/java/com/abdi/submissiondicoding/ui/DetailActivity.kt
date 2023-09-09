package com.abdi.submissiondicoding.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.abdi.submissiondicoding.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_INFORMATION = "extra_information"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Team"

        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetail: TextView = findViewById(R.id.tv_detail_desc)
        val imgPhoto: ImageView = findViewById(R.id.img_detail_player)
        val tvInformation: TextView = findViewById(R.id.tv_detail_information)

        val playerName = intent.getStringExtra(EXTRA_NAME)
        val playerDetail = intent.getStringExtra(EXTRA_DETAIL)
        val playerPhoto = intent.getIntExtra(EXTRA_PHOTO, 0)
        val playerInformation = intent.getStringExtra(EXTRA_INFORMATION)

        tvName.text = playerName
        tvDetail.text = playerDetail
        tvInformation.text = playerInformation
        Glide.with(this)
            .load(playerPhoto)
            .apply(RequestOptions())
            .into(imgPhoto)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}