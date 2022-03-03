import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String mName;
    private String mCause;
    private String mMaximum;
    private static List<Squad> instances = new ArrayList<>();
    private int mId;
    private List<Hero> mHeroes;

    public Squad(String name, String cause, String maximum){
        mName = name;
        mCause = cause;
        mMaximum = maximum;
        instances.add(this);
        mId = instances.size();
        mHeroes = new ArrayList<Hero>();

    }

    public String getName(){
        return mName;
    }

    public String getCause(){
        return mCause;
    }

    public String getMax(){
        return mMaximum;
    }

    public static List<Squad> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }

    public int getId() {
        return mId;
    }

    public static Squad find(int id) {
        return instances.get(id - 1);
    }

    public List<Hero> getHeroes() {
        return mHeroes;
    }

    public void addHero(Hero hero) {
        mHeroes.add(hero);
    }
}