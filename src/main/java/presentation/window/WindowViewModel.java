package presentation.window;

import data.rsa.RSA;
import domain.AnswerReceiver;
import domain.DecipherParamUseCase;
import domain.EncryptParamUseCase;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class WindowViewModel implements AnswerReceiver {

    private final DecipherParamUseCase decipherUseCase;
    private final EncryptParamUseCase encryptUseCase;

    private final StringProperty encryptedProperty = new SimpleStringProperty();
    private final StringProperty decodedProperty = new SimpleStringProperty();

    public WindowViewModel() {
        RSA rsa = new RSA();
        decipherUseCase = new DecipherParamUseCase(rsa, decodedProperty, this);
        encryptUseCase = new EncryptParamUseCase(rsa, encryptedProperty, this);
    }

    public void encAndDec(String message) {
        decipherUseCase.invoke(encryptUseCase.invoke(message));
    }

    public ObservableValue<String> getEncryptedProperty() {
        return encryptedProperty;
    }

    public ObservableValue<String> getDecodedProperty() {
        return decodedProperty;
    }

    @Override
    public void answer(Object object, StringProperty property) {
        property.setValue(String.valueOf(object));
    }
}
