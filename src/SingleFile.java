public class SingleFile implements File{

    private String fileName;

    public SingleFile(String fileName) {
        if(fileName.isEmpty()){
            throw new IllegalArgumentException("É necessário definir um nome para o arquivo");
        }
        this.fileName = fileName;
    }

    @Override
    public boolean isFile() {
        return true;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public String getName() {
        return fileName;
    }
}
