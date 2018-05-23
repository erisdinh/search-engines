package final_quynhdinh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SearchEngineModel {
    
    private ArrayList<SearchEngine> searchEngines = new ArrayList<>();
    private int count;
    
    public SearchEngineModel () {}

    public ArrayList<SearchEngine> getSearchEngines() {
        return searchEngines;
    }

    public void setSearchEngines(ArrayList<SearchEngine> searchEngines) {
        this.searchEngines = searchEngines;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    // read the file
    public void readFile() {
        
        try(BufferedReader br = new BufferedReader(new FileReader("SearchEngines.dat"))) {
            
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }

            // extract both the search engine names and URLs
            for(int i = 0; i < lines.size(); i++) {
                String[] tokens = lines.get(i).split("=");
                
                if(tokens.length == 2) {
                    String name = tokens[0].trim();
                    String URL = tokens[1].trim();
                    
                    SearchEngine searchEngine = new SearchEngine(name, URL);
                    searchEngines.add(searchEngine);
                }
            }
            count = searchEngines.size();
            System.out.println("Loaded: " + count + " search engines.");
            
        } catch (IOException e) {
            System.out.println("ERROR: File not found!");
        }
    }
}
