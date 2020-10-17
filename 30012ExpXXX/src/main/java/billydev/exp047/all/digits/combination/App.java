package billydev.exp047.all.digits.combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {

    public static int count=0;
    public static void main(String[] args) {


        String input = "abcd";
        char[] charArray = input.toCharArray();
        int count = 0;

        /*
        * METHOD1:  this is hard coded version  <--NOT GOOD HARD CODED
        * */
        for (int i = 0; i < charArray.length; i++) {
            for (int i1 = 0; i1 < charArray.length; i1++) {

                for (int i2 = 0; i2 < charArray.length; i2++) {
//                    for (int i3 = 0; i3 < charArray.length; i3++) {
                        System.out.printf("%c", charArray[i]);
                        System.out.printf("%c", charArray[i1]);
                        System.out.printf("%c", charArray[i2]);
//                        System.out.printf("%c", charArray[i3]);
                        System.out.println();
                        System.out.println("count = " + count++);
//                    }
                }
            }
        }

        /*
        * METHOD2 : try to use my own method, NEED EXTERNAL CLASS NODE
        *
        * */
        Node node = new Node()   ;
        for (int i = 0; i <charArray.length ; i++) {
            ArrayList<Character> charList = new ArrayList<>();
            charList.add(charArray[i]);
            node.elements.add(charList);
        }

        ArrayList<ArrayList<Character>> tempList=null;
        ArrayList<Character> tempInnerList=null;
        ArrayList<Character> loopList=new ArrayList<>();

        for (char c : charArray) {
            loopList.add(c);
        }

        count=0;
        int LOOP_NUMBER=3;
        for (int i = 0; i <LOOP_NUMBER ; i++) {
            Node subNode=new Node();
            tempList=node.elements;
            for (int i1 = 0; i1 < tempList.size(); i1++) {
                for (int i2 = 0; i2 < loopList.size(); i2++) {
                    //the following loop processing like "aab" stuff
                    tempInnerList=new ArrayList<>();
                    for (int i3 = 0; i3 < tempList.get(i1).size(); i3++) {
                        tempInnerList.add(tempList.get(i1).get(i3)) ;
                    }
                    tempInnerList.add(loopList.get(i2));
                    subNode.elements.add(tempInnerList);
                }
            }
            node=subNode;
        }
        System.out.println("subNode size:"+node.elements.size()+" SubNode:" + node);


        /*
         *  METHOD3:  try method from blog
         * */
        System.out.println("======METHOD 3========");
        charArray=input.toCharArray();
        int k=charArray.length;
        int n=4;
        String prefix = "";
        listArrayCombination(charArray,prefix,k,n);

        /*
        * METHOD4: pure from blog
        * */
        System.out.println("======METHOD 4========");
        printAllKLengthRec(charArray, "", k, n);
    }



    static void printAllKLengthRec(char[] set,
                                   String prefix,
                                   int n, int k)
    {

        // Base case: k is 0,
        // print prefix
        if (k == 0)
        {
            System.out.println(prefix);
            return;
        }

        // One by one add all characters
        // from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < n; ++i)
        {

            // Next character of input added
            String newPrefix = prefix + set[i];

            // k is decreased, because
            // we have added a new character
            printAllKLengthRec(set, newPrefix,
                    n, k - 1);
        }
    }

    public static void listArrayCombination(char[] charArray,String prefix,int k, int n) {

        if (n == 0) {
            System.out.println("n="+n+" "+"count="+count++ +" "+prefix);
            return;
        }
        String newPrefix="";
        for (int i = 0; i < k; i++) {
            newPrefix = prefix+charArray[i];
            listArrayCombination(charArray,newPrefix,k,n-1);
//            if (n == 1) {
//                System.out.println();
//            }
        }
    }

}



class Node {
    @Override
    public String toString() {
        return "Node{" +
                "elements=" + elements +
                ", subNode=" + subNode +
                '}';
    }

    ArrayList<ArrayList<Character>> elements=new ArrayList<ArrayList<Character>>();
    Node subNode;

    public Node() {

    }


}
