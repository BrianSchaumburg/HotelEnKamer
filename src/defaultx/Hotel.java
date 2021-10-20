package defaultx;

import defaultx.Room;

import java.util.*;

public class Hotel {
private ArrayList<Room> rooms = new ArrayList<>() ;
private int totaalAantalKamers = 0 ;
private int aantalKamers = 0 ;

private String naam;
    public Hotel(String naam, int totaal )
    {
    if(naam.isBlank() )
        throw new IllegalArgumentException("controleer de naam");
        if (totaal < 0)  {
            throw new IllegalArgumentException("Dit aantal kan niet");
        }
    this.naam = naam;
    this.totaalAantalKamers = totaal;
    }
    public void kamerToevoegen(Room kamer)
    {
        if(kamer == null)
            throw new NullPointerException("De kamer is leeg");
    if(aantalKamers + 1 >totaalAantalKamers)
        throw new IllegalStateException("De kamers zitten vol");
        rooms.add(kamer);
        aantalKamers++;

    }
    public int typeBerekening(Room.soort type)
    {int counter = 0;
        for(int i = 0; i < rooms.size(); i ++ )
        {
            if(rooms.get(i).getType() == type)
                counter++;
        }
        return counter;
    }
    public double gemiddeldePrijsPerNacht()
    {double sum = 0;
         for(int i = 0; i < rooms.size(); i ++ )
         {
             sum += rooms.get(i).getPrijsPerNacht();
         }
         return sum/aantalKamers;
    }
    public double gemiddeldePrijsPerNachtPerType(Room.soort type)
    {   if(type == null )
            throw new IllegalArgumentException("Het type is leeg ");
        List<Room> lijst = rooms.stream().filter(c -> c.getType() == type).toList();
        if(lijst.size() == 0)
            throw new IllegalArgumentException("dit type bestaat niet ");
        double prijs=0;
        for(int i = 0; i < lijst.size(); i  ++ )
        {prijs+=lijst.get(i).getPrijsPerNacht();

        }
        return prijs/(lijst.size());
    }
    public int aantal2persoonsKamer()
    {
        List<Room> tweepersoonskamers = rooms.stream().filter(c ->c.getisDoubleRoom() == true).toList();
        return tweepersoonskamers.size();
    }
    public int aantalBezet()
    {
        return aantalKamers;
    }
}
