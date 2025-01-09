import java.util.ArrayList;
import java.util.List;

public class Directory implements File{
    private String directoryName;
    private List<File> children;

    public Directory(String directoryName) {
        if(directoryName.isEmpty()){
            throw new IllegalArgumentException("É necessário definir um nome de pasta");
        }
        this.directoryName = directoryName;
        this.children = new ArrayList<>();
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public String getName() {
        return directoryName;
    }

    public void addChild(File file){
        children.add(file);
    }

    public void removeChild(File file){
        children.remove(file);
    }

    public List<File> getChild(){
        return children;
    }
}
