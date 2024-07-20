package com.example.contactsapp

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.contactsapp.data.DataSource
import com.example.contactsapp.model.Contact
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onStart() {
        super.onStart()
        requestCallPermission(this)
    }
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactsAppTheme {
                val context = LocalContext.current
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Contacts App") },
                            actions = {
                                IconButton(onClick = {
                                    val homeNumber = "+022002000"
                                    makePhoneCall(homeNumber, context)
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_home_24),
                                        contentDescription = "Home Icon"
                                    )
                                }
                            }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ContactList(contacts = DataSource().getContactsData())
                    }
                }
            }
        }
    }
}



fun requestCallPermission(context: Context){
    val permission = Manifest.permission.CALL_PHONE
    if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(context as Activity, arrayOf(permission), 0)
    }
}

fun makePhoneCall(phoneNumber:String, context: Context) {
    try {
        val intent = Intent(Intent.ACTION_CALL)
        val phoneUri = Uri.parse("tel:$phoneNumber")
        intent.data = phoneUri

        val permission = Manifest.permission.CALL_PHONE

        if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            context.startActivity(intent)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Toast.makeText(context, "Error making phone call", Toast.LENGTH_LONG).show()
    }
}

@Composable
fun ContactList(contacts: List<Contact>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        items(contacts) { contact ->
            ContactListItem(contact)
        }


    }
}

@Composable
fun ContactListItem(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current



    Card(
        modifier = modifier.clickable {
            val u = Uri.parse("tel:" + contact.phoneNumber)
            val i = Intent(Intent.ACTION_DIAL, u)
            context.startActivity(i)
        }

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = contact.picture),
                contentDescription = contact.description
            )
            Text(text = contact.name)
            Text(text = contact.phoneNumber)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun ContactListPreview() {
    ContactList(contacts = DataSource().getContactsData())
}