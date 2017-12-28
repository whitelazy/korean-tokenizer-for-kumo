package io.github.whitelazy.nlp.tokenizer;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KoreanTokenizerTest {
    private static final String text = "역사에서 가장 중요한 것은 진실이다. 진실을 외면한 자리에서 길을 낼 수는 없다.";

    @Test
    public void tokenize() {
        KoreanTokenizer tokenizer = new KoreanTokenizer();
        assertEquals(10, tokenizer.tokenize(text).size());
    }

}
