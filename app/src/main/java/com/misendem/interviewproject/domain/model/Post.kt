package com.misendem.interviewproject.domain.model


interface Post {
    var id: Int?
    var email: String?
    var name: String?
    var phone: String?
    var username: String?
    var website: String?

    var lat: String?
    var lng: String?

    var bs: String?
    var catchPhrase: String?
    var nameCompany: String?

    var city: String?
    var street: String?
    var suite: String?
    var zipcode: String?


}