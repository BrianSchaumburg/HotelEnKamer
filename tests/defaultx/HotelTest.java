package defaultx;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HotelTest {
Hotel hotel;
Room room ;
Kamer kamer ;
Ruimte ruimte;
    @Before
    public void setUp() throws Exception {
        hotel = new Hotel("Prive", 200);
        room =new Room("ccc", Room.soort.klassiekeKamer, 300, false);
        kamer = new Kamer("xxx", Room.soort.bruidSuite, 300);
        ruimte = new Ruimte("xxx",300); // is automatisch een klassieke kamer en een dubbelekamer
        hotel.kamerToevoegen(room);
        hotel.kamerToevoegen(kamer);
        hotel.kamerToevoegen(ruimte);
    }

@Test
public void kamerToevoegen() {

    assertEquals(hotel.aantalBezet(), 3);
    }

  @Test
    public void typeBerekening() {
       assertEquals(2, hotel.typeBerekening(Room.soort.klassiekeKamer));
    }

    @org.junit.Test
    public void gemiddeldePrijsPerNacht() {
        assertEquals(300, hotel.gemiddeldePrijsPerNacht(),00);
    }

    @org.junit.Test
    public void gemiddeldePrijsPerNachtPerType() {
        assertEquals(300,hotel.gemiddeldePrijsPerNachtPerType(Room.soort.klassiekeKamer),00);
    }

    @org.junit.Test
    public void aantal2persoonsKamer() {
        assertEquals(2, hotel.aantal2persoonsKamer()    );

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_constructortest_ingaveNaam()
    {
        hotel = new Hotel("", 200);
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_constructortest_ingave_negatieveTotaal()
    {
        hotel = new Hotel("Privé", -2);
    }
    @Test(expected = NullPointerException.class)
    public void test_kamerToevoegen_lege_kamer()
    {
        hotel.kamerToevoegen(null);
    }
    @Test(expected = IllegalStateException.class)
    public void test_kamerToevoegen_kamerVol()
    {
        hotel = new Hotel("Privé", 1);
        hotel.kamerToevoegen(room);
        hotel.kamerToevoegen(kamer);
    }
    @Test(expected = IllegalArgumentException.class)

    public void gemiddeldePrijsPerNachtPerType_leeg_type()
    {
        hotel.gemiddeldePrijsPerNachtPerType(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void gemiddeldePrijsPerNachtPerType_type_niet_aanwezig()
    {
        hotel.gemiddeldePrijsPerNachtPerType(Room.soort.suite);
    }

}