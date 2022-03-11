import java.util.ArrayList;
import java.util.List;

public class Hero {
    private final String mName;
    private final String mAge;
    private final String mPower;
    private final String mWeakness;
    private static List<Hero> instances = new ArrayList<Hero>();
    private final int mId;

    public Hero(String name, String age, String power, String weakness){
        mName = name;
        mAge = age;
        mPower = power;
        mWeakness = weakness;
        instances.add(this);
        mId = instances.size();
    }

    public String getName(){
        return mName;
    }
    public String getAge(){
        return mAge;
    }
    public String getPower(){
        return mPower;
    }
    public String getWeakness(){
        return mWeakness;
    }
    public static List<Hero> all(){
        return instances;
    }
    public static void clear(){
        instances.clear();
    }
    public int getId(){
        return mId;
    }
    public static Hero find(int id) {
        return instances.get(id - 1);
    }

}