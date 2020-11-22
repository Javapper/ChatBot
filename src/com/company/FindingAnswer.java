package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class FindingAnswer {

    public static String getResponse(String message) {
        String changedMessage =
                String.join(" ", message.toLowerCase().split("[ {,|.}?]+"));

        for (Map.Entry<String, Key> o : DictionaryWordWithKey.entrySet()) {
            Pattern pattern = Pattern.compile(o.getKey());
            if (pattern.matcher(changedMessage).find()) {
                switch (o.getValue()) {
                    case greeting:
                        return Answer.getGreeting();
                    case mood:
                        return Answer.getMood();
                    case quote:
                        return Answer.getQuote();
                    case book:
                        return Answer.getBook();
                    case film:
                        return Answer.getFilm();
                    case song:
                        return Answer.getSong();
                    case dateAndTime:
                        Date date = new Date();
                        return date.toString();
                }
            }
        }
        return "";
    }

    private static final Map<String, Key> DictionaryWordWithKey = new HashMap<String, Key>() {{
        //greeting
        put("привет", Key.greeting);
        put("хай", Key.greeting);
        put("доброе\\s.*утро", Key.greeting);
        put("добрый\\s.*день", Key.greeting);
        put("добрый\\s.*вечер", Key.greeting);
        put("здравствуйте", Key.greeting);
        put("доброй\\s.*ночи", Key.greeting);
        put("добрейший\\s.*вечерочек", Key.greeting);
        put("приветики", Key.greeting);
        put("хаюхай", Key.greeting);
        put("доброго\\s.*времени\\s.*суток", Key.greeting);
        put("утречко", Key.greeting);
        put("hello", Key.greeting);
        put("hay", Key.greeting);
        put("good\\s.*morning", Key.greeting);

        //mood
        put("как\\s.*дела", Key.mood);
        put("как\\s.*ты", Key.mood);
        put("как\\s.*делишки", Key.mood);
        put("ты\\s.*как", Key.mood);
        put("всё\\s.*хорошо\\s.*?", Key.mood);
        put("ты\\s.*в\\s.*порядке", Key.mood);
        put("всё\\s.*окей\\s.*?", Key.mood);

        //quote
        put("цитата", Key.quote);
        put("цитату", Key.quote);
        put("цитаты", Key.quote);
        put("цитатка", Key.quote);
        put("цитатку", Key.quote);
        put("цитаки", Key.quote);

        //book
        put("книгу", Key.book);
        put("книга", Key.book);
        put("книги", Key.book);
        put("книжка", Key.book);
        put("книжку", Key.book);
        put("книжки", Key.book);
        put("почитать", Key.book);
        put("прочитать", Key.book);

        //film
        put("фильм", Key.film);
        put("фильмец", Key.film);
        put("кино", Key.film);
        put("киношка", Key.film);
        put("кинец", Key.film);
        put("посмотреть", Key.film);
        put("глянуть", Key.film);

        //song
        put("музыка", Key.song);
        put("музон", Key.song);
        put("музыку", Key.song);
        put("песня", Key.song);
        put("песню", Key.song);
        put("песенку", Key.song);
        put("трек", Key.song);
        put("трэк", Key.song);
        put("послушать", Key.song);
        put("прослушать", Key.song);
        put("слушать", Key.song);
        put("хит", Key.song);

        //dateAndTime
        put("время", Key.dateAndTime);
        put("времени", Key.dateAndTime);
        put("времечко", Key.dateAndTime);
        put("времечки", Key.dateAndTime);
        put("времечка", Key.dateAndTime);
        put("Дата", Key.dateAndTime);
        put("сегодня", Key.dateAndTime);
        put("сейчас", Key.dateAndTime);
        put("день", Key.dateAndTime);
        put("неделя", Key.dateAndTime);
        put("число", Key.dateAndTime);
    }};
}
