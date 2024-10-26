package ProjectOOPs;
import java.nio.Buffer;
import java.util.*;
import java.io.*;
import java.lang.*;

class Nodes{
    Character ch;
    Integer freq;
    Nodes left = null;
    Nodes right = null;
    public Nodes(Character ch,Integer freq){
        this.ch = ch;
        this.freq = freq;
    }
    public Nodes(Character ch,Integer freq,Nodes left,Nodes right){
        this.ch = ch;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanEncoding{

    public static void createHuffmanTree(String text){
        if(text == null || text.length() == 0)
            return;
        HashMap<Character,Integer> freq = new HashMap<>();

        for(char c : text.toCharArray())
            freq.put(c,freq.getOrDefault(c,0)+1);
        PriorityQueue<Nodes> pq = new PriorityQueue<>(Comparator.comparingInt(l->l.freq));

        for(var entry : freq.entrySet())
            pq.add(new Nodes(entry.getKey(),entry.getValue()));

        while (pq.size() != 1){
            Nodes left = pq.poll();
            Nodes right = pq.poll();
            int sum = left.freq + right.freq;
            pq.add(new Nodes(null,sum,left,right));
        }

        Nodes root = pq.peek();
        Map<Character,String> huffmanCode = new HashMap<>();

        encodeData(root,"",huffmanCode);

        System.out.println("Huffman Code of the Charecters are : "+huffmanCode);
        System.out.println("The Intial text : "+text);

        StringBuilder sb = new StringBuilder();

        for(char c : text.toCharArray())
            sb.append(huffmanCode.get(c));

        System.out.println("The Encoded String : "+sb);
        System.out.println("The Decoded String is : "+text);
        System.out.println("The initial size of the string is = "+text.toCharArray().length*8 +" Bytes");
        System.out.println("That String compressed to = "+sb.length()+" Bytes");
    }

    public static void encodeData(Nodes root,String str,Map<Character,String> huffman){
        if(root == null) return;

        if (isLeaf(root)) huffman.put(root.ch, str.length() > 0 ? str : "1");

        encodeData(root.left, str + '0', huffman);
        encodeData(root.right, str + '1', huffman);
    }

    public static boolean isLeaf(Nodes root){
        return root.left == null && root.right == null;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\bvars\\IdeaProjects\\OOPs Project\\src\\ProjectOOPs\\input.txt"), "UTF-8"))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            createHuffmanTree(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
