package pl.tomaszewski.demospringbootimageuploader.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.tomaszewski.demospringbootimageuploader.service.ImageUploaderService;

import java.io.IOException;

@Route("uploadImage")
public class UploadGui extends VerticalLayout {

    ImageUploaderService imageUploaderService;



    public UploadGui(ImageUploaderService imageUploader) {
        this.imageUploaderService = imageUploader;

        TextField textField = new TextField();
        Button button = new Button("upload");

        button.addClickListener(buttonClickEvent -> {
            try {
                imageUploader.uploadImage(textField.getValue());
            } catch (IOException e) {
                //todo
            }
        });
    }
}
