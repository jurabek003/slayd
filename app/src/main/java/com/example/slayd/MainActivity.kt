package com.example.slayd


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.slayd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    var images= arrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.coder, R.drawable.image4)
    var currentImage=0

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val anim=AnimationUtils.loadAnimation(this,R.anim.alpa)
        val anim2=AnimationUtils.loadAnimation(this,R.anim.alpa2)
        binding.layener2.setOnClickListener{
            binding.Images.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {

                }

                override fun onAnimationEnd(p0: Animation?) {
                    binding.Images.startAnimation(anim2)

                    if (currentImage < images.count()-1){
                        currentImage++
                        setImages()

                    }


                }

                override fun onAnimationRepeat(p0: Animation?) {

                }

            })

        }
        binding.layener1.setOnClickListener{
            binding.Images.startAnimation(anim)
            anim.setAnimationListener(object :Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    binding.Images.startAnimation(anim2)
                    if (currentImage > 0) {
                        currentImage--
                        setImages()
                    }
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }

            })

            }
        }
        @SuppressLint("SetTextI18n", "ResourceAsColor")
        fun setImages() {
            findViewById<ImageView>(R.id.Images).setImageResource(images[currentImage])
        }
}
