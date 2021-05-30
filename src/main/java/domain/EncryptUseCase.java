package domain;

import data.rsa.RSA;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

public class EncryptUseCase implements UseCase {

    private final RSA rsa;
    private final StringProperty encryptedProperty;
    private final AnswerReceiver answerReceiver;

    public EncryptUseCase(RSA rsa, StringProperty encryptedProperty, AnswerReceiver answerReceiver) {
        this.rsa = rsa;
        this.encryptedProperty = encryptedProperty;
        this.answerReceiver = answerReceiver;
    }

    @Override
    public Object invoke(Object object) {
        String message = (String) object;
        int[] encrypted = new int[message.length()];
        for (int i = 0; i < message.length(); i++) {
            encrypted[i] = rsa.encrypt(message.charAt(i));
        }
        answerReceiver.answer(Arrays.toString(encrypted), encryptedProperty);
        return encrypted;
    }
}
