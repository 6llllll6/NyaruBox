package com.example.nyarubox

import android.content.Intent
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var mSoundPool: SoundPool? = null
//        var audioAttributes: AudioAttributes? = null
//
//        audioAttributes = AudioAttributes.Builder()
//            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//            .setUsage(AudioAttributes.USAGE_MEDIA)
//            .build()
//
//        mSoundPool = SoundPool.Builder()
//            .setMaxStreams(1)
//            .setAudioAttributes(audioAttributes)
//            .build()
//
//        val soundId_night = mSoundPool.load(assets.openFd("night.mp3"), 1)
//        val soundId_greeting = mSoundPool.load(assets.openFd("secret base ~君がくれたもの~.wav"), 1)
//
//
//        val night = findViewById<Button>(R.id.btnnight)
//        val greeting = findViewById<Button>(R.id.btnnyarugreeting)
        val comment = findViewById<ImageButton>(R.id.comment_img)
        val sport = findViewById<Button>(R.id.sportb)
        val food = findViewById<Button>(R.id.foodb)
        val medical = findViewById<Button>(R.id.medicalb)
        val sleep = findViewById<Button>(R.id.sleepb)
//        night.setOnClickListener{
//                mSoundPool.play(soundId_night, 1F, 1F, 0, 0, 1F)
//        }
//        greeting.setOnClickListener{
//                mSoundPool.play(soundId_greeting, 1F, 1F, 0, 0, 1F);
//        }
        comment.setOnClickListener{
            val intent= Intent();
            intent.setClass(this,CommentActivity::class.java)
            startActivity(intent)

        }
        sport.setOnClickListener{
            val intent= Intent();
            intent.setClass(this,SportActivity::class.java)
            startActivity(intent)

        }
        food.setOnClickListener{
            val intent= Intent();
            intent.setClass(this,FoodActivity::class.java)
            startActivity(intent)

        }
        medical.setOnClickListener{
            val intent= Intent();
            intent.setClass(this,MedicalActivity::class.java)
            startActivity(intent)

        }
        sleep.setOnClickListener{
            val intent= Intent();
            intent.setClass(this,SleepActivity::class.java)
            startActivity(intent)

        }
    }

}