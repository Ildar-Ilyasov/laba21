import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

class User implements Listener{
    private String name;
    private List<Group> groupList;

    public User(String name) {
        this.name = name;
        this.groupList = new ArrayList<>();
    }

    public void subscribe(Group group) {
        groupList.add(group);
        group.subscribe(this);
    }

    public void unsubscribe(Group group) {
        groupList.remove(group);
        group.unsubscribe(this);
    }

    @Override
    public void update(String str) {
        System.out.println(this.name + ": " + str);
    }
}
public class Main {
    public static void main(String[] args) {

        User user1 = new User("Ильдар");
        User user2 = new User("Виктория");

        Group group1 = new Group("Правильные мысли");
        Group group2 = new Group("ROCKET");
        Group group3 = new Group("Кино");
        Group group4 = new Group("Мотоспорт");

        user1.subscribe(group1);
        user1.subscribe(group2);
        user1.subscribe(group3);

        user2.subscribe(group1);
        user2.subscribe(group2);
        user2.subscribe(group3);
        user2.subscribe(group4);

        group1.informUsers("Новый пост");
        group2.informUsers("В 00:00 новый сингл");
        group3.informUsers("Форсаж 10 в 14:45");
        group4.informUsers("Соревнования");

    }
}