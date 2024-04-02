package com.example.fonar_app

import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fonar_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.flashOnBtn.setOnClickListener {
            onFlash()

        }
        binding.flashOffBtn.setOnClickListener {
            offFlash()

        }

        }
    private fun onFlash(){
        var cameraManager:CameraManager? = null
        cameraManager =getSystemService(CAMERA_SERVICE)as CameraManager

        try {
            var cameraId:String?=null
            cameraId = cameraManager.cameraIdList[0]
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            cameraManager!!.setTorchMode(cameraId,true)

        }catch (e:CameraAccessException){
            Toast.makeText(this,"Exception:"+e.message,Toast.LENGTH_SHORT).show()

        }
    }
    private fun offFlash(){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            val cameraManager = getSystemService(CAMERA_SERVICE)as CameraManager

            try {
                val camemeraId =cameraManager.cameraIdList[0]
                cameraManager.setTorchMode(camemeraId,false)
            }catch (e:CameraAccessException){

            }
        }
    }
    }
