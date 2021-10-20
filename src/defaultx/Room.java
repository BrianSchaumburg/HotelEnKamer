package defaultx;

public class Room{
    private String code;
    public enum soort
    {
       klassiekeKamer, suite, bruidSuite;
    }
    soort type;
    private double prijsPerNacht; private boolean isDoubleRoom;
    public Room(String code, soort type, double prijs, boolean IsDoubleRoom)
    {
        if(code.isBlank()|| type == null|| prijs < 0 )
            throw new IllegalArgumentException();
        this.code = code;
        this.prijsPerNacht = prijs ;
        this.type = type;
        this.isDoubleRoom = IsDoubleRoom;
    }
    public boolean getisDoubleRoom()
    {
        return this.isDoubleRoom;
    }

    public soort getType() { return type;
    }
    public double getPrijsPerNacht()
    {return prijsPerNacht;
    }
}