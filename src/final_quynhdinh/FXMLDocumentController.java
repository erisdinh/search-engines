package final_quynhdinh;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.web.WebView;

public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private ListView<SearchEngine> listView;
    @FXML
    private WebView webView;

    SearchEngineModel model;

    ArrayList<SearchEngine> searchEngines = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        model = new SearchEngineModel();
        
        // read searchEngines file
        model.readFile();
        
        searchEngines = model.getSearchEngines();

        // display searchEngine objects
        listView.setItems(FXCollections.observableList(searchEngines));

        // display searchEngine objects with name
        listView.setCellFactory(list -> {
            ListCell<SearchEngine> cell = new ListCell<SearchEngine>() {
                public void updateItem(SearchEngine searchEngine, boolean empty) {
                    super.updateItem(searchEngine, empty);
                    if (!empty) {
                        this.setText(searchEngine.getName());
                    }
                }
            };
            return cell;
        });

        // load the webpage with event handling (ChangeListener)
        listView.getSelectionModel().selectedItemProperty().addListener((o, oldValue, newValue) -> {
            String URL = listView.getSelectionModel().getSelectedItem().getURL();
            webView.getEngine().load(URL);
        });
    }

}
