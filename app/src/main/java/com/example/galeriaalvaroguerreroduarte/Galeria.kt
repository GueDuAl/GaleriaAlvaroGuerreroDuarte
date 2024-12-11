package com.example.galeriaalvaroguerreroduarte

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun Galeria() {
    val context = LocalContext.current
    val imagenes = listOf(
        Imagen("Ciudad", R.drawable.imagen1),
        Imagen("Paseo", R.drawable.imagen2),
        Imagen("Campo", R.drawable.imagen3),
        Imagen("Lago", R.drawable.imagen4),
        Imagen("Oceano", R.drawable.imagen5),
        Imagen("Mar", R.drawable.imagen6),
        Imagen("Estacion", R.drawable.imagen7),
        Imagen("Joven", R.drawable.imagen8)

    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imagenes) { imagen ->
            ImagenItem(imagen = imagen, onClick = {
                Toast.makeText(context, "Pulsaste: ${imagen.nombre}", Toast.LENGTH_SHORT).show()
            })
        }
    }
}

@Composable
fun ImagenItem(imagen: Imagen, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imagen.imagendraw),
                contentDescription = imagen.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = imagen.nombre,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }

}
