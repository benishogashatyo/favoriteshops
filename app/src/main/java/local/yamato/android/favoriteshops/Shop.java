package local.yamato.android.favoriteshops;

public class Shop {
    private long _id;
    private String _name;
    private String _url;
    private String _tel;
    private String _note;

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        _url = url;
    }

    public String getTel() {
        return _tel;
    }

    public void setTel(String tel) {
        _tel = tel;
    }

    public String getNote() {
        return _note;
    }

    public void setNote(String note) {
        _note = note;
    }
}
