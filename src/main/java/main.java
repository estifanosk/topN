import Service.UserCollector;
import Service.UserService;
import model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class main {

    public static Integer numUsers = 5;
    public static String baseUrl = "https://appsheettest1.azurewebsites.net/";

    public static void main(String[] args) throws Exception {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserService userService = retrofit.create(UserService.class);

        UserCollector collector = new UserCollector(userService);
        collector.collect(numUsers);

        System.out.println("************* The top 5 youngest users ******************");
        System.out.println("");
        for (User usr : collector.youngestUsers()) {
            System.out.println(usr);
        }
    }
}
