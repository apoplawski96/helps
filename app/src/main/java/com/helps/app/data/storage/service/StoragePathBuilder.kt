package com.helps.app.data.storage.service

import javax.inject.Inject

class StoragePathBuilder @Inject constructor() {

    enum class Type {
        UserAvatar,
        HelpsImage,
    }

    fun build(id: String, type: Type): String {
        return when (type) {
            Type.HelpsImage -> {
                "helps/$id/helps_image.jpg"
            }
            Type.UserAvatar -> {
                "user_avatars/$id/avatar.jpg"
            }
        }
    }
}