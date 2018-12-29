package patterns.proxy;

public interface IPerson {
    String getName();
    String getGender();
    String getInterests();
    int getRating();

    void setName(String name);
    void setGender(String gender);
    void setInterests(String interests);
    void setRating(int rating);
}
