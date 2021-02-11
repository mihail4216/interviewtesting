package com.misendem.interviewproject.data.model

import com.misendem.interviewproject.domain.model.Post


data class PostModels(
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

    constructor(post: Post) : this(
        address = Address(
            city = post.city,
            geo = Address.Geo(post.lat, post.lng),
            street = post.street,
            suite = post.suite,
            zipcode = post.zipcode
        ),
        company = Company(
            bs = post.bs,
            catchPhrase = post.catchPhrase,
            name = post.nameCompany
        ),
        email = post.email,
        id = post.id,
        name = post.name,
        phone = post.phone,
        username = post.username,
        website = post.website
    )
}

//data class sd(
//    override var id: Int?,
//    override var email: String?,
//    override var name: String?,
//    override var phone: String?,
//    override var username: String?,
//    override var website: String?,
//    override var lat: String?,
//    override var lng: String?,
//    override var bs: String?,
//    override var catchPhrase: String?,
//    override var nameCompany: String?,
//    override var city: String?,
//    override var street: String?,
//    override var suite: String?,
//    override var zipcode: String?
//) : Post {
//    constructor(post: Post) : this(
//        id = post.id,
//        email = post.email,
//        nameUser = post.name,
//        phone = post.phone,
//        username = post.username,
//        website = post.website,
//        lat = post.lat,
//        lng = post.lng,
//        bs = post.bs,
//        catchPhrase = post.catchPhrase,
//        city = post.city,
//        street = post.street,
//        suite = post.suite,
//        zipcode = post.zipcode,
//        nameCompany = post.nameCompany
//    ) {
//        address = PostModels.Address(city, PostModels.Address.Geo(lat, lng), street, suite, zipcode)
//        company = PostModels.Company(bs, catchPhrase, nameCompany)
//        emailPost = email
//        idPost = id
//        nameUser = name
//        phonePost = phone
//        usernamePost = username
//        websitePost = website
//    }
//
//    var address: PostModels.Address? = null
//    var company: PostModels.Company? = null
//
//    @SerializedName("email")
//    var emailPost: String? = null
//
//    @SerializedName("id")
//    var idPost: Int? = null
//
//    @SerializedName("name")
//    var nameUser: String? = null
//
//    @SerializedName("phone")
//    var phonePost: String? = null
//
//    @SerializedName("username")
//    var usernamePost: String? = null
//
//    @SerializedName("website")
//    var websitePost: String? = null
//
//}