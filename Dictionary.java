import java.util.*;

public class Dictionary
{
    private Map<String, List<String>> dictionary;
    private Map<String, Integer> wordUsage;
    public Dictionary()
    {
        dictionary = new HashMap<>();
        wordUsage = new HashMap<>();
    }
    public void addWord(String word, List<String> translations)
    {
        dictionary.put(word, translations);
        wordUsage.put(word, 0);
    }
    public List<String> getTranslations(String word)
    {
        wordUsage.put(word, wordUsage.getOrDefault(word, 0) + 1);
        return dictionary.get(word);
    }
    public void addTranslation(String word, String translation)
    {
        dictionary.computeIfAbsent(word, k -> new ArrayList<>()).add(translation);
    }
    public void replaceTranslations(String word, List<String> newTranslations)
    {
        dictionary.put(word, newTranslations);
    }
    public void removeTranslation(String word, String translation)
    {
        List<String> translations = dictionary.get(word);
        if (translations != null)
        {
            translations.remove(translation);
            if (translations.isEmpty())
            {
                dictionary.remove(word);
            }
        }
    }
    public void removeWord(String word)
    {
        dictionary.remove(word);
        wordUsage.remove(word);
    }
    public List<String> getTop10PopularWords()
    {
        return wordUsage.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }
    public List<String> getTop10UnpopularWords()
    {
        return wordUsage.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }
    public void displayDictionary()
    {
        dictionary.forEach((word, translations) ->
        {
            System.out.println("Word: " + word + " Translations: " + translations);
        });
    }
}
