package insuliseweb.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI
public class MainUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new Label("Hallo"));
    }
}
