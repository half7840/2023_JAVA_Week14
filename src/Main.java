import java.util.Scanner;
import java.util.Vector;

class Album {
    private String Title;
    private int Year;

    public Album(String Title, int Year) {
        this.Title = Title;
        this.Year = Year;
    }

    public String getTitle() {
        return Title;
    }

    public int getYear() {
        return Year;
    }
}

class Artist {
    private String Artist;
    private Vector<Album> Album;

    public Artist(String Artist) {
        this.Artist = Artist;
        this.Album = new Vector<>();
    }

    public void addAlbum(String Title, int Year) {
        Album album = new Album(Title, Year);
        Album.add(album);
        System.out.println("앨범 : " + "'" + Title + "'" + "이(가) " + Artist + "의 앨범에 추가되었습니다. ");
    }

    public void displayAlbum() {
        System.out.println(Artist + "의" + " 앨범 : ");
        for (Album album : Album) {
            System.out.println("- " + album.getTitle() + " (" + album.getYear() + ")");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("가수의 이름을 입력하세요. : ");
        String Artist = scanner.nextLine();

        Artist artist = new Artist(Artist);

        while (true) {
            System.out.print("앨범 이름을 추가하세요 (아무것도 입력하지 않으면 종료됩니다.): ");
            String Title = scanner.nextLine();

            if (Title.isEmpty()) {
                break;
            }

            System.out.print(Title + "의 발표 년도를 입력하세요. : ");
            int Year = scanner.nextInt();
            scanner.nextLine();  // 버퍼 비우기

            artist.addAlbum(Title, Year);
        }

        // 가수의 앨범 목록 출력
        artist.displayAlbum();
    }
}
