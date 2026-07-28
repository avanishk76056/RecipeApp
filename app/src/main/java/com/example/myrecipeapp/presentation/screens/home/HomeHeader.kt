package com.example.myrecipeapp.presentation.screens.home

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrecipeapp.presentation.components.MyTopBar
import com.example.myrecipeapp.ui.theme.MyOrange


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeHeader () {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = MyOrange.copy(0.3f))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {


        Box(
            modifier = Modifier.size(48.dp).background(color = MyOrange.copy(alpha = 0.9f),
                shape = RoundedCornerShape(16.dp),
            ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.RestaurantMenu,
                contentDescription = "RestaurantMenu Icon",
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(2.dp))

        Column {

            Text(
                text = "Hello, Chef",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Find something delicious to cook",
                color = Color.White,

            )
        }
    }
}