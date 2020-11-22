package com.company;

public class SimpleBot {

    public String sayInReturn(String message) {
        String returnMessage = FindingAnswer.getResponse(message);

        if (!(returnMessage.equals(""))) {
            return returnMessage;
        } else {
            return AnswerWithOutPattern(message);
        }
    }

    private String AnswerWithOutPattern(String message) {
        return  (message.trim().endsWith("?"))?
                Answer.getElusiveAnswer():
                Answer.getCommonPhrase();
    }
}
