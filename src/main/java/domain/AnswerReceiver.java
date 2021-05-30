package domain;

import javafx.beans.property.StringProperty;

public interface AnswerReceiver {
    void answer(Object object, StringProperty property);
}
