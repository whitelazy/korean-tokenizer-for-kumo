package io.github.whitelazy.nlp.tokenizer;

import com.kennycason.kumo.nlp.tokenizer.WordTokenizer;
import org.openkoreantext.processor.KoreanTokenJava;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer.KoreanToken;
import scala.collection.Seq;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KoreanTokenizer implements WordTokenizer {
    public List<String> tokenize(String s) {
        if(s == null) return Collections.emptyList();

        CharSequence nomalized = OpenKoreanTextProcessorJava.normalize(s);
        Seq<KoreanToken> rawTokens = OpenKoreanTextProcessorJava.tokenize(nomalized);
        return OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(rawTokens)
                .stream().filter(koreanTokenJava -> koreanTokenJava != null && koreanTokenJava.getPos().toString() == "Noun")
                .map(KoreanTokenJava::getText).collect(Collectors.toList());
    }
}
