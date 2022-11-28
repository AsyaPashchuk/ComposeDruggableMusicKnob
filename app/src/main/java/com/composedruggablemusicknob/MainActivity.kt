package com.composedruggablemusicknob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composedruggablemusicknob.composeable.MusicKnob
import com.composedruggablemusicknob.composeable.Timer
import com.composedruggablemusicknob.composeable.VolumeBar
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF101010))
            ) {

                //Timer
                Box(
                    modifier = Modifier.size(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Timer(
                        totalTime = 10 * 1000L,
                        handleColor = Color.Green,
                        inactiveBarColor = Color.DarkGray,
                        activeBarColor = Color(0xFF37B900),
                        modifier = Modifier.size(150.dp)
                    )
                }
                
                Spacer(modifier = Modifier.height(30.dp))

                //MusicKnob
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .border(1.dp, Color.Green, RoundedCornerShape(10.dp))
                            .padding(30.dp)
                    ) {
                        var volume by remember {
                            mutableStateOf(0f)
                        }
                        val barCount = 20

                        MusicKnob(modifier = Modifier.size(100.dp)) {
                            volume = it
                        }

                        Spacer(modifier = Modifier.width(20.dp))

                        VolumeBar(modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                            activeBars = (barCount * volume).roundToInt(),
                            barCount = barCount
                        )
                    }
                }
            }
        }
    }
}


