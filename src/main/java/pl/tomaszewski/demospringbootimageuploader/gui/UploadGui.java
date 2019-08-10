package pl.tomaszewski.demospringbootimageuploader.gui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.tomaszewski.demospringbootimageuploader.service.ImageUploaderService;

import java.io.IOException;

@Route("uploadImage")
public class UploadGui extends VerticalLayout {

    ImageUploaderService imageUploaderService;


    @Autowired
    public UploadGui(ImageUploaderService imageUploader){
        this.imageUploaderService = imageUploader;

        Label label = new Label();

        TextField textField = new TextField();
        Button button = new Button("upload");

        button.addClickListener(buttonClickEvent -> {

                String uploadedImageUrl = imageUploader.uploadImage(textField.getValue());
                Image image = new Image(uploadedImageUrl,"Nie ma obrazka");
                label.setText("Wgrany obrazek: "+uploadedImageUrl);
                add(label);
                add(image);
        });

        add(textField);
        add(button);
    }
}
