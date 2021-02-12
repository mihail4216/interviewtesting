package com.misendem.interviewproject.data.model

import com.misendem.interviewproject.data.entity.UserEntity


data class UserModel(
    var address: Address?,
    var company: Company?,
    var email: String?,
    var id: Int?,
    var name: String?,
    var phone: String?,
    var username: String?,
    var website: String?
) {
    data class Address(
        var city: String?,
        var geo: Geo?,
        var street: String?,
        var suite: String?,
        var zipcode: String?
    ) {
        data class Geo(
            var lat: String?,
            var lng: String?
        )
    }

    data class Company(
        var bs: String?,
        var catchPhrase: String?,
        var name: String?
    )

    constructor(user: UserEntity) : this(
        address = Address(
            city = user.city,
            geo = Address.Geo(user.lat, user.lng),
            street = user.street,
            suite = user.suite,
            zipcode = user.zipcode
        ),
        company = Company(
            bs = user.bs,
            catchPhrase = user.catchPhrase,
            name = user.nameCompany
        ),
        email = user.email,
        id = user.id,
        name = user.name,
        phone = user.phone,
        username = user.username,
        website = user.website
    )
}