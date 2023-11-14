package Main;
public class FieldEffects {

    private Field[] tiles;

    public Board() {
        tiles = new Field[24];
        tiles[0] = new Field("start", 0, "board_Start_title",2);
        tiles[1] = new Field("ownable", 1,"board_McDonalds_title",1);
        tiles[2] = new Field("ownable", 1,"board_Pizzaria_title", 1);
        tiles[3] = new Field("chance", 0,"board_Chance_title",0);
        tiles[4] = new Field("ownable",2, "board_CandyShop_title",1);
        tiles[5] = new Field("ownable",2, "board_IceCreamShop_title",1);
        tiles[6] = new Field("jail",0, "board_VistingJail_title", 0);
        tiles[7] = new Field("ownable",3,"board_TheBluePlanet_title", 2);
        tiles[8] = new Field("ownable",3,"board_Library_title", 2);
        tiles[9] = new Field("chance",0,"board_Chance_title",0);
        tiles[10] = new Field("ownable",4,"board_Skatepark_title",2);
        tiles[11] = new Field("ownable",4,"board_Swimmingpool_title",2);
        tiles[12] = new Field("refuge",0,"board_FreeParking_title",0);
        tiles[13] = new Field("ownable",5,"board_Arcade_title",3);
        tiles[14] = new Field("ownable",5,"board_NordicFilm_title", 3);
        tiles[15] = new Field("chance",0,"board_Chance_title", 0);
        tiles[16] = new Field("ownable",6,"board_FaetterBR_title", 3);
        tiles[17] = new Field("ownable",6,"board_AnimalShelter_title", 3);
        tiles[18] = new Field("gotojail",0,"board_GoDirectlyToJail_title", 0);
        tiles[19] = new Field("ownable",7,"board_Bowlinghall_title", 4);
        tiles[20] = new Field("ownable",7,"board_Zoo_title",4);
        tiles[21] = new Field("chance",0,"board_Chance_title",0);
        tiles[22] = new Field("ownable",8,"board_Waterpark_title",5);
        tiles[23] = new Field("ownable",8,"board_SeafrontPromenade_title", 5);
    }

    public Field[] getFields() {
        return tiles;
    }
}
