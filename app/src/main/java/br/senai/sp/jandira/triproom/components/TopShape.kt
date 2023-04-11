package br.senai.sp.jandira.triproom.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TopShape() {
    Card(
        modifier = Modifier
            .height(height = 40.dp)
            .width(width = 120.dp),
        backgroundColor = Color(207, 6, 240),
        shape = RoundedCornerShape(bottomStart = 16.dp)
    ) {

    }
}

@Preview
@Composable
fun TopFormPreview() {
    TopShape()
}