package models;

public enum Plataforma {
    PC("PC"),
    PC_WINDOWS("PC Windows"),
    MACOS("macOS"),
    LINUX("Linux"),

    PS2("PlayStation 2"),
    PS3("PlayStation 3"),
    PS4("PlayStation 4"),
    PS4_PRO("PlayStation 4 Pro"),
    PS5("PlayStation 5"),
    PS5_DIGITAL("PlayStation 5 Digital Edition"),
    PS5_PRO("PlayStation 5 Pro"),
    PSP("PlayStation Portable"),
    PS_VITA("PlayStation Vita"),

    XBOX_360("Xbox 360"),
    XBOX_ONE("Xbox One"),
    XBOX_ONE_S("Xbox One S"),
    XBOX_ONE_X("Xbox One X"),
    XBOX_SERIES_S("Xbox Series S"),
    XBOX_SERIES_X("Xbox Series X"),
    XBOX_SERIES_X_S("Xbox Series X/S"),

    WII("Nintendo Wii"),
    WII_U("Nintendo Wii U"),
    SWITCH("Nintendo Switch"),
    SWITCH_LITE("Nintendo Switch Lite"),
    SWITCH_OLED("Nintendo Switch OLED"),
    SWITCH_2("Nintendo Switch 2"),
    NINTENDO_DS("Nintendo DS"),
    NINTENDO_3DS("Nintendo 3DS"),

    ANDROID("Android"),
    IOS("iOS"),
    STEAM_DECK("Steam Deck");

    private final String nombre;

    Plataforma(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}