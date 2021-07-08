/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keywordextract;

import keywordextract.RakeAlgorithm;
import keywordextract.SmartWords;
import keywordextract.RakeParams;    
import keywordextract.Result;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class KeywordExtractor {

    private static String delims = "[-,.?():;\"!/]";
    private static String posUrl = "C:/OpenNLP-v9/models/en-pos-maxent.bin";
    private static String sentUrl = "C:/OpenNLP-v9/models/en-sent.bin";

    public static void main(String[] args) throws IOException {
        InputStream stream = new FileInputStream("C:/stopwords.txt");
        String[] stopWords = (String[]) IOUtils.readLines(stream, "UTF-8").stream().toArray(String[]::new);
        String[] stopPOS = {"VB", "VBD", "VBG", "VBN", "VBP", "VBZ"};
        RakeParams params = new RakeParams(stopWords, stopPOS, 0, true, delims);
        RakeAlgorithm rakeAlg = new RakeAlgorithm(params, posUrl, sentUrl);
        System.out.println("Enter your text here:");
        Scanner inp=new Scanner(System.in);
        String sent=inp.nextLine();
        Result aRes = rakeAlg.rake(sent);
        System.out.println("\nKeywords are :\n");
        System.out.println(aRes);
    }
}