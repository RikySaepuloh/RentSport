package id.esaku.rentsport.domain.model

data class User(
    val idUser: String,

    val nama: String?,

    val alamat: String,

    val password: String
)