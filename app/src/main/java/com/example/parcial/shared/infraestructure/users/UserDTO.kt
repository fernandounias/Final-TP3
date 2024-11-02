import com.example.parcial.model.users.Name
import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: Name,
)

data class NameDTO(
    @SerializedName("firstname")  val firstName: String,
    @SerializedName("lastname")  val lastName: String
)