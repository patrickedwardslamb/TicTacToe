public class Space {

    private boolean isNought;
    private boolean isCross;
    private boolean isEmpty;
    private String name = "▢";

    public Space(){
        this.isEmpty = true;
    }

    public boolean isEmpty(){
        return this.isEmpty;
    }

    public boolean isCross(){
        return isCross;
    }

    public boolean isNought(){
        return isNought;
    }

    public void setNought(){
        this.isNought = true;
        this.isEmpty = false;
        this.name = "O";
    }

    public void setCross(){
        this.isCross = true;
        this.isEmpty = false;
        this.name = "X";
    }

    public String toString(){
        return name;
    }


}
