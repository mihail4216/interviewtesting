package com.misendem.interviewproject.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.misendem.interviewproject.data.model.UserModel

@Entity
data class UserEntity(
    @PrimaryKey
    var id: Int?,
    var email: String?,
    var name: String?,
    var phone: String?,
    var username: String?,
    var website: String?,
    var lat: String?,
    var lng: String?,
    var bs: String?,
    var catchPhrase: String?,
    var nameCompany: String?,
    var city: String?,
    var street: String?,
    var suite: String?,
    var zipcode: String?
) {
    constructor(post: UserModel) : this(
        id = post.id,
        email = post.email,
        name = post.name,
        phone = post.phone,
        username = post.username,
        website = post.website,
        lat = post.address?.geo?.lat,
        lng = post.address?.geo?.lng,
        bs = post.company?.bs,
        catchPhrase = post.company?.catchPhrase,
        nameCompany = post.company?.name,
        city = post.address?.city,
        street = post.address?.street,
        suite = post.address?.suite,
        zipcode = post.address?.zipcode
    )
}