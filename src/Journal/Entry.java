package Journal;

public class Entry {
    //the exact number of variables in Day One Journal .csv export
    public String[] data;




    public Entry(String[] data) {
        this.data = data;
    }



    //GETTER METHODS

    //date
    public String getDate() {
        return data[0];
    }
    //text
    public String getText() {
        return data[1];
    }
    //uuid
    public String getUUID() {
        return data[2];
    }
    //starred (favorite)
    public String getStarred() {
        return data[4];
    }


}
