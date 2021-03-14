package encrypt;

import java.util.HashMap;
import java.util.Map;

/*
描述:有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词死于字母表的下面，如下所示：
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。请实现下述接口，通过指定的密匙和明文得到密文。详细描述：接口说明：
原型：void encrypt(char * key,char * data,char * encrypt);
输入参数：
    char * key：密匙
    char * data：明文
输出参数：
    char * encrypt：密文
返回值：void   
知识点:  字符串  
题目来源:  内部整理  
练习阶段:  初级  
运行时间限制: 10Sec 
内存限制: 128MByte 
输入:先输入key和要加密的字符串  
输出:返回加密后的字符串  
样例输入: 
nihao
ni                    
样例输出: le
 */
public class KeywordEncrypt {
    public static void main(String[] args) {
        char[] key = "nihao".toUpperCase().toCharArray();
        char[] data = "ni".toCharArray();
        char[] encryptData = new char[data.length];
        encrypt(key, data, encryptData);
        for (int i = 0; i < encryptData.length; i++) {
            System.out.println(encryptData[i]);
        }
    }

    static void encrypt(char[] key, char[] data, char[] encryptData) {

        //根据密钥生成正伪字符映射
        String wordTab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<Character, Character> wordMap = new HashMap<>();
        int tabJ = 0;
        for (int i = 0; i < key.length; i++) {
            //关键词去重,映射关键词部分
            if (!wordMap.containsValue(key[i])) {
                wordMap.put(wordTab.charAt(tabJ), key[i]);
                tabJ++;
            }
        }
        //映射剩余部分
        for (int i = 0; i < wordTab.length(); i++) {
            if (!wordMap.containsValue(wordTab.charAt(i))) {
                wordMap.put(wordTab.charAt(tabJ), wordTab.charAt(i));
                tabJ++;
            }
        }

        for (int i = 0; i < data.length; i++) {
            if ('a' <= data[i] && data[i] <= 'z') {
                encryptData[i] = (char) (wordMap.get((char) (data[i] - 32)) + 32);
            } else if ('A' <= data[i] && data[i] <= 'Z') {
                encryptData[i] = wordMap.get(data[i]);
            } else {
                encryptData[i] = data[i];
            }
        }
    }

}
