package com.capstone.destimate.view.register

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.capstone.destimate.databinding.ActivityRegisterBinding
import com.capstone.destimate.utils.reduceFileImage
import com.capstone.destimate.utils.uriToFile
import com.capstone.destimate.view.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var currentImageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAction()
    }

    private fun initAction(){
        binding.apply {
            cvSignupProfile.setOnClickListener {
                launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            }
            btLoginLogin.setOnClickListener{
                Toast.makeText(this@RegisterActivity, "Account created!", Toast.LENGTH_LONG).show()
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
        }
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun showImage() {
        currentImageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.imgSignupProfile.setImageURI(it)
        }
    }

    private fun uploadImage() {
        currentImageUri?.let { uri ->
            val imageFile = uriToFile(uri, this).reduceFileImage()
            Log.d("Image File", "showImage: ${imageFile.path}")

//            val email = binding.edLoginEmail.text.toString().trim()
//            val name = binding.edSignupUsername.text.toString().trim()
//            val birth = binding.edSignupDate.text.toString().trim()
//            val password = binding.edLoginPassword.text.toString().trim()
//
//            val requestBody = description.toRequestBody("text/plain".toMediaType())
//            val requestImageFile = imageFile.asRequestBody("image/jpeg".toMediaType())
//            val multipartBody =
//                MultipartBody.Part.createFormData("photo", imageFile.name, requestImageFile)
        }
    }
}