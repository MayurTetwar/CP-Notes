package Design;
import java.util.*;

public class FileSystem {
    Node root;
    class Node{
        String name;
        boolean isfile;
        StringBuilder content;
        HashMap<String,Node> child;
        Node(String name){
            this.name=name;
            this.isfile=false;
            this.content=new StringBuilder();
            child=new HashMap<>();
        }
    }
    FileSystem(){
        root=new Node("/");
    }
    public Node mkdir(String path){
        String[] level=path.split("/");
        Node curr=root;
        for(int i=1;i<level.length;i++){
            if(!curr.child.containsKey(level[i])){
                curr.child.put(level[i],new Node(level[i]));
            }
            curr=curr.child.get(level[i]);
        }
        return curr;
    }
    public List<String> ls(String path){
        Node curr = mkdir(path);
        List<String> result = new ArrayList<>();
        
        if (curr.isfile) {
            result.add(curr.name);
        } else {
            result.addAll(curr.child.keySet());
            Collections.sort(result);
        }
        return result;
    }
    public void addContentToFile(String filePath, String content){
        Node curr=mkdir(filePath);
        curr.isfile=true;
        curr.content.append(filePath);
    }
    public String readContentFromFile(String filePath){
        Node curr=mkdir(filePath);
        return curr.content.toString();
    }

    public static void main(String[] args) {
        String[] op=new String[]{"FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"};
        String[][] paths = {
            {},
            {"/"},
            {"/a/b/c"},
            {"/a/b/c/d", "hello"},
            {"/"},
            {"/a/b/c/d"}
        };
        FileSystem obj=new FileSystem();
        for(int i=0;i<op.length;i++){
            if(op[i].equals("FileSystem")){
            }else if(op[i].equals("ls")){
                System.out.println(obj.ls(paths[i][0]));
            }else if(op[i].equals("mkdir")){
                obj.mkdir(paths[i][0]);
            }else if(op[i].equals("addContentToFile")){
                obj.addContentToFile(paths[i][0], paths[i][1]);
            }else{
                System.out.println(obj.readContentFromFile(paths[i][0]));
            }
        }
    }

}
