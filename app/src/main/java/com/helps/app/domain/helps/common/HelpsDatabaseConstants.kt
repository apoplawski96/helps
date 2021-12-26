package com.helps.app.domain.helps.common

interface Collection {

    val name: String
}

object HelpsDatabaseConstants {

    object HelpsCollection : Collection {

        object Keys {

            const val KEY_USER_UUID = "user_uuid"
            const val KEY_DESCRIPTION = "description"
            const val KEY_HASHTAGS = "hashtags"
            const val LOCATION = "location"
            const val PHOTOS = "photos"
            const val TIMESTAMP = "timestamp"
        }

        override val name: String = "collection_helps"
    }
}