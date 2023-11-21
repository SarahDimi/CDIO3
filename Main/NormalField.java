package Main;

abstract public class NormalField {
    String name;
    String type;
    int index;

   public NormalField(String name, int index, String type){
    this.name = name;
    this.index = index;
    this.type = type;
   }

    public String getType() {
        return type;
    }
    public int getIndex(){
        return index; 
    }
}
