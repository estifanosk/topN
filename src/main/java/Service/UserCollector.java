package Service;

import model.ListResult;
import model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class UserCollector {

    private UserService userService;
    private PriorityQueue<User> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.getAge(), x.getAge())); //MAX priority queue

    public UserCollector(UserService userService) {
        this.userService = userService;
    }

    public void collect(Integer numUsers) throws Exception {

        Boolean hasMore = true;
        String token = "";

        while (hasMore) {

            ListResult result = userService.list(token).execute().body();
            sortAndCollect(result, pq, numUsers);

            token = result.getToken();
            if (token == null || token.isEmpty()) {
                hasMore = false;
            }
        }
    }

    public Iterable<User> youngestUsers() {
        List<User> youngest = new ArrayList<>(pq);
        Collections.sort(youngest);
        return youngest;
    }

    private void sortAndCollect(ListResult result, PriorityQueue pq, Integer numUsers) throws Exception {
        for (Integer id : result.getResult()) {
            User user = userService.getUser(id).execute().body();
            System.out.println(user);

            if (user != null && user.isNumberValid()) {
                pq.add(user);
                if (pq.size() > numUsers) pq.poll();
            }
        }
    }
}
