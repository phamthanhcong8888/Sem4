import 'dart:io';

class Song {
  String title;
  String artist;
  String album;
  int year;

  Song(this.title, this.artist, this.album, this.year);

  void displaySong() {
    print('Title: $title, Artist: $artist, Album: $album, Year: $year');
  }

  String getTitle() => title;
  void setTitle(String newTitle) => title = newTitle;
  
  String getArtist() => artist;
  void setArtist(String newArtist) => artist = newArtist;

  String getAlbum() => album;
  void setAlbum(String newAlbum) => album = newAlbum;

  int getYear() => year;
  void setYear(int newYear) => year = newYear;
}

List<Song> songList = [];

void addSong(String title, String artist, String album, int year) {
  songList.add(Song(title, artist, album, year));
  print("Song added successfully!");
}

void viewSongs() {
  if (songList.isEmpty) {
    print("No songs available.");
  } else {
    for (int i = 0; i < songList.length; i++) {
      print('Song ${i + 1}:');
      songList[i].displaySong();
    }
  }
}

void updateSong(int index, String newTitle, String newArtist, String newAlbum, int newYear) {
  if (index < 0 || index >= songList.length) {
    print("Invalid song index.");
  } else {
    songList[index].setTitle(newTitle);
    songList[index].setArtist(newArtist);
    songList[index].setAlbum(newAlbum);
    songList[index].setYear(newYear);
    print("Song updated successfully!");
  }
}

void deleteSong(int index) {
  if (index < 0 || index >= songList.length) {
    print("Invalid song index.");
  } else {
    songList.removeAt(index);
    print("Song deleted successfully!");
  }
}

void showMenu() {
  print("\n--- Favorite Music Manager ---");
  print("1. Add Song");
  print("2. View Songs");
  print("3. Update Song");
  print("4. Delete Song");
  print("5. Exit");
  print("Choose an option:");
}

void main() {
  while (true) {
    showMenu();
    String? choice = stdin.readLineSync();

    switch (choice) {
      case '1':
        print("Enter song title:");
        String title = stdin.readLineSync()!;
        print("Enter artist:");
        String artist = stdin.readLineSync()!;
        print("Enter album:");
        String album = stdin.readLineSync()!;
        print("Enter release year:");
        int year = int.parse(stdin.readLineSync()!);
        addSong(title, artist, album, year);
        break;

      case '2':
        viewSongs();
        break;

      case '3':
        print("Enter the song index to update:");
        int index = int.parse(stdin.readLineSync()!) - 1;
        print("Enter new title:");
        String newTitle = stdin.readLineSync()!;
        print("Enter new artist:");
        String newArtist = stdin.readLineSync()!;
        print("Enter new album:");
        String newAlbum = stdin.readLineSync()!;
        print("Enter new year:");
        int newYear = int.parse(stdin.readLineSync()!);
        updateSong(index, newTitle, newArtist, newAlbum, newYear);
        break;

      case '4':
        print("Enter the song index to delete:");
        int index = int.parse(stdin.readLineSync()!) - 1;
        deleteSong(index);
        break;

      case '5':
        print("Exiting...");
        return;

      default:
        print("Invalid choice. Please try again.");
    }
  }
}