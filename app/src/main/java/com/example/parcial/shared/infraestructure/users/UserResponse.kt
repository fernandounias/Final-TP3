import com.example.parcial.model.model.user.Name
import com.example.parcial.model.model.user.User
import com.google.gson.annotations.SerializedName


data class UserResponse(

    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: NameResponse,

    ) {
    fun toModel() = User(
        id,
        email,
        username,
        password,
        name = name.toName(),

        )
}


data class NameResponse(
    @SerializedName("firstname") val firstName: String,
    @SerializedName("lastname") val lastName: String
) {
    fun toName() = Name(
        firstName = firstName,
        lastName = lastName
    )
}
