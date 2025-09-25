package Trie;

import java.util.ArrayList;
import java.util.List;

public class Wrod_Serach2 {

    public static void main(String[] args) {
        

    }

    public static class TrieNodeW{
        TrieNodeW[] next=new TrieNodeW[26];
        String word;
    }
    public static TrieNodeW build(String[] arr){
        TrieNodeW root=new TrieNodeW();
        for(String str:arr){
            TrieNodeW curr=root;
            for(char ch:str.toCharArray()){
                if(curr.next[ch-'a']==null)curr.next[ch-'a']=new TrieNodeW();
                curr=curr.next[ch-'a'];
            }
            curr.word=str;
        }
        return root;
    }
    public static void helper(TrieNodeW root,char[][] bor,int i,int j,List<String> list) {
        if(i<0 || j<0 || i>=bor.length || j>=bor[0].length)return;
        char ch=bor[i][j];
        if( ch=='#' || root.next[ch-'a']==null)return;
        if(root.word!=null){
            list.add(root.word);
            root.word=null;
        }
        bor[i][j]='#';
        helper(root, bor, i+1, j, list);
        helper(root, bor, i, j+1, list);
        helper(root, bor, i-1, j, list);
        helper(root, bor, i, j-1, list);
        bor[i][j]=ch;
    }
    public static List<String> findWords(char[][] bor, String[] arr) {
        List<String> list=new ArrayList<>();
        TrieNodeW root=build(arr);
        int n=bor.length;
        int m=bor[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                helper(root,bor,i,j,list);
            }
        }
        return list;
    }
}
