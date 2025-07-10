class Trie
{
    Trie[] child;
    boolean isLeaf;
    public Trie()
    {
        child=new Trie[26];
        isLeaf=false;
    }
}
class Solution {
    Set<String> st;
    String max;
    public void insert(Trie t,String s)
    {
        for(char c:s.toCharArray())
        {
            if(t.child[c-'a']==null)
                t.child[c-'a']=new Trie();
            t=t.child[c-'a'];
        }
        t.isLeaf=true;
    }
    public void find(Trie t,String s)
    {
        if(s.length()>max.length())
            max=new String(s);
        for(int i=0;i<26;i++)
        {
            if(t.child[i]!=null && t.child[i].isLeaf)
                find(t.child[i],s+(char)(i+97));
        }
    }
    public String longestString(String[] arr) {
        Trie t=new Trie();
        max="";
        for(String x:arr)
            insert(t,x);
        find(t,"");
        return max;
    }
}