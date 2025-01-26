package com.plcoding.rabbitsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.plcoding.rabbitsapp.ui.theme.RabbitsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RabbitsAppTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {

                    val viewModel : MainViewModel = hiltViewModel()
                    val rabbit = viewModel.state.value.rabbit
                    val isLoading = viewModel.state.value.isLoading

                    rabbit?.let {

                        Image(
                            painter = rememberImagePainter(
                                data = rabbit.imageUrl,
                                builder = { crossfade(true) }
                            ),
                            contentDescription = "Rabbit"
                        )
                        Spacer(
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text = rabbit.name,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Spacer(
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text = rabbit.description,
                                    color = Color.White,
                        )
                        Spacer(
                            modifier = Modifier.padding(8.dp)
                        )

                    }
                    Button(
                        onClick = viewModel::getRandomRabbit,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Next Rabbit")
                    }

                    Spacer(
                        modifier = Modifier.padding(8.dp)
                    )

                    if(isLoading) {
                        CircularProgressIndicator()
                    }


                }

            }
        }
    }
}