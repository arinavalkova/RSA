package domain;

import data.rsa.RSA;
import javafx.beans.property.StringProperty;
import presentation.window.WindowViewModel;

import java.util.Arrays;

public class DecipherUseCase implements UseCase {

    private final RSA rsa;
    private final StringProperty decodedProperty;
    private final AnswerReceiver answerReceiver;

    public DecipherUseCase(RSA rsa, StringProperty decodedProperty, AnswerReceiver answerReceiver) {
        this.rsa = rsa;
        this.decodedProperty = decodedProperty;
        this.answerReceiver = answerReceiver;
    }

    @Override
    public Object invoke(Object object) {
        int[] message = (int[]) object;
        char[] decoded = new char[message.length];

        for(int i = 0; i < message.length; i++) {
            decoded[i] = (char) rsa.decode(message[i]);
        }
        answerReceiver.answer(Arrays.toString(decoded), decodedProperty);
        return null;
    }
}
