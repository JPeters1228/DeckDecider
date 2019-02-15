package com.shelatok.deckdecider

import android.content.Context
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var colorsList = arrayListOf("W", "U", "B", "R", "G",
            "WU", "WB", "WR", "WG", "UB",
            "UR", "UG", "BR", "BG", "RG",
            "WUB", "WUR", "WUG", "WBR", "WBG",
            "WRG", "UBR", "UBG", "URG", "BRG",
            "WUBR", "WUBG", "WURG", "WBRG", "UBRG", "WUBRG", "-----")

        var namesList = arrayListOf("MONO WHITE", "MONO BLUE", "MONO BLACK", "MONO RED", "MONO GREEN",
            "AZORIUS", "ORZHOV", "BOROS", "SELESNYA", "DIMIR",
            "IZZET", "SIMIC", "RAKDOS", "GOLGARI", "GRUUL",
            "ESPER", "JESKAI", "BANT", "MARDU", "ABZAN",
            "NAYA", "GRIXIS", "SULTAI", "TEMUR", "JUND",
            "NON-GREEN", "NON-RED", "NON-BLACK", "NON-BLUE", "NON-WHITE", "5 COLOR", "COLORLESS")

        decideButton.setOnClickListener {
            wPic.visibility = INVISIBLE
            uPic.visibility = INVISIBLE
            bPic.visibility = INVISIBLE
            rPic.visibility = INVISIBLE
            gPic.visibility = INVISIBLE

            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (vibrator.hasVibrator()) { // Vibrator availability checking
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE)) // New vibrate method for API Level 26 or higher
                } else {
                    vibrator.vibrate(100) // Vibrate method for below API Level 26
                }
            }
            //var name = nameText.text.toString()
            //name = name.toLowerCase()

            if (nameText.text.isEmpty()){
                colorsList = arrayListOf("W", "U", "B", "R", "G",
                    "WU", "WB", "WR", "WG", "UB",
                    "UR", "UG", "BR", "BG", "RG",
                    "WUB", "WUR", "WUG", "WBR", "WBG",
                    "WRG", "UBR", "UBG", "URG", "BRG",
                    "WUBR", "WUBG", "WURG", "WBRG", "UBRG", "WUBRG", "-----")

                namesList = arrayListOf("MONO WHITE", "MONO BLUE", "MONO BLACK", "MONO RED", "MONO GREEN",
                    "AZORIUS", "ORZHOV", "BOROS", "SELESNYA", "DIMIR",
                    "IZZET", "SIMIC", "RAKDOS", "GOLGARI", "GRUUL",
                    "ESPER", "JESKAI", "BANT", "MARDU", "ABZAN",
                    "NAYA", "GRIXIS", "SULTAI", "TEMUR", "JUND",
                    "NON-GREEN", "NON-RED", "NON-BLACK", "NON-BLUE", "NON-WHITE", "5 COLOR", "COLORLESS")
            } else if (nameText.text.toString().toLowerCase() == "jason"){
                colorsList = arrayListOf("WUBRG", "UG", "RG", "WR", "UBR", "URG", "G", "UR",
                                             "U", "W", "WB", "WUBRG")
                namesList = arrayListOf("Child of Alara", "Kumena, Tyrant of Orazca", "Omnath, Locus of Rage",
                                            "Brion Stoutarm", "Gwendlyn Di Corci", "Animar, Soul of Elements",
                                            "Ezuri, Renegade Leader", "Niv-Mizzet, Parun", "Sun Quan, Lord of Wu",
                                            "Mangara of Corondor", "Karlov of the Ghost Council", "Progenitus")
            } else {
                colorsList = arrayListOf("W", "U", "B", "R", "G",
                    "WU", "WB", "WR", "WG", "UB",
                    "UR", "UG", "BR", "BG", "RG",
                    "WUB", "WUR", "WUG", "WBR", "WBG",
                    "WRG", "UBR", "UBG", "URG", "BRG",
                    "WUBR", "WUBG", "WURG", "WBRG", "UBRG", "WUBRG", "-----")

                namesList = arrayListOf("MONO WHITE", "MONO BLUE", "MONO BLACK", "MONO RED", "MONO GREEN",
                    "AZORIUS", "ORZHOV", "BOROS", "SELESNYA", "DIMIR",
                    "IZZET", "SIMIC", "RAKDOS", "GOLGARI", "GRUUL",
                    "ESPER", "JESKAI", "BANT", "MARDU", "ABZAN",
                    "NAYA", "GRIXIS", "SULTAI", "TEMUR", "JUND",
                    "NON-GREEN", "NON-RED", "NON-BLACK", "NON-BLUE", "NON-WHITE", "5 COLOR", "COLORLESS")
                nameText.text.clear()
                Toast.makeText(applicationContext, "Name not supported", Toast.LENGTH_SHORT).show()
            }



            val randomNumber = Random().nextInt(colorsList.count())
            //wubrgTxt.text = colorsList[randomNumber]  I don't need the color list to display anymore
            nicknameTxt.text = namesList[randomNumber]

            if(colorsList[randomNumber].contains("W")){
                wPic.visibility = VISIBLE
            }
            if(colorsList[randomNumber].contains("U")){
                uPic.visibility = VISIBLE
            }
            if(colorsList[randomNumber].contains("B")){
                bPic.visibility = VISIBLE
            }
            if(colorsList[randomNumber].contains("R")){
                rPic.visibility = VISIBLE
            }
            if(colorsList[randomNumber].contains("G")){
                gPic.visibility = VISIBLE
            }

        }
    }
}
