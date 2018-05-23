
package final_quynhdinh;

public class SearchEngine {

    private String name;
    private String URL;

    public SearchEngine() {

    }

    public SearchEngine(String name, String URL) {
        setName(name);
        setURL(URL);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

}
