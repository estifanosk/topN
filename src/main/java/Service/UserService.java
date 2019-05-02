package Service;

import model.ListResult;
import model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("sample/list")
    Call<ListResult> list(@Query("token") String token);

    @GET("sample/detail/{id}")
    Call<User> getUser(@Path("id") Integer id);
}
