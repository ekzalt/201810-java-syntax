package patterns.proxy;

public class Person implements IPerson {
    private String name;
    private String gender;
    private String interests;

    private int rating = 0;
    private int count = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public int getRating() {
        if (rating == 0) return 0;

        return rating / count;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public void setRating(int rating) {
        this.rating += rating;
        count++;
    }
}
