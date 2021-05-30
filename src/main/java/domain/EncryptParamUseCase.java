package domain;

import data.rsa.RSA;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

public class EncryptParamUseCase implements ParamUseCase {

    private final RSA rsa;
    private final StringProperty encryptedProperty;
    private final AnswerReceiver answerReceiver;

    public EncryptParamUseCase(RSA rsa, StringProperty encryptedProperty, AnswerReceiver answerReceiver) {
        this.rsa = rsa;
        this.encryptedProperty = encryptedProperty;
        this.answerReceiver = answerReceiver;
    }

    @Override
    public Object invoke(Object object) {
        rsa.findKeys();
        String message = (String) object;
        int[] encrypted = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            encrypted[i] = rsa.encrypt(message.charAt(i));
        }
        answerReceiver.answer(Arrays.toString(encrypted), encryptedProperty);
        return encrypted;
    }
}
