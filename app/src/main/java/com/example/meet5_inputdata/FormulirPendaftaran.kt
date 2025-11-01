package com.example.meet5_inputdata

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormulirPendaftaran(modifier: Modifier = Modifier) {
    // variabel-variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf(value = "") }
    var textJK by remember { mutableStateOf(value = "") }
    var textStatus by remember { mutableStateOf(value = "") }
    var textAlamat by remember { mutableStateOf(value = "") }

    // variabel-variabel untuk menyimpan data yang diperoleh dari komponen UI
    var nama by remember { mutableStateOf(value = "") }
    var jenisKelamin by remember { mutableStateOf(value = "") }
    var statusPerkawinan by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }

    val gender: List<String> = listOf(
        stringResource(id = R.string.laki_laki),
        stringResource(id = R.string.perempuan)
    )

    val status: List<String> = listOf(
        stringResource(id = R.string.janda),
        stringResource(id = R.string.lajang),
        stringResource(id = R.string.duda)
    )

    // Purple gradient background
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF9C27B0),
            Color(0xFF7C4DFF)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            // Header Title
            Text(
                text = "Formulir Pendaftaran",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            // Content Card
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE8DEF8)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )

                {
                    // Label Nama Lengkap
                    Text(
                        text = stringResource(id = R.string.nama_lengkap).uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF49454F),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                    // Input Nama Lengkap
                    OutlinedTextField(
                        value = textNama,
                        singleLine = true,
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text(text = stringResource(id = R.string.placeholder_nama)) },
                        onValueChange = { textNama = it },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF6200EA),
                            unfocusedBorderColor = Color(0xFFB47CFF),
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White
                        )
                    )
                    // Label Jenis Kelamin
                    Text(
                        text = stringResource(id = R.string.jenis_kelamin),
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF49454F),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 8.dp)
                    )
                    // Radio Button Jenis Kelamin
                    Column(modifier = Modifier.fillMaxWidth()) {
                        gender.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = textJK == item,
                                        onClick = { textJK = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textJK == item,
                                    onClick = { textJK = item },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color(0xFF6200EA),
                                        unselectedColor = Color(0xFF49454F)
                                    )
                                )
                                Text(
                                    text = item,
                                    color = Color(0xFF1C1B1F)
                                )
                            }
                        }
                    }

                    // Label Status Perkawinan
                    Text(
                        text = stringResource(id = R.string.status_perkawinan),
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF49454F),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 8.dp)
                    )
                    // Radio Button Status Perkawinan
                    Column(modifier = Modifier.fillMaxWidth()) {
                        status.forEach { item ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .selectable(
                                        selected = textStatus == item,
                                        onClick = { textStatus = item }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = textStatus == item,
                                    onClick = { textStatus = item },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color(0xFF6200EA),
                                        unselectedColor = Color(0xFF49454F)
                                    )
                                )
                                Text(
                                    text = item,
                                    color = Color(0xFF1C1B1F)
                                )
                            }
                        }
                    }
                    // Label Alamat
                    Text(
                        text = stringResource(id = R.string.alamat).uppercase(),
                        style = MaterialTheme.typography.labelLarge,
                        color = Color(0xFF49454F),
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 8.dp)
