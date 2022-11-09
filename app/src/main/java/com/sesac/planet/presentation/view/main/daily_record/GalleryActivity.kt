package com.sesac.planet.presentation.view.main.daily_record

import android.content.ContentUris
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.sesac.planet.R
import com.sesac.planet.databinding.ActivityGalleryBinding
import com.sesac.planet.presentation.view.main.daily_record.adapter.GalleryAdapter

class GalleryActivity : AppCompatActivity() {
    private val binding by lazy { ActivityGalleryBinding.inflate(layoutInflater)}

    //private lateinit var adapter: GalleryAdapter
    private val adapter by lazy { GalleryAdapter(this)}
    private lateinit var imageUriList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        loadPhotos()
    }

    private fun initViews() {
        binding.galleryRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.galleryRecyclerView.adapter = adapter

        binding.completeButton.setOnClickListener {
            val selectedImageUri = adapter.getSelectedImage()
            if(selectedImageUri.isNotEmpty()) {
                val intent = Intent()
                intent.putExtra("selected_image_uri", selectedImageUri)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun loadPhotos() {
        val collection = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

        val projection = arrayOf(MediaStore.Images.Media._ID)
        imageUriList = mutableListOf()
        val cursor = contentResolver.query(
            collection,         //FROM table_name
            projection,         //검색된 각 행에 포함되어야 하는 열의 배열
            null,       //WHERE col = value
            null,    //SELECTION 절에 있는 "?" 자리표시자를 대체하는 값
            MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC" //ORDER BY col, col...
        )

        cursor?.let {
            val columnIndexID = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)

            while (cursor.moveToNext()) {
                //_ID Column 의 값은 이미지의 해당 행에서 가리키는 이미지의 고유식별값이다
                val imageUri = ContentUris.withAppendedId(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    cursor.getLong(columnIndexID)
                )
                imageUriList.add(imageUri.toString())
            }
            cursor.close()
        }
        adapter.setImageUris(imageUriList)
    }
}