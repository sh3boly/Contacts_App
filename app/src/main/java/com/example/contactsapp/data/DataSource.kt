package com.example.contactsapp.data

import com.example.contactsapp.R
import com.example.contactsapp.model.Contact

class DataSource {
    fun getContactsData(): List<Contact>{
        val contacts = mutableListOf<Contact>()
        contacts.add(
            Contact(name = "Auntie",
                description = "Auntie",
                picture = R.drawable.auntie,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Brother",
                description = "Brother",
                picture = R.drawable.brother,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Daughter",
                description = "Daughter",
                picture = R.drawable.daughter,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "friend_1",
                description = "friend_1",
                picture = R.drawable.friend_1,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "friend_2",
                description = "friend_2",
                picture = R.drawable.friend_2,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "grandfather",
                description = "grandfather",
                picture = R.drawable.grandfather,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Granny",
                description = "granny",
                picture = R.drawable.granny,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Neighbor",
                description = "Neighbor",
                picture = R.drawable.neigbour,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Sister",
                description = "Sister",
                picture = R.drawable.sister,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Son",
                description = "Son",
                picture = R.drawable.son,
                phoneNumber = "+201112345678")
        )
        contacts.add(
            Contact(name = "Uncle",
                description = "Uncle",
                picture = R.drawable.uncle,
                phoneNumber = "+201112345678")
        )
        return contacts
    }
}